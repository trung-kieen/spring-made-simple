package com.trung_kieen.finance.core.verification.service;

import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.app.user.service.AppUserService;
import com.trung_kieen.finance.core.exception.ApplicationException;
import com.trung_kieen.finance.core.verification.VerificationRepository;
import com.trung_kieen.finance.core.verification.VerificationToken;
import com.trung_kieen.finance.core.verification.service.impl.EmailSender;

/**
 * VerificationService
 */
@Service
public class VerificationService {

  @Autowired
  /**
   * @see EmailSender
   */
  private IVerificationSender senderService;

  @Autowired
  private VerificationRepository tokenRepository;

  @Autowired
  private AppUserService userService;

  /**
   * Create new token tie to user, persistence and return token string to send
   * user via email
   * token is encoded
   */
  public String issueToken(AppUser user) {
    var token = new VerificationToken(user);
    tokenRepository.save(token);
    return encodeToken(token.getToken().toString());
  }

  /**
   * Delete all token issue by user when user is verified
   */
  public void clearToken(AppUser user) {
    // TODO
    tokenRepository.deleteAllByUser(user);
  }

  /**
   * @see #decodeToken(String)
   */
  private String encodeToken(String rawToken) {
    var encoded = new String(Base64.getEncoder().encode(rawToken.getBytes()));
    return encoded;
  }

  /**
   * @see #encodeToken(String)
   */
  private String decodeToken(String encodedToken) {
    var decoded = new String(Base64.getDecoder().decode(encodedToken.getBytes()));

    return decoded;
  }

  /**
   * Encode token to find verification object
   * Enable user to allow they login if token is valid
   */
  public void verify(String encodeToken) {

    var token = UUID.fromString(decodeToken(encodeToken));

    var verification = tokenRepository.findByToken(token)
        .orElseThrow(() -> new ApplicationException("Verification code is not valid"));

    var user = verification.getUser();

    if (user == null)
      throw new ApplicationException("User is not exist. Unable to verify");
    if (user.isVerified())
      throw new ApplicationException("User is already verified");
    if (verification.isExpire())
      throw new ApplicationException(
          "Verification code is expire. Please registration user again and remind to verify your account via email");
    userService.verifyUser(user);
  }

  public void sendVerification(String token, AppUser user) {
    senderService.send(token, user);
  }

  public void confirmToken(String token) {

  }

}
