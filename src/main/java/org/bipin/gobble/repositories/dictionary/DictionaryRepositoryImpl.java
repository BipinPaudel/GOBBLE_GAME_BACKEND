package org.bipin.gobble.repositories.dictionary;

import org.bipin.gobble.lib.Dictionary;
import org.bipin.gobble.lib.DictionaryQ;

import javax.inject.Inject;
import java.util.Set;

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
    System.out.println("search word "+word);

    System.out.println(dictionary.getDictionary().size());
    return dictionary.getDictionary().contains(word);
  }


}
