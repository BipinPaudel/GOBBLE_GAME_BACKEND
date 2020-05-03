package org.bipin.gobble.repositories.helpers;

/**
 * @author bipin on 2020-04-27 13:07
 */
public enum Constants {
  VISITED('*'),
    ;
    private char code;

   Constants(char code) {
    this.code = code;
  }

  public char getCode() {
    return code;
  }
}
