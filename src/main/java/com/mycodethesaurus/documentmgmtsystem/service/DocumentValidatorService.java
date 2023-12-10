package com.mycodethesaurus.documentmgmtsystem.service;

import com.mycodethesaurus.documentmgmtsystem.entity.DocumentEntity;
import com.mycodethesaurus.documentmgmtsystem.model.domain.Document;
import com.mycodethesaurus.documentmgmtsystem.model.DocumentRequestPayload;
import com.mycodethesaurus.documentmgmtsystem.model.DocumentResponsePayload;
import com.mycodethesaurus.documentmgmtsystem.repository.DocumentRepository;
import com.mycodethesaurus.documentmgmtsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DocumentValidatorService {

  private final DocumentRepository documentRepository;
  private final UserRepository userRepository;

  public DocumentValidatorService(
      DocumentRepository documentRepository, UserRepository userRepository) {
    this.documentRepository = documentRepository;
    this.userRepository = userRepository;
  }

  public DocumentResponsePayload validateDocumentAndSave(
      MultipartFile[] files, DocumentRequestPayload document) {

    DocumentEntity documentEntity = null;
    DocumentResponsePayload documentResponsePayload = new DocumentResponsePayload();

    Document[] savedDocumentArray = new Document[files.length];

    try {

      for (int i = 0; i < files.length; i++) {

        Document documentToBeSaved = new Document();

        documentToBeSaved.setName(document.getData()[i].getName());
        documentToBeSaved.setSize(document.getData()[i].getSize());

        documentToBeSaved.setEncrypted(document.getUploadedFileProperties().getEncrypted());
        documentToBeSaved.setPassword(document.getUploadedFileProperties().getPassword());
        documentToBeSaved.setUserId(document.getUploadedFileProperties().getUserId());

        documentEntity = saveDocumentEntity(convertDocumentToEntity(files[i], documentToBeSaved));

        Document savedDocument = new Document();

        if (documentEntity != null) {

          savedDocument.setId(String.valueOf(documentEntity.getId()));
          savedDocument.setName(documentEntity.getName());
          savedDocument.setType(documentEntity.getType());
          savedDocument.setSize(documentEntity.getSize());
          savedDocument.setUserId(documentEntity.getUser().getId());

          savedDocumentArray[i] = savedDocument;
        }
      }

      documentResponsePayload.setDocuments(savedDocumentArray);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return documentResponsePayload;
  }

  private DocumentEntity convertDocumentToEntity(MultipartFile file, Document document)
      throws IOException {
    DocumentEntity documentEntity = new DocumentEntity();

    documentEntity.setName(document.getName());
    documentEntity.setType(file.getContentType());

    documentEntity.setSize(document.getSize());
    documentEntity.setFileBlob(file.getBytes());

    documentEntity.setCreationDateTime(LocalDateTime.now());
    documentEntity.setLastModifiedDateTime(LocalDateTime.now());

    documentEntity.setEncrypted(false);
    documentEntity.setPassword(document.getPassword());

    userRepository
        .findById(document.getUserId())
        .ifPresentOrElse(
            documentEntity::setUser,
            () -> {
              // Handle the case when the user with the specified ID is not found
              // You can throw an exception, log a message, or handle it based on your requirements
              throw new RuntimeException("User with ID " + document.getUserId() + " not found");
            });

    return documentEntity;
  }

  public DocumentEntity saveDocumentEntity(DocumentEntity documentEntity) {
    return documentRepository.save(documentEntity);
  }
}
