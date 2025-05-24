package com.trung_kieen.h2_with_hibernate;

import java.util.Iterator;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BookRepository
 */

public interface BookRepository extends JpaRepository<Book, Long> {
  Optional<Book> findByTitle(String title);

}
