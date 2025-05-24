package com.trung_kieen.jpa_advance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trung_kieen.jpa_advance.entity.Account;

/**
 * AccountRepository
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
