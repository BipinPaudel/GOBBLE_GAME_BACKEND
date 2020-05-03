package org.bipin.gobble.repositories;

import org.bipin.gobble.repositories.services.search.WordSearchService;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.bipin.gobble.repositories.infos.ResultInfo;
import org.bipin.gobble.repositories.validators.GameRequestValidatorService;
import org.bipin.gobble.lib.services.DictionaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author bipin on 2020-05-01 12:34
 */
class GobbleRepositoryPlayGameImplTest {
  private static GobbleRepositoryImpl gobbleRepository;

  @BeforeEach
  void setup(){
    WordSearchService searchService = Mockito.mock(WordSearchService.class);
    DictionaryService dictionaryService = Mockito.mock(DictionaryService.class);
    GameRequestValidatorService gameRequestValidatorService= Mockito.mock(GameRequestValidatorService.class);

    when(dictionaryService.isWordValidDictionaryWord("oath")).thenReturn(true);
    when(dictionaryService.isWordValidDictionaryWord("pea")).thenReturn(true);
    when(dictionaryService.isWordValidDictionaryWord("oat")).thenReturn(true);
    when(dictionaryService.isWordValidDictionaryWord("rain")).thenReturn(true);


    GameInfo info= new GameInfo();;
    info.setInputWords(List.of("oath","pea","rain","oat"));
    info.setGrid(getGrid1());
    when(searchService.search(info)).thenReturn(List.of("oath","rain","oat"));
    gobbleRepository= new GobbleRepositoryImpl(searchService, dictionaryService,gameRequestValidatorService);
  }


  @Test
  @DisplayName("Should get valid total score as desired")
  void getTotalScoreAsDesired(){
    GameInfo info= prepareGameInfo();
    ResultInfo resultInfo=gobbleRepository.execute(info);
    assertEquals(11,resultInfo.getTotalScore());
    assertFalse(resultInfo.getWordMap().get("pea"));
    assertFalse(resultInfo.getWordMap().get("kira"));
    assertTrue(resultInfo.getWordMap().get("oath"));
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