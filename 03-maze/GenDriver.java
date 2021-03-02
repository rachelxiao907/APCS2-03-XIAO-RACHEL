import java.util.*;
import java.io.*;
public class GenDriver {
  public static void main(String[] args) {
    char[][] mazeGen = new char[20][70];
    for (int i = 0; i < mazeGen.length; i ++) {
      for (int j = 0; j < mazeGen[i].length; j++) {
        mazeGen[i][j] = '#';
      }
    }
    MazeGenerator.generate(mazeGen, 0, 0, 1, 1);
    System.out.println(toString(mazeGen));
  }

  public static String toString(char[][] maze) {
    String output = "";
    for (int i = 0; i < maze.length; i ++) {
      for (int j = 0; j < maze[i].length; j++) {
        output += maze[i][j];
      }
      if (i != maze.length-1) {
        output += "\n";
      }
    }
    return output;
  }
}
