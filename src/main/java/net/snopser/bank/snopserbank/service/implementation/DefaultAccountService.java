package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
