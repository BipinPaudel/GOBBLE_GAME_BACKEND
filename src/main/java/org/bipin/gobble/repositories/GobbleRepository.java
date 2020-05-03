package org.bipin.gobble.repositories;

import org.bipin.gobble.repositories.infos.GameInfo;
import org.bipin.gobble.repositories.infos.ResultInfo;

import java.util.List;

/**
 * @author bipin on 2020-05-01 11:47
 */
public interface GobbleRepository {
  List<List<Character>> prepareGrid();
  ResultInfo execute(GameInfo info);
}
