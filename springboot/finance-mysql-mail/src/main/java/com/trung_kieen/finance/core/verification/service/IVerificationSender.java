package com.trung_kieen.finance.core.verification.service;

import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.core.verification.service.impl.EmailSender;

/**
 * IVerificationSender
 * @see EmailSender
 */

public interface IVerificationSender {
  void send(String token, AppUser user);
}
