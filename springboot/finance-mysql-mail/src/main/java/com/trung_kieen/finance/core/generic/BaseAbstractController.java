package com.trung_kieen.finance.core.generic;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * BaseAbstractController define template for communicate data follow Restful
 * API
 * for common action for get all, get single, create, update, delete
 * endpoint for data entity
 * Require to use with annotation `@RestController`
 * Define base URL with `@RequestMapping`
 * Other bean: `@Tag`, `@Operation`
 *
 * @T Entity
 * @ID Indentity field use in entity
 */
@CrossOrigin("*")
public abstract class BaseAbstractController<T extends BaseEntity<T>, ID extends Serializable>
    implements BaseController<T, ID> {

  @Autowired
  protected BaseAbstractService<T, ID, BaseRepository<T, ID>> baseService;

  @GetMapping
  public ResponseEntity<?> getPage() {
    var entites = baseService.findAll();
    return ResponseEntity.ok(entites);
  }

  @GetMapping("{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public T getSingle(@PathVariable ID id) {
    return baseService.findById(id);
  }

  /**
   * Remind to create element with new id by passing DTO object instead
   * of T (entity)
   */
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public BaseEntity<T> create(@RequestBody T t) {
    return baseService.save(t);
  }

  @PutMapping
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void update(T t) {
    baseService.update(t);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete(@PathVariable ID id) {
    baseService.delete(id);
  }

}
