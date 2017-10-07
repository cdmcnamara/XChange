package org.knowm.xchange.bitso.dto.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Matija Mazi
 */
public final class BitsoBalance {

  private final BigDecimal mxnBalance;

  private final BigDecimal btcBalance;

  private final BigDecimal xrpBalance;

  private final BigDecimal mxnReserved;

  private final BigDecimal btcReserved;

  private final BigDecimal xrpReserved;

  private final BigDecimal mxnAvailable;

  private final BigDecimal btcAvailable;

  private final BigDecimal xrpAvailable;

  private final BigDecimal fee;

  private final String error;

  public BitsoBalance(@JsonProperty("mxn_balance") BigDecimal mxnBalance, @JsonProperty("btc_balance") BigDecimal btcBalance, @JsonProperty("xrp_balance") BigDecimal xrpBalance,
      @JsonProperty("mxn_reserved") BigDecimal mxnReserved, @JsonProperty("btc_reserved") BigDecimal btcReserved, @JsonProperty("xrp_reserved") BigDecimal xrpReserved,
      @JsonProperty("mxn_available") BigDecimal mxnAvailable, @JsonProperty("btc_available") BigDecimal btcAvailable, @JsonProperty("xrp_available") BigDecimal xrpAvailable,
      @JsonProperty("fee") BigDecimal fee, @JsonProperty("error") String error) {

    this.mxnBalance = mxnBalance;
    this.btcBalance = btcBalance;
    this.xrpBalance = xrpBalance;
    this.mxnReserved = mxnReserved;
    this.btcReserved = btcReserved;
    this.xrpReserved = xrpReserved;
    this.mxnAvailable = mxnAvailable;
    this.btcAvailable = btcAvailable;
    this.xrpAvailable = xrpAvailable;
    this.fee = fee;
    this.error = error;
  }

  public BigDecimal getMxnBalance() {

    return mxnBalance;
  }

  public BigDecimal getBtcBalance() {

    return btcBalance;
  }

  public BigDecimal getMxnReserved() {

    return mxnReserved;
  }

  public BigDecimal getBtcReserved() {

    return btcReserved;
  }

  public BigDecimal getMxnAvailable() {

    return mxnAvailable;
  }

  public BigDecimal getBtcAvailable() {

    return btcAvailable;
  }

  public BigDecimal getXrpBalance() {
    return xrpBalance;
  }

  public BigDecimal getXrpReserved() {
    return xrpReserved;
  }

  public BigDecimal getXrpAvailable() {
    return xrpAvailable;
  }

  public BigDecimal getFee() {

    return fee;
  }

  public String getError() {

    return error;
  }

  @Override
  public String toString() {

    return String.format("Balance{mxnBalance=%s, btcBalance=%s, mxnReserved=%s, btcReserved=%s, mxnAvailable=%s, btcAvailable=%s, fee=%s}",
        mxnBalance, btcBalance, mxnReserved, btcReserved, mxnAvailable, btcAvailable, fee);
  }
}
