package com.trung_kieen.finance.app.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trung_kieen.finance.core.constant.EndpointConstant;
import com.trung_kieen.finance.core.generic.BaseAbstractController;

/**
 * BookController
 */
@RestController
@RequestMapping( EndpointConstant.BASE+ "/book/")
public class BookController extends BaseAbstractController<Book, Long> {
  public BookController() {
    super();
  }

  @GetMapping
  @Override
  public ResponseEntity<?> getPage() {
    List<Book> entities = baseService.findAll();
    var a = baseService.findById(1L);
    System.out.println(a);

    System.out.println(entities);
    return ResponseEntity.ok(baseService.findAll());
  }
}
