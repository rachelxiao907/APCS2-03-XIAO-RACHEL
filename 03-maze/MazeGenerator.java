import java.util.*;
import java.io.*;
public class MazeGenerator {
  /**
  Given a 2D rectangular array pre-filled with walls '#'
  Try to remove the maze[startrow][startcol] if possible, and continue to do this recursively
  */
  public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol) {
    if (startrow < 1 || startcol < 1 || startrow == maze.length-1 || startcol == maze[0].length-1) return; //A wall that is on the border of the maze is never safe to carve
    if (maze[startrow][startcol] != '#') return;
    //a wall in the middle of the maze is safe to carve if before carving there are fewer than 2 ways to step into the square
    int neighbors = 0;
    if (maze[startrow+1][startcol] == ' ') neighbors++;
    if (maze[startrow-1][startcol] == ' ') neighbors++;
    if (maze[startrow][startcol-1] == ' ') neighbors++;
    if (maze[startrow][startcol+1] == ' ') neighbors++;
    if (neighbors > 1) return;

    maze[startrow][startcol] = ' ';
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
