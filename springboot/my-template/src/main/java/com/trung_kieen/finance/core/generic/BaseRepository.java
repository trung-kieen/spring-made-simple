package com.trung_kieen.finance.core.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.NoArgsConstructor;

/**
 * BaseRepository
 */
@Repository
@NoArgsConstructor
@Component
public class BaseRepository<T, ID extends Serializable> implements IBaseRepository<T, ID> {



}
