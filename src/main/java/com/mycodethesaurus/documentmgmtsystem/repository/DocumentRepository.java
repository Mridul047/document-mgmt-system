package com.mycodethesaurus.documentmgmtsystem.repository;

import com.mycodethesaurus.documentmgmtsystem.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, String> {}
