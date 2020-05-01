package org.bipin.gobble.repositories.infos;

import org.bipin.gobble.lib.repo.ServiceObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bipin on 2020-05-01 11:47
 */
public class ResultInfo implements ServiceObject {
  private List<List<Character>> grid;
  private Map<String,Boolean> wordMap;
  private int totalScore;

  public ResultInfo() {
    grid= new ArrayList<>();
    wordMap= new HashMap<>();
  }

  public List<List<Character>> getGrid() {
    return grid;
  }

  public void setGrid(List<List<Character>> grid) {
    this.grid = grid;
  }

  public Map<String, Boolean> getWordMap() {
    return wordMap;
  }

  public void setWordMap(Map<String, Boolean> wordMap) {
    this.wordMap = wordMap;
  }

  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }
}
