package org.bipin.gobble.rest.adaptors;

import com.google.common.base.Strings;
import org.bipin.gobble.lib.mappers.AppException;
import org.bipin.gobble.repositories.ExceptionManager;
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
    if (jsonObject.containsKey("inputWords")){
      JsonArray inputWordJsonArray= jsonObject.getJsonArray("inputWords");
      for (int i=0; i< inputWordJsonArray.size();i++){
        inputWords.add(  inputWordJsonArray.getJsonString(i).getString() );
      }
    }
    List<List<Character>> characterList= new ArrayList<>();
    if (jsonObject.containsKey("grid")){
      JsonArray gridRowJsonArray= jsonObject.getJsonArray("grid");
      for (int i=0; i<gridRowJsonArray.size(); i++){

        List<Character> rowArray= new ArrayList<>();
        JsonArray gridColJsonArray= gridRowJsonArray.getJsonArray(i).asJsonArray();
        for (int j=0; j< gridColJsonArray.size(); j++){
          if (Strings.isNullOrEmpty(gridColJsonArray.getJsonString(j).getString())){
            throw new AppException(ExceptionManager.GobbleError.INVALID_GRID_CHARACTER);
          }
          rowArray.add( gridColJsonArray.getJsonString(j).getString().charAt(0) );
        }
        characterList.add(rowArray);
      }
      gameInfo.setGrid(characterList);
    }

    gameInfo.setInputWords(inputWords);
    return gameInfo;
  }

}
