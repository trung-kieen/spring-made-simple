package com.trung_kieen.finance.core.event;

import org.springframework.context.ApplicationEvent;

import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.core.listener.SendEmailVerificationListener;

/**
 * SendEmailVerificationEvent
 * After event publish by publisher event will send to {@link SendEmailVerificationListener#onApplicationEvent(SendEmailVerificationEvent)}
 * to proccess action send email
 * Obsserver pattern
 */
public class SendEmailVerificationEvent extends ApplicationEvent {
  private AppUser user;

  /**
   * @see SendEmailVerificationListener
   */
  public SendEmailVerificationEvent(AppUser user) {
    super(user);
  }

  public AppUser getUser() {
    return user;
  }

}

