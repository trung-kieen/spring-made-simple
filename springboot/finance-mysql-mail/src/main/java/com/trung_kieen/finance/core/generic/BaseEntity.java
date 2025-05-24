package com.trung_kieen.finance.core.generic;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * BaseEntity class extends {@link Serializable}
 * Need to defind as `@Entity` `@Table`
 * @T as entity class
 */

@MappedSuperclass
public abstract class BaseEntity<T>  implements Serializable {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column
    //private Long id;
    //
    //// Getters and setters
    //public Long getId() {
    //    return id;
    //}
    //
    //public void setId(Long id) {
    //    this.id = id;
    //}

}
