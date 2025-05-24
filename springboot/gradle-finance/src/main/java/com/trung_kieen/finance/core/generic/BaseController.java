package com.trung_kieen.finance.core.generic;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseController
 */
@CrossOrigin("*")
public abstract class BaseController<T extends BaseEntity<T>, ID extends Serializable> {

  @Autowired
  protected BaseService<T, ID, BaseRepository<T, ID>> baseService;

  @GetMapping("")
  public ResponseEntity<?> getPage(Pageable pageable) {
    // TOOD
    return ResponseEntity.ok(baseService.findAll());
  }

}
