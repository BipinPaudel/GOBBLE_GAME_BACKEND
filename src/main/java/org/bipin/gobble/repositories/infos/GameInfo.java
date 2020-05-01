package org.bipin.gobble.repositories.infos;

import org.bipin.gobble.lib.repo.ServiceObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bipin on 2020-05-01 11:45
 */
public class GameInfo implements ServiceObject {
  private List<String> inputWords;
  private List<List<Character>> grid;

  public GameInfo(List<String> inputWords, List<List<Character>> grid) {
    this.inputWords = inputWords;
    this.grid = grid;
  }

  public GameInfo() {
    inputWords= new ArrayList<>();
    grid= new ArrayList<>();
  }

  public List<String> getInputWords() {
    return inputWords;
  }

  public void setInputWords(List<String> inputWords) {
    this.inputWords = inputWords;
  }

  public List<List<Character>> getGrid() {
    return grid;
  }

  public void setGrid(List<List<Character>> grid) {
    this.grid = grid;
  }
}
