package com.trung_kieen.finance.core.generic;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BaseEntity class extends {@link Serializable}
 * Need to defind as `@Entity` `@Table`
 * @T as entity class
 */

@MappedSuperclass
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseModel  implements Serializable {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name="Id", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID id;


  // @JsonSerialize(using = DateGenerator.class)
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  // @JsonSerialize(using = DateGenerator.class)
  @UpdateTimestamp
  @Column(name = "updated_at")
  private Date updatedAt;

}
