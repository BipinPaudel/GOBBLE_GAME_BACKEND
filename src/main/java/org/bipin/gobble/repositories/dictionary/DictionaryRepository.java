package org.bipin.gobble.repositories.dictionary;

import org.bipin.gobble.lib.repo.Repository;

/**
 * @author bipin on 2020-05-01 14:56
 */
public interface DictionaryRepository {
  boolean isWordValidEnglishWord(String word);

}
