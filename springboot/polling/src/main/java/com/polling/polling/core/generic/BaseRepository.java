package com.polling.polling.core.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * BaseRepository
 */
@NoRepositoryBean
public interface BaseRepository<T, S> extends JpaRepository<T, S> {
}
