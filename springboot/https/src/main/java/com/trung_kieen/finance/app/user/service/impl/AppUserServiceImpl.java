package com.trung_kieen.finance.app.user.service.impl;

import com.trung_kieen.finance.app.user.converter.AppUserMapper;
import com.trung_kieen.finance.app.user.model.AppUser;
import org.springframework.stereotype.Service;
import com.trung_kieen.finance.core.verification.VerificationRepository;
import com.trung_kieen.finance.core.verification.VerificationToken;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.trung_kieen.finance.app.web.payload.auth.RegisterDto;
import com.trung_kieen.finance.core.exception.ApplicationException;
import com.trung_kieen.finance.app.user.repository.AppUserRepository;
import com.trung_kieen.finance.app.user.service.AppUserService;

/**
 * AppUserServiceImpl
 *
 * @see AppUserService
 */
@Service
public class AppUserServiceImpl implements AppUserService {
  private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AppUserServiceImpl.class);

  private final AppUserRepository userRepository;

  private final AppUserMapper userMapper;
  private final VerificationRepository verificationRepository;

  private IllegalArgumentException illegalArgumentException;

  @Autowired
  public AppUserServiceImpl(final AppUserRepository userRepository, final AppUserMapper userMapper,
      final VerificationRepository verificationRepository) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.verificationRepository = verificationRepository;
  }

  /**
   * {@inheritDoc}
   */
  public AppUser save(final RegisterDto registerDto) {

    AppUser appUser = null;
    final Optional<AppUser> matchUser = userRepository.findByUsername(registerDto.username());

    final boolean isUserExists = matchUser.isPresent();
    if (!isUserExists) {
      return saveRegisterRequestAsUser(registerDto);
    } else {

      appUser = matchUser.get();

      if (appUser.isVerified())
        throw new ApplicationException("Username is taken");

      final Optional<VerificationToken> matchToken = verificationRepository.findByUser(appUser);
      final boolean isTokenExists = matchToken.isPresent();
      if (!isTokenExists) {
        logger.info("Unknow verified token for user with a not verified user in database");
        throw new ApplicationException("Unable to register for this account", matchToken, matchUser);
      } else {
        // Exist token => check token
        final var verifiedToken = matchToken.get();
        if (verifiedToken.isExpire()) {
          // Delete old user is not verified and token is expire
          // then save new user from register page
          userRepository.delete(appUser);
          verificationRepository.delete(verifiedToken);
          return saveRegisterRequestAsUser(registerDto);
        } else {
          throw new ApplicationException("Please check verification email in spam for finish registration");
        }
      }

    }
  }

  public void verifyUser(final String username) {
    // int rowUpdate = userRepository.updateVerified(username);
    final int rowUpdate = 1;
    if (rowUpdate == 1) {
      illegalArgumentException = new IllegalArgumentException("Expect verify for 1 user but passing 2 instead");
      throw illegalArgumentException;

    }
  }

  public void verifyUser(final AppUser user) {
    verifyUser(user.getUsername());
  }

  private AppUser saveRegisterRequestAsUser(final RegisterDto registerDto) {
    final var appUser = userMapper.toAppUser(registerDto);
    return userRepository.save(appUser);

  }

}
