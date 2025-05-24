package com.trung_kieen.finance.app.book;

import org.springframework.stereotype.Service;

import com.trung_kieen.finance.core.generic.BaseAbstractService;
import com.trung_kieen.finance.core.generic.BaseRepository;
import com.trung_kieen.finance.core.generic.BaseService;

import lombok.AllArgsConstructor;

/**
 * BookService
 */
@Service
@AllArgsConstructor
public class BookService extends BaseAbstractService<Book, Long, BaseRepository<Book, Long>> {
}
