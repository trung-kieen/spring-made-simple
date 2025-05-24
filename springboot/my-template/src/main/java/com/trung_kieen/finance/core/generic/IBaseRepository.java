package com.trung_kieen.finance.core.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * BaseRepository
 * Make sure mark class as @Repository
 * @T for entity
 * @T ID for type as primarykey
 */
@NoRepositoryBean
public interface IBaseRepository<T , ID extends Serializable>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
  List<T> findAll(Sort sort);
  Page<T> findAll(Pageable pageable);

}
