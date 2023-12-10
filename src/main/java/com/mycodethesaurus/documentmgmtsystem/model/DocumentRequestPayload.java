package com.mycodethesaurus.documentmgmtsystem.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequestPayload {
  private UploadedFile[] data;
  private UploadedFileProperties uploadedFileProperties;
}
