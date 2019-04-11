package net.snopser.bank.snopserbank.validation;

import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public class DefaultValidator implements Validator {

    private final List<ValidationRule> listRule;

    public DefaultValidator(List<ValidationRule> listRule) {
        this.listRule = listRule;
    }

    @Override
    public void validate() {

    }
}
