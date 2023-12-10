package com.mycodethesaurus.documentmgmtsystem.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
  private String id;
  private String name;
  private String type;
  private String size;
  private Boolean encrypted;
  private String password;
  private String userId;
}
