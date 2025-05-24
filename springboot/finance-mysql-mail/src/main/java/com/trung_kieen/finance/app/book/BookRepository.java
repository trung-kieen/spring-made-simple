package com.trung_kieen.finance.app.book;

import org.springframework.stereotype.Repository;

import com.trung_kieen.finance.core.generic.BaseRepository;

/**
 * BookRepository
 */
@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
}
