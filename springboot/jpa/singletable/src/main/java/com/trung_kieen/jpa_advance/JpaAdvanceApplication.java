package com.trung_kieen.jpa_advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trung_kieen.jpa_advance.entity.Account;
import com.trung_kieen.jpa_advance.entity.Checking;
import com.trung_kieen.jpa_advance.entity.Saving;
import com.trung_kieen.jpa_advance.repository.AccountRepository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaAdvanceApplication implements CommandLineRunner {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private EntityManager em;

  private final AccountRepository accountRepository;

  public static void main(String[] args) {
    SpringApplication.run(JpaAdvanceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var a1 = new Account(19230.23d);
    accountRepository.save(a1);

    var s1 = new Saving(1293012.23, 123.23);
    var c1 = new Checking(12332.42, 123.4);
    accountRepository.save(s1);
    accountRepository.save(c1);
  }

}
