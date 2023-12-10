package com.mycodethesaurus.documentmgmtsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @Column(name = "access") // owner or viewer
  private String access;

  @Column(name = "creation_date_time")
  private LocalDateTime creationDateTime;
}
