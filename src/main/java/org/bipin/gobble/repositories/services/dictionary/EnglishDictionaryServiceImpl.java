package org.bipin.gobble.repositories.services.dictionary;


import org.bipin.gobble.lib.services.DictionaryService;

import javax.inject.Inject;

/**
 * @author bipin on 2020-05-01 14:56
 */
public class EnglishDictionaryServiceImpl implements DictionaryService {

 EnglishDictionary englishDictionary;

 @Inject
  public EnglishDictionaryServiceImpl(EnglishDictionary englishDictionary) {
   this.englishDictionary = englishDictionary;
  }

  @Override
  public boolean isWordValidDictionaryWord(String word) {
    return englishDictionary.getDictionary().contains(word);
  }


}
