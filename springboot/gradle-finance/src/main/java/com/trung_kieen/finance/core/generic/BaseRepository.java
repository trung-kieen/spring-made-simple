package com.trung_kieen.finance.core.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


/**
 * BaseRepository
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<T>, ID extends Serializable>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

}
