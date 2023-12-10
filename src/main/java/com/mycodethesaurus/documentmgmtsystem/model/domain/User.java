package com.mycodethesaurus.documentmgmtsystem.model.domain;

import com.mycodethesaurus.documentmgmtsystem.model.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String id;
  private String firstName;
  private String lastName;
  private Role role;
  private LocalDateTime creationDateTime;
}
