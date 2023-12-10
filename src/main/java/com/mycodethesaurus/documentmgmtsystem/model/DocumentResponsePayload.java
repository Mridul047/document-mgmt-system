package com.mycodethesaurus.documentmgmtsystem.model;

import com.mycodethesaurus.documentmgmtsystem.model.domain.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponsePayload {
  private Document[] documents;
}
