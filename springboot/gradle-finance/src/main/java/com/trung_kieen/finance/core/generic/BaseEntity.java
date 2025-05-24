package com.trung_kieen.finance.core.generic;

import java.io.Serializable;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/**
 * BaseEntity
 */
@Data
@MappedSuperclass
public abstract class BaseEntity<T>  implements Serializable {
  @Id
  private Long id;

}
