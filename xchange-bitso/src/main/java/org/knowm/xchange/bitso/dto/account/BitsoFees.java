package org.knowm.xchange.bitso.dto.account;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Matija Mazi
 */
public final class BitsoFees {

  private final List<TickerFees> fees;

  private final String error;

  public BitsoFees(@JsonProperty("fees") List<TickerFees> fees, @JsonProperty("error") String error) {
    this.fees = fees;
    this.error = error;
  }

  public List<TickerFees> getFees() {
    return fees;
  }

  public String getError() {

    return error;
  }
}
