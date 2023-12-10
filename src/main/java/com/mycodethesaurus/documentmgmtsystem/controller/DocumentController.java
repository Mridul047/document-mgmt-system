package com.mycodethesaurus.documentmgmtsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycodethesaurus.documentmgmtsystem.model.DocumentRequestPayload;
import com.mycodethesaurus.documentmgmtsystem.service.DocumentValidatorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DocumentController {

  private final DocumentValidatorService documentValidatorService;

  public DocumentController(DocumentValidatorService documentValidatorService) {
    this.documentValidatorService = documentValidatorService;
  }

  @Component
  public static class StringToDocumentRequestPayloadConverter
      implements Converter<String, DocumentRequestPayload> {
    @Autowired private ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public DocumentRequestPayload convert(String source) {
      return objectMapper.readValue(source, DocumentRequestPayload.class);
    }
  }

  @PostMapping("/docs")
  public ResponseEntity<?> saveDocs(
      @RequestParam("file") MultipartFile[] file,
      @RequestParam("document") DocumentRequestPayload document)
      throws IOException {

    var doc = documentValidatorService.validateDocumentAndSave(file, document);

    return ResponseEntity.ok().body(doc);
  }
}
