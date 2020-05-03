package org.bipin.gobble.repositories.services.search;

import org.bipin.gobble.repositories.helpers.Constants;
import org.bipin.gobble.repositories.helpers.HelperUtils;
import org.bipin.gobble.repositories.domains.BoundaryIndex;
import org.bipin.gobble.repositories.domains.TrieNode;
import org.bipin.gobble.repositories.infos.GameInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author bipin on 2020-05-01 13:15
 */
public class SearchServiceImpl implements WordSearchService {

  @Override
  public List<String> search(GameInfo info) {
    TrieNode root= new TrieNode();
    info.getInputWords().forEach(s->root.add(s,s));
    char[][] grid= convertToCharGrid(info.getGrid());

    Set<String> correctWords = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        char c = grid[i][j];
        if (root.node.containsKey(c)) {
          dfs(grid, i, j, root, c, correctWords);
        }
      }
    }

    return new ArrayList<>(correctWords);
  }

  private char[][] convertToCharGrid(List<List<Character>> gridList) {
    char[][] grid = new char[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        grid[i][j] = gridList.get(i).get(j);
      }
    }
    return grid;
  }


  private void dfs(char[][] grid, int i, int j, TrieNode root, char c, Set<String> returnWords) {

    List<BoundaryIndex> boundaryIndices= HelperUtils.getAllBoundaryAxisPoints();

    if (HelperUtils.isOutOfIndex(grid, i, j)
        || grid[i][j] == Constants.VISITED.getCode()
        || !root.node.containsKey(c )

    ) return;

    // pop current character and set that location to visited
    char currentCharacter = grid[i][j];
    grid[i][j] = Constants.VISITED.getCode();

    root = root.node.get(currentCharacter);

    if (root != null && root.value!=null) {
      returnWords.add(root.value);
    }
    for(BoundaryIndex boundaryIndex: boundaryIndices) {
      int row = i + boundaryIndex.x;
      int col = j + boundaryIndex.y;
      if (!HelperUtils.isOutOfIndex(grid, row, col)) {
        dfs(grid, row, col, root, grid[row][col], returnWords);
      }
    }

    // restore character back to the grid
    grid[i][j] = currentCharacter;
    return;
  }
}
