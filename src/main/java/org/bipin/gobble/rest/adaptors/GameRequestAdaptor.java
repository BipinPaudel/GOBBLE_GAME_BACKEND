package org.bipin.gobble.rest.adaptors;

import com.google.common.base.Strings;
import org.bipin.gobble.repositories.infos.GameInfo;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bipin on 2020-05-01 11:44
 */
public class GameRequestAdaptor {

  public GameInfo toInfo(JsonObject jsonObject){
    GameInfo gameInfo= new GameInfo();

    List<String> inputWords= new ArrayList<>();
    List<List<Character>> grid= new ArrayList<>();
    if (jsonObject.containsKey("inputWords")){
      JsonArray inputWordJsonArray= jsonObject.getJsonArray("inputWords");
      for (int i=0; i< inputWordJsonArray.size();i++){
        inputWords.add(  inputWordJsonArray.getJsonString(i).getString() );
      }
    }
    List<List<Character>> characterList= new ArrayList<>();
    if (jsonObject.containsKey("grid")){
      JsonArray gridRowJsonArray= jsonObject.getJsonArray("grid");
//      List<Character> rowArray= new ArrayList<>();
      for (int i=0; i<gridRowJsonArray.size(); i++){

        List<Character> rowArray= new ArrayList<>();
        JsonArray gridColJsonArray= gridRowJsonArray.getJsonArray(i).asJsonArray();
        for (int j=0; j< gridColJsonArray.size(); j++){
          if (Strings.isNullOrEmpty(gridColJsonArray.getJsonString(j).getString())){
            /// exception throw
          }
          rowArray.add( gridColJsonArray.getJsonString(j).getString().charAt(0) );
        }
        characterList.add(rowArray);
      }
      gameInfo.setGrid(characterList);
    }

    gameInfo.setInputWords(inputWords);


    if (inputWords.isEmpty()){
      System.out.println("empty");
    }else{
      System.out.println(inputWords.get(0));
      System.out.println(characterList.toString());
    }

    return gameInfo;
  }

}
