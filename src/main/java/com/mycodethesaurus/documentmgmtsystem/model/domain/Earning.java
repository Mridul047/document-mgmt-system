package com.mycodethesaurus.documentmgmtsystem.model.domain;

import com.mycodethesaurus.documentmgmtsystem.model.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Earning {
  private String id;
  private String type;
  private String mode;
  private String companyName;
  private BigDecimal amountAfterTax;
  private BigDecimal amountBeforeTax;
  private String financialYear;
  private Document[] document;
  private User user;
}
