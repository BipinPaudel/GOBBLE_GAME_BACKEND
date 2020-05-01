package org.bipin.gobble.lib;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.interceptor.ExcludeDefaultInterceptors;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bipin on 2020-05-01 15:29
 */
@ApplicationScoped
public class Dictionary {
  private Set<String> dictionary;

  public Dictionary() {
    dictionary= new HashSet<>();
  }

  public Dictionary(Set<String> dictionary) {
    this.dictionary = dictionary;
  }

  public Set<String> getDictionary() {
    if (dictionary.isEmpty()){
      dictionary.addAll(produce());
    }
    return dictionary;
  }

  public void setDictionary(Set<String> dictionary) {
    this.dictionary = dictionary;
  }

  public Set<String> produce() {
    Set<String> words = new HashSet<>();
    InputStream in = getClass()
        .getResourceAsStream("/words.txt");



    BufferedReader br = null;
    br = new BufferedReader(new InputStreamReader(in));
    String st= null;
    while (true) {
      try {
        if (!((st = br.readLine()) != null)) break;
      } catch (IOException e) {
        e.printStackTrace();
      }
      words.add(st);
    }

    return words;


  }
}
