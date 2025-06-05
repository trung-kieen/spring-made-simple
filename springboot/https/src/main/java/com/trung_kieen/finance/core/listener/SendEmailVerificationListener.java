package com.trung_kieen.finance.core.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.trung_kieen.finance.core.event.SendEmailVerificationEvent;
import com.trung_kieen.finance.core.verification.service.VerificationService;

import lombok.AllArgsConstructor;

/**
 * SendEmailVerificationListener
 * Create verification token, persitence in db
 * Send email to user
 */
@Component
@AllArgsConstructor
public class SendEmailVerificationListener implements ApplicationListener<SendEmailVerificationEvent> {

  @Autowired
  private VerificationService verificationService;

  @Override
  public void onApplicationEvent(SendEmailVerificationEvent event) {
    var emailVerifiedToken = verificationService.issueToken(event.getUser());
    verificationService.sendVerification(emailVerifiedToken, event.getUser());
  }

}
