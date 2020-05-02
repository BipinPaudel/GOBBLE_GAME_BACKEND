package org.bipin.gobble.lib.utils;

import java.util.HashMap;
import java.util.Map;

public class TokenUpdateRequest {

  private String subject;

  private Map<String, String> claims;

  public TokenUpdateRequest() {
    this.claims = new HashMap<>();
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void addClaim(String key, String val) {
    this.claims.put(key, val);
  }

  public Map<String, String> getClaims() {
    return claims;
  }
}
