package org.bipin.gobble.lib.exceptions;
/**
 * @author bipin on 2020-05-01 11:09
 */
public class GobbleException extends RuntimeException {

  protected GobbleExceptionType gobbleExceptionType;

  public GobbleException(GobbleExceptionType gobbleExceptionType) {
    super(gobbleExceptionType.getDescription());
    this.gobbleExceptionType = gobbleExceptionType;
  }

  public GobbleExceptionType getExceptionType() {
    return gobbleExceptionType;
  }
}
