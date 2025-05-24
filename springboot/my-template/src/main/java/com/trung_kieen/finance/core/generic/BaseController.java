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
 * BaseController define template for communicate data follow Restful API
 * Require to use with annotation `@RestController`, `@CrossOrigin`
 * Define base URL with `@RequestMapping`
 * Other bean: `@Tag`, `@Operation`
 *
 * @T Entity
 * @ID Indentity field use in entity
 */
@CrossOrigin("*")
public interface BaseController<T extends BaseEntity<T>, ID extends Serializable> {
}
