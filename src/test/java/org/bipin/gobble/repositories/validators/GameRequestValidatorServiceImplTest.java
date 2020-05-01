package org.bipin.gobble.repositories.validators;

import org.bipin.gobble.lib.mappers.AppException;
import org.bipin.gobble.repositories.ExceptionManager;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bipin on 2020-05-01 17:58
 */
class GameRequestValidatorServiceImplTest {
  private static GameRequestValidatorServiceImpl validatorService;

  @BeforeAll
  static void setup(){
    validatorService= new GameRequestValidatorServiceImpl();
  }

  @Test
  @DisplayName("Should throw exception if input words are empty")
  void shouldThrowExceptionIfInputWordsAreEmpty(){
    GameInfo info= prepareGameInfo();
    info.setInputWords(List.of());
    AppException exception=assertThrows(AppException.class,()-> validatorService.validate(info));
    assertEquals(ExceptionManager.GobbleError.INPUT_WORD_IS_EMPTY.getDescription(),
        exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception if input words are repeated")
  void shouldThrowExceptionIfInputWordsAreRepeated(){
    GameInfo info= prepareGameInfo();
    info.getInputWords().add("rain");
    AppException exception=assertThrows(AppException.class,()-> validatorService.validate(info));
    assertEquals(ExceptionManager.GobbleError.INPUT_WORD_IS_REPEATED.getDescription(),
        exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception if input words are less than 3 character in length")
  void shouldThrowExceptionIfInputWordIsLessThan3Character(){
    GameInfo info= prepareGameInfo();
    info.getInputWords().add("a");
    AppException exception=assertThrows(AppException.class,()-> validatorService.validate(info));
    assertEquals(ExceptionManager.GobbleError.INPUT_WORD_LESS_THEN_TWO_CHARACTERS.getDescription(),
        exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception input words contains anything except alphabets")
  void shouldThrowExceptionIfInputWordsContainAnythingExceptAlphabets(){
    GameInfo info= prepareGameInfo();
    info.getInputWords().add("aasd3f");
    AppException exception=assertThrows(AppException.class,()-> validatorService.validate(info));
    assertEquals(ExceptionManager.GobbleError.INPUT_WORD_IS_NOT_ALPHABETIC.getDescription(),
        exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception if grid is empty")
  void shouldThrowExceptionIfGridIsEmpty(){
    GameInfo info= prepareGameInfo();
    info.setGrid(List.of() );
    AppException exception=assertThrows(AppException.class,()-> validatorService.validate(info));
    assertEquals(ExceptionManager.GobbleError.GRID_IS_EMPTY.getDescription(),
        exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception if invalid grid")
  void shouldThrowExceptionIfGridIsInvalid(){
    GameInfo info= prepareGameInfo();
    info.setGrid(  List.of(
        List.of('b', 'a', 'a', 'n'),
        List.of('e', 't', 'a', 'e'),
        List.of('l', 'h', 'k', 'r'),
        List.of('i', 'n', 'i')) );
    AppException exception=assertThrows(AppException.class,()-> validatorService.validate(info));
    assertEquals(ExceptionManager.GobbleError.INVALID_GRID_CHARACTER.getDescription(),
        exception.getMessage());
  }


  private GameInfo prepareGameInfo(){
    GameInfo info= new GameInfo();
    info.setGrid(getGrid1());
    info.setInputWords(getInputWords1());
    return info;
  }

  private List<List<Character>> getGrid1(){

    return List.of(
        List.of('o', 'a', 'a', 'n'),
        List.of('e', 't', 'a', 'e'),
        List.of('l', 'h', 'k', 'r'),
        List.of('i', 'n', 'i', 'a'));
  }

  private List<String> getInputWords1(){

    return new ArrayList<>(Arrays.asList("oath", "pea", "eat",
        "hira", "rain", "oat", "kira", "nakin", "haki", "hakil"));
  }


}