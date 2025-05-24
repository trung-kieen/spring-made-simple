package com.trung_kieen.finance.core.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import org.springframework.stereotype.Service;

/**
 * BaseService
 */
@Service
/*
 * T for entity class
 * U for serializable type for identity of this class like Long or UUID
 * Use K for pass type argumenet make type BaseRepository<T, U> for
 * avoid non-static >< static type
 */
public abstract class BaseService<T extends BaseEntity<T>, U extends Serializable, K extends BaseRepository<T, U>> {

  @Autowired
  protected BaseRepository<T, U> baseRepository;

  List<T> findAll() {
    return baseRepository.findAll();
  }

  Page<T> findAll(Pageable pageable) {
    return baseRepository.findAll(pageable);
  }

  <S extends T> S save(S entity) {
    return baseRepository.save(entity);
  }


  // TODO
  <S extends T> S update(S entity) {
    return baseRepository.save(entity);
  }

  <S extends T> void delete(S entity) {
    baseRepository.delete(entity);
  }

  void delete(U id) {
    baseRepository.deleteById(id);
  }

  T findById(U id) {
    return baseRepository.findById(id).orElseThrow();
  }

}
