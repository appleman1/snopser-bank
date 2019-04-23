package net.snopser.bank.snopserbank.controller;

import net.snopser.bank.snopserbank.entity.Client;
import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;
import net.snopser.bank.snopserbank.service.implementation.DefaultAccountService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.util.Arrays.asList;

/**
 * @author Виктор Фалькенберг
 */

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final DefaultAccountService accountService;

    public TransferController(DefaultAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/inner")
    public Result innerTransfer(@RequestBody Operation operation, @AuthenticationPrincipal Client client) {
        return accountService.innerTransfer(operation.setClient(client));
    }
}
