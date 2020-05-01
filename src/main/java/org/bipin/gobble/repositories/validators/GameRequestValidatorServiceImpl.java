package org.bipin.gobble.repositories.validators;

import com.google.common.base.Strings;
import org.bipin.gobble.lib.mappers.AppException;
import org.bipin.gobble.lib.utils.HelperUtils;
import org.bipin.gobble.repositories.ExceptionManager;
import org.bipin.gobble.repositories.infos.GameInfo;

import java.util.HashSet;

/**
 * @author bipin on 2020-05-01 17:47
 */
public class GameRequestValidatorServiceImpl implements GameRequestValidatorService {

  @Override
  public void validate(GameInfo info) {
    if (info.getInputWords().isEmpty()) {
      throw new AppException(ExceptionManager.GobbleError.INPUT_WORD_IS_EMPTY);
    }

    if (info.getInputWords().size() > new HashSet<>(info.getInputWords()).size()) {
      throw new AppException(ExceptionManager.GobbleError.INPUT_WORD_IS_REPEATED);
    }

    info.getInputWords().forEach(in -> {
      if (in.length() < 3) {
        throw new AppException(ExceptionManager.GobbleError.INPUT_WORD_LESS_THEN_TWO_CHARACTERS);
      }

      if (!HelperUtils.containsAlphabeticCharacters(in)){
        throw new AppException(ExceptionManager.GobbleError.INPUT_WORD_IS_NOT_ALPHABETIC);
      }

      if (info.getGrid().size()!=4){
        throw new AppException(ExceptionManager.GobbleError.GRID_IS_EMPTY);
      }

      info.getGrid().forEach(row-> row.forEach(col-> {
        String toStr= String.valueOf(col);
        if (row.size()!=4 || Strings.isNullOrEmpty(toStr) || toStr.length()>1 || !HelperUtils.containsAlphabeticCharacters(toStr)){
        throw new AppException(ExceptionManager.GobbleError.INVALID_GRID_CHARACTER);
        }
      }));
    });
  }
}
