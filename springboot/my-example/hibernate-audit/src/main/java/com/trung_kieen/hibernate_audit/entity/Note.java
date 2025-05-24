package com.trung_kieen.hibernate_audit.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Note
 */

/*
 * Use entity listener to ask jpa add value for property createAt and
 * lastModified before persistence
 */
@Entity
@Table(name = "notes")
@Builder
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createAt", "lastModified" }, allowGetters = true)
@Data
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  @NotBlank
  private String title;

  @Column
  @NotBlank
  private String content;

  // Use DATE for just date  @Temporal(TemporalType.DATE)
  // TIMESTAMP for including date time (as instant)
  @Temporal(TemporalType.TIMESTAMP)


  @Column(nullable = false, updatable = false, name = "create_at")

  @CreationTimestamp // Use for date and time
  protected Date createAt;

  @Temporal(TemporalType.TIMESTAMP)

  @Column(nullable = false, name = "last_modified")

  @LastModifiedDate
  protected Date lastModified;

  public Note() {
    super();
  }

  public Long getId() {
    return id;
  }

  public Note(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
