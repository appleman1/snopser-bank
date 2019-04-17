package net.snopser.bank.snopserbank.controller;

import net.snopser.bank.snopserbank.model.Result;
import net.snopser.bank.snopserbank.service.implementation.DefaultAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.util.Arrays.asList;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final DefaultAccountService accountService;

    public TransferController(DefaultAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/inner")
    public Result innerTransfer(@RequestParam BigInteger from, @RequestParam BigInteger to, @RequestParam BigDecimal count) {
        return accountService.innerTransfer(from, to, count);
    }
}
