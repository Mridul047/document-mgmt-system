package com.mycodethesaurus.documentmgmtsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadedFileProperties {
  private Boolean encrypted;
  private String password;
  private String userId;
}
