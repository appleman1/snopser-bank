package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.repository.ClientRepository;
import net.snopser.bank.snopserbank.service.ClientService;
import org.springframework.stereotype.Service;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultClientService implements ClientService {
    private final ClientRepository clientRepository;

    public DefaultClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
