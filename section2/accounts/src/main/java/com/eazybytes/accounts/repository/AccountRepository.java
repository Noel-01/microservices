package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long customerId);

    void deleteByCustomerId(Long customerId);
}
