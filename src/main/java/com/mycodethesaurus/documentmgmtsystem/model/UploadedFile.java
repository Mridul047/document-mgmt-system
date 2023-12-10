package com.mycodethesaurus.documentmgmtsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadedFile {
  private String name;
  private String size;
}
