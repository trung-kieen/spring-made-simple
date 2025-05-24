package com.polling.polling.core.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.polling.polling.core.exception.NoSuchElementFoundException;

import jakarta.transaction.Transactional;

/**
 * BaseService
 */
// @Service
public abstract class BaseService<T extends BaseRepository<T, U>, U > {

  @Autowired
  private BaseRepository<T, U> baseReposity;

  <S extends T> S save(S entity) {
    return baseReposity.save(entity);
  }

  List<T> findAll() {
    return baseReposity.findAll();

  }

  <S extends T> Optional<T> findById(U id) {
    return baseReposity.findById(id);
  }

  long count() {
    return baseReposity.count();
  }

  public Page<T> getPage(Pageable pageable) {
    return baseReposity.findAll(pageable);
  }

  @Transactional
  public void delete(U id) {
    var entityOptional = baseReposity.findById(id);
    baseReposity.delete(entityOptional.orElseThrow(() -> new NoSuchElementFoundException("Unable to delete resource")));
  }

}
