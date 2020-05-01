package org.bipin.gobble.repositories.dictionary;

import javax.inject.Inject;

/**
 * @author bipin on 2020-05-01 14:56
 */
public class DictionaryRepositoryImpl implements DictionaryRepository {

 Dictionary dictionary;

 @Inject
  public DictionaryRepositoryImpl( Dictionary dictionary) {
   this.dictionary= dictionary;
  }

  @Override
  public boolean isWordValidEnglishWord(String word) {
    return dictionary.getDictionary().contains(word);
  }


}
