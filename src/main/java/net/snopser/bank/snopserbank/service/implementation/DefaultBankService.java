package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.repository.BankRepository;
import net.snopser.bank.snopserbank.service.BankService;
import org.springframework.stereotype.Service;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultBankService implements BankService {
    private final BankRepository bankRepository;

    public DefaultBankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
}
