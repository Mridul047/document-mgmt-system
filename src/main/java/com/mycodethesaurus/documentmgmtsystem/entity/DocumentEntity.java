package com.mycodethesaurus.documentmgmtsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private String type;

  @Column(name = "size")
  private String size;

  @Lob
  @Column(name = "attached_file", columnDefinition = "LONGBLOB")
  private byte[] fileBlob;

  @Column(name = "creation_date_time")
  private LocalDateTime creationDateTime;

  @Column(name = "last_modified_date_time")
  private LocalDateTime lastModifiedDateTime;

  @Column(name = "encrypted")
  private Boolean encrypted;

  @Column(name = "password")
  private String password;

  @ManyToOne
  @JoinColumn(name = "user_id") // Assuming a ManyToOne relationship with UserEntity
  private UserEntity user;
}
