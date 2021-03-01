import java.util.*;
import java.io.*;
public class Maze {

  private char[][] maze;
  private boolean animate;//false by default

  /*Constructor loads a maze text file, and sets animate to false by default.
    When the file is not found then:
       throw a FileNotFoundException

    You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
    '#' - Walls - locations that cannot be moved onto
    ' ' - Empty Space - locations that can be moved onto
    'E' - the location of the goal (exactly 1 per file)
    'S' - the location of the start(exactly 1 per file)

    You may also assume the maze has a border of '#' around the edges.
    So you don't have to check for out of bounds!
  */
  public Maze(String filename) throws FileNotFoundException {
    File text = new File (filename);
    Scanner inf = new Scanner(text);
    ArrayList<String> arr = new ArrayList<String>();

    while(inf.hasNextLine()) {
      arr.add(inf.nextLine()); //add each line to ArrayList
    }

    int lines = arr.size();
    int chars = arr.get(0).length();
    maze = new char[lines][chars];
    for (int i = 0; i < lines; i ++) {
      maze[i] = arr.get(i).toCharArray(); //make each line into char array and assign to an element of maze
    }
    animate = false;
  }

  private void wait(int millis) {
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
   }

  public void setAnimate(boolean b) {
    animate = b;
  }

  public static void clearTerminal() {
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
   It should look like the text file with some characters replaced.
  */
  public String toString() {
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

  /*Wrapper Solve Function returns the helper function
    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve() {
    //only clear the terminal if you are running animation
    if(animate) {
      clearTerminal();
    }
    //start solving at the location of the s.
    int row = 0;
    int col = 0;
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (maze[i][j] == 'S') {
          row = i;
          col = j;
        }
      }
    }
    maze[row][col] = ' '; //start needs to be replaced with '@'
    //return solve(???,???);
    return solve(row, col, 0);
  }

  /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.

    Postcondition:
      The 'S' is replaced with '@'
      The 'E' remain the same
      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col, int count) { //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate) {
      gotoTop();
      System.out.println(this);
      wait(50);
    }

    //COMPLETE SOLVE
    if (maze[row][col] == 'E') return count; //if exit is found, solution is the number of @ symbols
    if (maze[row][col] != ' ') return -1; //if there is a wall or marked space, no solution can be found in that direction
                                          //means we are done with that method and need to backtrack --> go to previous space since current move ended and doesn't work
    maze[row][col] = '@'; //mark space as part of possible path
    //if that direction != -1, then this is the solution since reaching the end is the only thing that returns count
    int ans = solve(row, col+1, count+1); //right
    if (ans != -1) {
      return ans;
    }
    ans = solve(row, col-1, count+1); //left
    if (ans != -1) {
      return ans;
    }
    ans = solve(row-1, col, count+1); //up
    if (ans != -1) {
      return ans;
    }
    ans = solve(row+1, col, count+1); //down
    if (ans != -1) {
      return ans;
    }
    maze[row][col] = '.'; //backtrack: if every direction fails, mark visited spots so space at intersection can pick a new direction
    return -1; //so it compiles
  }
}
