
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
 * BaseService
 * Make sure mark class as `@Service`, `@AllArgsConstructor`
 *
 * @T Entity class
 * @U Indetity field
 * @K BaseRepository
 */
public interface BaseService<T extends BaseEntity<T>, U extends Serializable> {

}
