package com.trung_kieen.finance.app.user.service;

import java.util.Optional;

import com.trung_kieen.finance.app.user.service.impl.AppUserServiceImpl;
import com.trung_kieen.finance.app.user.model.AppUser;
import com.trung_kieen.finance.app.web.payload.auth.RegisterDto;

/**
 * AppUserService
 */
public interface AppUserService {

  /**
   * Save user in to database and mark as not verified (not active yet)
   * Check if user is exist in database
   * User not exist then transfer register request to new user data and
   * save to database
   * User exist and expire verified token request () => Remove old user in
   * database then save request to new user
   * User not exist and not expire verified token then throw exception
   * and ask them to check email for verified account
   *
   * @see AppUserServiceImpl
   */
  AppUser save(RegisterDto registerDto);

  void verifyUser(String username);

  void verifyUser(AppUser user);

}
