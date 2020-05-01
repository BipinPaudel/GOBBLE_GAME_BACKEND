package org.bipin.gobble.lib.utils;

import org.bipin.gobble.repositories.game.BoundaryIndex;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author bipin on 2020-05-01 11:09
 */
public class HelperUtils {

  private HelperUtils() {}

  public static String getTime() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
    return simpleDateFormat.format(new Date());
  }
  public static boolean isBlankOrNull(String str) {
    int strLen;
    if (str == null || (strLen = str.length()) == 0) {
      return true;
    }
    for (int i = 0; i < strLen; i++) {
      if ((Character.isWhitespace(str.charAt(i)) == false)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isOutOfIndex(char[][] grid, int i, int j){
    return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
  }

  public static List<BoundaryIndex> getAllBoundaryAxisPoints(){
    List<BoundaryIndex> diagonal= getDiagonalAxisPoints();
    diagonal.addAll(getHorizontalVerticalAxisPoints());
    return diagonal;
  }

  public static List<BoundaryIndex> getDiagonalAxisPoints(){
    List<BoundaryIndex> b= Arrays.asList(new BoundaryIndex(1, 1), new BoundaryIndex(1, -1),
        new BoundaryIndex(-1, -1), new BoundaryIndex(-1, 1));
    return new ArrayList<>(b);

  }

  public static List<BoundaryIndex> getHorizontalVerticalAxisPoints(){
    List<BoundaryIndex> b= Arrays.asList(new BoundaryIndex(-1,0),new BoundaryIndex(1,0),
        new BoundaryIndex(0,-1),new BoundaryIndex(0,1));
    return new ArrayList<>(b);

  }

  public static synchronized String generateUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

}