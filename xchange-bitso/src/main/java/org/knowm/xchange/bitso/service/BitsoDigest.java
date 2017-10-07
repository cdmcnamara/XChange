package org.knowm.xchange.bitso.service;

import java.math.BigInteger;

import javax.crypto.Mac;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;

import org.knowm.xchange.service.BaseParamsDigest;

import si.mazi.rescu.RestInvocation;
import si.mazi.rescu.SynchronizedValueFactory;

public class BitsoDigest extends BaseParamsDigest {

  private final String apiKey;
  private final SynchronizedValueFactory nonceFactory;

  private BitsoDigest(String secretKeyHex, String apiKey, SynchronizedValueFactory<Long> nonceFactory) {
    super(secretKeyHex, HMAC_SHA_256);
    this.apiKey = apiKey;
    this.nonceFactory = nonceFactory;
  }

  public String generateSignature(String nonce, String method, String path, String body) {
    Mac mac256 = getMac();
    mac256.update(nonce.getBytes());
    mac256.update(method.getBytes());
    mac256.update(("/"+path).getBytes());
    if (method.equals("POST")) {
      mac256.update(body.getBytes());
    }

    return String.format("%064x", new BigInteger(1, mac256.doFinal()));
  }

  @Override
  public String digestParams(RestInvocation restInvocation) {
    final String nonce = this.nonceFactory.createValue().toString();
    return "Bitso " + apiKey + ":" + nonce + ":" + generateSignature(nonce, restInvocation.getHttpMethod(), restInvocation.getPath(),
        restInvocation.getRequestBody());
  }

  public static BitsoDigest createInstance(String secretKey, String apiKey, SynchronizedValueFactory<Long> nonceFactory) {
    return secretKey == null ? null : new BitsoDigest(secretKey, apiKey, nonceFactory);
  }
}
