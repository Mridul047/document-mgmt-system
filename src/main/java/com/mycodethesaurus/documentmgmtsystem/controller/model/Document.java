package com.mycodethesaurus.documentmgmtsystem.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
  private String id;
  private String name;
  private String type;
  private String size;
  private byte[] fileBlob;
  private LocalDateTime creationDateTime;
  private LocalDateTime modifiedDateTime;
  private boolean isEncrypted;
  private String password;
  private User user;
}
