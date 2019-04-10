package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.entity.Account;
import net.snopser.bank.snopserbank.model.Result;
import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    @Transactional
    public Result innerTransfer(BigInteger from, BigInteger to, BigDecimal count) {
        try {
            List<BigInteger> listAccountId = new ArrayList<>();
            listAccountId.add(from);
            listAccountId.add(to);
            List<Account> findAccounts = accountRepository.findAllById(listAccountId);
            findAccounts.forEach(account -> {
                if (account.getAccountId().equals(from)) {
                    account.setCount(account.getCount().subtract(count));
                }
                if (account.getAccountId().equals(to)) {
                    account.setCount(account.getCount().add(count));
                }
            });
            accountRepository.saveAll(findAccounts);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return Result.builder().messages(asList("все ок")).build();
    }

    @Override
    public Result outerTransfer(Integer from, Integer to, BigDecimal count) {
        return null;
    }
}
