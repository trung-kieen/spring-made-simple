package com.trung_kieen.finance.core.verification;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trung_kieen.finance.app.user.model.AppUser;

/**
 * VerificationRepository
 */
@Repository
public interface VerificationRepository extends JpaRepository<VerificationToken, Long> {
  Optional<VerificationToken> findByToken(UUID token);

  void deleteAllByUser(AppUser user);

  Optional<VerificationToken> findByUser(AppUser user);

}
