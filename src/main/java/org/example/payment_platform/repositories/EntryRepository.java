package org.example.payment_platform.repositories;

import org.example.payment_platform.entities.Entry;
import org.example.payment_platform.entities.LedgerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry,Long> {

    List<Entry> findAllByTransaction(LedgerTransaction transaction);
}
