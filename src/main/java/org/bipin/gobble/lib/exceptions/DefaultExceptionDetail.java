package org.bipin.gobble.lib.exceptions;
/**
 * @author bipin on 2020-05-01 11:09
 */
public class DefaultExceptionDetail implements GobbleExceptionDetail {

  private String statusCode;
  private String description;

  public DefaultExceptionDetail(String statusCode, String description) {
    this.statusCode = statusCode;
    this.description = description;
  }

  @Override
  public String getStatusCode() {
    return statusCode;
  }

  @Override
  public String getDescription() {
    return description;
  }
}
