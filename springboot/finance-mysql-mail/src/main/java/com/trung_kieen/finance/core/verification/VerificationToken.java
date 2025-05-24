package com.trung_kieen.finance.core.verification;

import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.core.generic.BaseEntity;
import com.trung_kieen.finance.core.constant.SecurityConstant;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * VerificationToken
 */
@Entity(name = "verification_token")
@Table(name = "verification_token")
@Data
public class VerificationToken {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID token; // Get from random UUID

  private Date expire;

  private AppUser user;

  public VerificationToken(AppUser user) {
    this.user = user;
    var now = new Date();
    this.expire = new Date(now.getTime() + SecurityConstant.VERIFIED_EMAIL_EXPIRE_MS);
  }

  public UUID getToken() {
    return token;
  }

  public boolean isExpire() {
    return expire.before(new Date());
  }
  public AppUser getUser() {
    return user;
  }
}
