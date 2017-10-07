package org.knowm.xchange.bitso.dto.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TickerFees {

  private final String book;
  private final BigDecimal feeDecimal;
  private final BigDecimal feePercent;

  public TickerFees(@JsonProperty("book") String book, @JsonProperty("fee_decimal") BigDecimal feeDecimal, @JsonProperty("fee_percent") BigDecimal
      feePercent) {
    this.book = book;
    this.feeDecimal = feeDecimal;
    this.feePercent = feePercent;
  }

  public String getBook() {
    return book;
  }

  public BigDecimal getFeeDecimal() {
    return feeDecimal;
  }

  public BigDecimal getFeePercent() {
    return feePercent;
  }
}
