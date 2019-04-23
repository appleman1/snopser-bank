package net.snopser.bank.snopserbank.repository;

import net.snopser.bank.snopserbank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Виктор Фалькенберг
 */
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByLogin(String login);
}
