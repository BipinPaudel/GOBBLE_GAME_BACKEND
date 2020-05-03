package org.bipin.gobble.repositories.domains;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bipin on 2020-04-29 13:58
 */
public class TrieNode {
  public Map<Character,TrieNode> node;
  public String value;

  public TrieNode() {
    node= new HashMap<>();
  }

  public void add(String str, String newWord){
    if (!str.isEmpty()){
      char first= str.charAt(0);
      if (!node.containsKey(first)){
        node.put(first,new TrieNode());
      }
      node.get(first).add(str.substring(1),newWord);
      if (str.length()==1 ) node.get(first).value=newWord;
    }
  }
}
