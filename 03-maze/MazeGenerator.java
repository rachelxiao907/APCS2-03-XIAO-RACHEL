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
    if (neighbors > 1) return; //require fewer than 2 open neighbors to be deemed safe

    maze[startrow][startcol] = ' '; //carve spaces
    ArrayList<Integer> dir = new ArrayList<Integer>();
    dir.add(0);
    dir.add(1);
    dir.add(2);
    dir.add(3);
    Collections.shuffle(dir); //randomize direction
    //recursively carve paths choosing ALL of the 4 neighboring squares, in a random order
    //this loop ensures that we branch in all directions until there are no more directions to go to
    for (int i = 0; dir.size() > 0; i++) {
      if (dir.get(0) == 0) {
        dir.remove(0);
        generate(maze, rows, cols, startrow, startcol+1); //right
      } else if (dir.get(0) == 1) {
        dir.remove(0);
        generate(maze, rows, cols, startrow, startcol-1); //left
      } else if (dir.get(0) == 2) {
        dir.remove(0);
        generate(maze, rows, cols, startrow-1, startcol); //up
      } else if (dir.get(0) == 3) {
        dir.remove(0);
        generate(maze, rows, cols, startrow+1, startcol); //down
      }
    }
  }

}
