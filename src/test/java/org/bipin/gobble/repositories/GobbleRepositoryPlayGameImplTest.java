package org.bipin.gobble.repositories;

import org.bipin.gobble.repositories.dictionary.DictionaryRepository;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.bipin.gobble.repositories.infos.ResultInfo;
import org.bipin.gobble.repositories.validators.GameRequestValidatorService;
import org.junit.jupiter.api.BeforeAll;
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
    SearchRepository searchRepository= Mockito.mock(SearchRepository.class);
    DictionaryRepository dictionaryRepository= Mockito.mock(DictionaryRepository.class);
    GameRequestValidatorService gameRequestValidatorService= Mockito.mock(GameRequestValidatorService.class);

    when(dictionaryRepository.isWordValidEnglishWord("oath")).thenReturn(true);
    when(dictionaryRepository.isWordValidEnglishWord("pea")).thenReturn(true);
    when(dictionaryRepository.isWordValidEnglishWord("oat")).thenReturn(true);
    when(dictionaryRepository.isWordValidEnglishWord("rain")).thenReturn(true);


    GameInfo info= new GameInfo();;
    info.setInputWords(List.of("oath","pea","rain","oat"));
    info.setGrid(getGrid1());
    when(searchRepository.execute(info)).thenReturn(List.of("oath","rain","oat"));
    gobbleRepository= new GobbleRepositoryImpl(searchRepository,dictionaryRepository,gameRequestValidatorService);
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