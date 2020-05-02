package org.bipin.gobble.repositories;

import org.bipin.gobble.lib.exceptions.GobbleExceptionType;
import org.bipin.gobble.lib.mappers.AppException;

/**
 * @author bipin on 2020-05-01 16:49
 */
public class ExceptionManager extends AppException {
  public ExceptionManager(GobbleExceptionType gobbleExceptionType) {
    super(gobbleExceptionType);
  }

  public enum GobbleError implements GobbleExceptionType {
    INPUT_WORD_IS_EMPTY("GE01", "Input word list is empty"),
    INVALID_GRID_CHARACTER("GE02", "Invalid grid characters"),
    INPUT_WORD_IS_REPEATED("GE03", "Input words are repeated"),
    INPUT_WORD_IS_NOT_ALPHABETIC("GE04", "Input word contains other than alphabetic characters"),
    INPUT_WORD_LESS_THEN_TWO_CHARACTERS("GE05", "Input word is less than 3 characters"),
    GRID_IS_EMPTY("GE06","Grid is empty"),
    ;
    private String code;
    private String description;

    GobbleError(String code, String description) {
      this.code = code;
      this.description = description;
    }

    @Override
    public String getCode() {
      return this.code;
    }

    @Override
    public String getDescription() {
      return this.description;
    }
  }
}
