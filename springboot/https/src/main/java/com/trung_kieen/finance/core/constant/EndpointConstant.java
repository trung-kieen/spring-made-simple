package com.trung_kieen.finance.core.constant;

import com.trung_kieen.finance.core.verification.service.impl.EmailSender;

/**
 * EndpointConstant
 * Don't leave slash (/) at right conner
 * Don't use BASE = "/api/"
 * Use BASE = "/api"
 */
public class EndpointConstant {
  public static final String BASE = "/api";

  public static final String AUTH = BASE + "/" + "auth";
  /**
   * Sender email must use the same endpoint with api for verified user
   * email
   *
   * @see EmailSender
   */
  public static final String AUTH_EMAIL_VERIFIED_SUFFIX = "verify-email";
  public static final String AUTH_EMAIL_REQUEST_CODE_PARAM = "code";

}
