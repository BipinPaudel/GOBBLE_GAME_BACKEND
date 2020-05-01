package org.bipin.gobble.repositories;

import org.bipin.gobble.repositories.dictionary.DictionaryRepository;
import org.bipin.gobble.repositories.infos.GameInfo;
import org.bipin.gobble.repositories.infos.ResultInfo;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author bipin on 2020-05-01 12:00
 */
public class GobbleRepositoryImpl implements GobbleRepository {

  private static final Logger LOGGER= Logger.getLogger(GobbleRepositoryImpl.class.getName());

  private SearchRepository searchRepository;
  private DictionaryRepository dictionaryRepository;
  @Inject
  public GobbleRepositoryImpl(SearchRepository searchRepository,
                              DictionaryRepository dictionaryRepository) {
    this.searchRepository = searchRepository;
    this.dictionaryRepository = dictionaryRepository;
  }

  @Override
  public ResultInfo execute(GameInfo info) {
    validateInput(info);


    List<String> correctWords= searchValidWordsInGrid(info.getInputWords(),info.getGrid());
    int totalScore= prepareTotalScore(correctWords);
    Map<String,Boolean> wordMap= prepareWordMap(correctWords,info.getInputWords());

    return prepareResponse(totalScore,wordMap,info.getGrid());
  }

  public void validateInput(GameInfo info){
    //VALIDATE HERE
  }

  private ResultInfo prepareResponse(int totalScore, Map<String, Boolean> wordMap, List<List<Character>> grid) {
    ResultInfo resultInfo= new ResultInfo();
    resultInfo.setGrid(grid);
    resultInfo.setWordMap(wordMap);
    resultInfo.setTotalScore(totalScore) ;
    return resultInfo;
  }

  private List<String> searchValidWordsInGrid(List<String> inputWords, List<List<Character>> grid) {
    List<String> validDictionaryWords= getValidWordsByCheckinInDictionary(inputWords);
    GameInfo info= new GameInfo(validDictionaryWords,grid);
    return searchRepository.execute(info);
  }

  private List<String> getValidWordsByCheckinInDictionary(List<String> inputWords) {
    return inputWords.stream()
        .filter(word-> dictionaryRepository.isWordValidEnglishWord(word))
        .collect(Collectors.toList());
  }

  private Map<String, Boolean> prepareWordMap(List<String> correctWords, List<String> inputWords) {
    Map<String,Boolean> wordMap= new HashMap<>();
    inputWords.forEach(in->{
        wordMap.put(in,correctWords.contains(in));

    });

    return wordMap;
  }

  private int prepareTotalScore(List<String> correctWords) {
    return correctWords.stream()
        .map(String::length)
        .reduce(0, Integer::sum);
  }
}
