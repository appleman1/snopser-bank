package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service("snopser-default-validator")
public class DefaultValidator implements Validator {

    private final List<? extends ValidationRule> listRule;


    public DefaultValidator(List<ValidationRule> listRule) {
        this.listRule = listRule;
    }

    @Override

    public Result validate(Operation operation) {
        Set<String> listErrorsRule = listRule.stream()
                .map(validationRule -> {
                    if (validationRule instanceof ValidationRuleDecorator) {
                        List<String> check = validationRule.check(operation);
                        if (check.isEmpty()) {
                            check.addAll(((ValidationRuleDecorator) validationRule).newCheck(operation));
                            return check;
                        }
                        return check;
                    }
                    return validationRule.check(operation);
                })
                .filter(list -> !list.isEmpty())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        return Result.builder()
                .messages(listErrorsRule)
                .build();
    }
}

