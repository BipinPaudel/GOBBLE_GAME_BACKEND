package org.bipin.gobble.repositories;

import org.bipin.gobble.lib.mappers.AppException;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bipin on 2020-05-01 13:35
 */
class SearchRepositoryImplTest {
  private static SearchRepositoryImpl searchRepository;

  @BeforeEach
  void setup(){
    searchRepository= new SearchRepositoryImpl();
  }

  @Test
  @DisplayName("Should return valid words as desired given grid and input words")
  void shouldReturnValidWordsAsDesired(){
    GameInfo info= prepareGameInfo();
    List<String> correctWords= searchRepository.execute(info);
    assertEquals(8,correctWords.size());
    assertTrue(correctWords.contains("oath"));
    assertTrue(correctWords.contains("eat"));
    assertTrue(correctWords.contains("kira"));
    assertTrue(correctWords.contains("haki"));
    assertTrue(correctWords.contains("rain"));
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
    return List.of("oath", "pea", "eat","hira", "rain", "oat", "kira", "nakin", "haki","hakil");
  }
}