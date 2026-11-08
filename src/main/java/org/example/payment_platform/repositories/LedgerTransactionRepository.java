package org.example.payment_platform.repositories;

import org.example.payment_platform.entities.LedgerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerTransactionRepository extends JpaRepository<LedgerTransaction,Long> {

}
