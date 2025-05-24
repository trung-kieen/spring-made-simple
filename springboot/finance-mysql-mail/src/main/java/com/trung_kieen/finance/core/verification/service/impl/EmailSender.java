package com.trung_kieen.finance.core.verification.service.impl;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.core.constant.EndpointConstant;
import com.trung_kieen.finance.core.exception.ApplicationException;
import com.trung_kieen.finance.core.verification.service.IVerificationSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * EmailSender
 */
@Service
public class EmailSender implements IVerificationSender {
  private static final Logger logger = org.slf4j.LoggerFactory.getLogger(IVerificationSender.class);

  @Value("local.server.address")
  private String servername;

  @Value("local.server.port")
  private String port;

  @Autowired
  private JavaMailSender sender;

  public void send(String token, AppUser user) {
    final String subject = "Finance - Email verification";
    final String fromMail = "noreply@finnancetm@gmail.com";
    final String url = getVerificationUrl(token);
    final String mailContent = generateRegistrationEmailContent(user.getUsername(), url);

    MimeMessage message = null;
    try {
      message = sender.createMimeMessage();
      var messageHelper = new MimeMessageHelper(message);

      messageHelper.setFrom(fromMail);
      messageHelper.setTo(user.getEmail());
      messageHelper.setSubject(subject);
      messageHelper.setText(mailContent);
      sender.send(message);

    } catch (MessagingException e) {
      throw new ApplicationException("Fail to send verification to email for user",
          user,
          message);
    }

  }

  private String getApplicationUrl() {
    return "http://" + servername + ":" + port;
  }

  private String getVerificationUrl(String token) {

    /*
     * Example:
     * endpoint = "/api/auth/verfication?code=" + token
     */

    //String endpoint = MessageFormat.format(
    //    "{0}/{1}?{2}={3}",
    //    EndpointConstant.AUTH,
    //    EndpointConstant.AUTH_EMAIL_VERIFIED_SUFFIX,
    //    EndpointConstant.AUTH_EMAIL_REQUEST_CODE_PARAM,
    //    token);

    String endpoint = UriComponentsBuilder.fromHttpUrl(EndpointConstant.AUTH)
      .path(EndpointConstant.AUTH_EMAIL_VERIFIED_SUFFIX)
      .queryParam(EndpointConstant.AUTH_EMAIL_REQUEST_CODE_PARAM, token).build().toUriString();
    // TODO: debug this line of code
    logger.debug("CHECK URI for verified email: " + endpoint);

    return getApplicationUrl() + endpoint;
  }

  private String generateRegistrationEmailContent(String username, String verificationUrl) {
    return MessageFormat.format(
        "<p>Hi, {0},</p>" +
            "<p>Thank you for registering with us. Please, follow the link below to complete your registration.</p>" +
            "<a href=\"{1}\">Verify your email to activate your account</a>" +
            "<p>Thank you <br>Finance Team"
            ,
        username, verificationUrl);
  }

}
