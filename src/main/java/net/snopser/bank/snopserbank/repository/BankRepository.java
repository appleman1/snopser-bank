package net.snopser.bank.snopserbank.repository;

import net.snopser.bank.snopserbank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Виктор Фалькенберг
 */
public interface BankRepository extends JpaRepository<Bank, UUID> {
}
