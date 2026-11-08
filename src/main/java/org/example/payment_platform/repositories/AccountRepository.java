package org.example.payment_platform.repositories;

import org.example.payment_platform.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
