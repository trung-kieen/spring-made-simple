package com.trung_kieen.finance.core.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import lombok.AllArgsConstructor;

/**
 * BaseAbstractService
 * Make sure mark class as `@Service`, `@AllArgsConstructor`
 *
 * @T for entity class
 * @U for serializable type for identity of this class like Long or UUID
 * @K for pass type argumenet make type BaseRepository<T, U> for
 *    avoid non-static >< static type
 */
public abstract class BaseAbstractService<T extends BaseEntity<T>, U extends Serializable, K extends BaseRepository<T, U>>
    implements BaseService<T, U> {

  @Autowired
  protected BaseRepository<T, U> baseRepository;

  public List<T> findAll() {
    return baseRepository.findAll();
  }

  public Page<T> findAll(Pageable pageable) {
    return baseRepository.findAll(pageable);
  }

  public T save(T entity) {
    return baseRepository.save(entity);
  }

  public void update(T entity) {
    baseRepository.save(entity);
  }

  public <S extends T> void delete(S entity) {
    baseRepository.delete(entity);
  }

  public void delete(U id) {
    baseRepository.deleteById(id);
  }

  public T findById(U id) {
    return baseRepository.findById(id).orElseThrow();
  }

}
