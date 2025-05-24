package com.example.the_open_book.token;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * TokenServiceImpl
 */
@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

  @Autowired
  private TokenRepository tokenRepository;

  @Override
  public Optional<Token> findByToken(String tokenCode) {
    return tokenRepository.findByToken(tokenCode);
  }


  @Override
  public Token save(Token token) {
    return tokenRepository.save(token);
  }


  @Override
  public void activeUserMatchToken(Token token) {
    tokenRepository.activateUser(token.getTokenId());
  }




}
