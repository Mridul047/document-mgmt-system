package com.mycodethesaurus.documentmgmtsystem.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
  private String id;
  private String access;
  private LocalDateTime creationDateTime;
}
