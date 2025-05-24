package com.polling.polling.core.auth.jwt;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.polling.polling.core.constant.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;

/**
 * JwtService or common name as JwtUtils
 * Use for create token from authentication object, and verify token when user request
 */
@Component
@RequiredArgsConstructor
public class JwtService {
  private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

  @Value("${jwt.token.secret}")
  private String secret;

  private SecretKey getSigningKey() {

    byte[] keyBytes = Decoders.BASE64.decode(this.secret);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public String[] extractRoles(String token) {
    return extractAllClaims(token).get("roles", String[].class);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public Claims extractAllClaims(String token) {
    return Jwts
        .parser()
        .verifyWith(getSigningKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    // Finally we get our subject like .getPayload().getSubject();
  }

  public String generateToken(Authentication authentication) {

    final String username = authentication.getName();
    String[] roles = authentication.getAuthorities().stream().map(Object::toString).toArray(String[]::new);
    final Date currentDate = new Date();
    final Date expireDate = new Date(currentDate.getTime() +
        SecurityConstant.JWT_EXPIRE_MS);

    return Jwts.builder()
        .subject(username)
        .claim("roles", roles)
        .issuedAt(currentDate)
        .expiration(expireDate)
        .signWith(getSigningKey())
        .compact();

  }

  public boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public boolean isValidToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    final Boolean validClaimsInformation = username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    if (!validClaimsInformation) {
      return false;
    }

    try {
      Jwts.parser()
          .verifyWith(getSigningKey())
          .build()
          .parseSignedClaims(token);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return true;
  }



}
