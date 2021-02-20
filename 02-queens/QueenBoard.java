public class QueenBoard {
  //instance variable
  private int[][] board;

  //constructor
  public QueenBoard(int size) {
    board = new int[size][size];
  }

  //private methods
  private boolean addQueen(int r, int c) {
    if (board[r][c] != 0) { //if square has a queen or is threatened
      return false;
    } else {
      board[r][c] = -1; //add queen to square
    }
    //only need to mark squares to the right of the queen
    for (int x = 1; x + c < board.length; x++) {
                       //can only have 1 queen in each column, so we don't need to mark column's squares
      board[r][c+x]++; //squares in the same row as queen are threatened
      if (r - x >= 0) board[r-x][c+x]++; //squares in the upward diagonal are threatened
      if (r + x < board.length) board[r+x][c+x]++; //squares in the downward diagonal are threatened
    }
    return true;
  }
  private void removeQueen(int r, int c) {
    if (board[r][c] == -1) { //if square has a queen
      board[r][c] = 0; //remove queen from square
      //unmark squares to the right of the queen
      for (int x = 1; x + c < board.length; x++) {
        board[r][c+x]--; //squares in the same row as queen are not threatened anymore
        if (r - x >= 0) board[r-x][c+x]--; //squares in the upward diagonal are not threatened anymore
        if (r + x < board.length) board[r+x][c+x]--; //squares in the downward diagonal are not threatened anymore
      }
    }
  }

  //public methods
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString() {
    String ans = "";
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        if (board[r][c] == -1) {
          ans += "Q ";
        } else {
          ans += "_ ";
        }
        if (c == board[r].length-1) {
          ans += "\n";
        }
      }
    }
    return ans;
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next COLUMN. When backtracking
  *  move the previous queen down to the next valid space. This means everyone will generate the same
  *  first solution.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve() {
    return solve(0);
  }
  /**
  *@param c : the column is the count of how many queens have been added
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  */
  public boolean solve(int c) {
    if (c >= board.length) return true; ////if you reach column == board.length, you have run out of space and thus added n queens
    for (int r = 0; r < board.length; r++) { //try all rows in a given column
      if (addQueen(r, c)) { //if a queen can be placed
        if (solve(c+1)) { //try placing queen in the next column
          return true;
        } else {
          removeQueen(r, c); //backtracking by moving queen to next row if queen cannot be placed in next column
        }
      }
    }
    return false;
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions() {
    return 0;
  }

}
