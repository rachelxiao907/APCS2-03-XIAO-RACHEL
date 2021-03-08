import java.util.*;
import java.io.*;
public class USACO {
  public static int bronze(String filename) throws FileNotFoundException {
    File f = new File (filename);
    Scanner inf = new Scanner(f);

    Scanner line = new Scanner(inf.nextLine()); //Line 1: Four space-separated integers: R, C, E, N
    int R = line.nextInt(); //rows
    int C = line.nextInt(); //columns
    int E = line.nextInt(); //elevation
    int N = line.nextInt(); //set of stomp digging instructions

    int[][] pasture = new int[R][C];
    for (int i = 0; i < R; i++) {
      Scanner row = new Scanner(inf.nextLine());
      for (int j = 0; j < C; j++) {
        pasture[i][j] = row.nextInt();
      }
    }

    //Lines R+2..R+N+1: Line i+R+1 describes stomp-digging instruction i with three integers: R_s, C_s, and D_s
    for (int i = 0; i < N; i++) {
      line = new Scanner(inf.nextLine());
      int R_s = line.nextInt() - 1; //upper left coordinate of 3x3 grid
      int C_s = line.nextInt() - 1;
      int D_s = line.nextInt(); //stomp depression
      stomp(pasture, R_s, C_s, D_s);
    }

    //calculate volume of the new lake in cubic inches
    int depth = 0; //total depth of lake
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (pasture[i][j] < E) { //if lower than water level, calculate depth bc higher than water level means there is no water
          depth += E - pasture[i][j];
        }
      }
    }
    return depth * 72 * 72;
  }

  public static void stomp (int[][] pasture, int r, int c, int d) {
    int max = pasture[r][c];
    for (int i = r; i < r + 3; i++) { //loop through a 3x3 grid
      for (int j = c; j < c + 3; j++) {
        if (pasture[i][j] > max){
          max = pasture[i][j]; //find the highest elevation in the 3x3 grid
        }
      }
    }
    max = max - d; //final elevation after being stomped
    for (int i = r; i < r + 3; i++) { //loop through 3x3 grid
      for (int j = c; j < c + 3; j++) {
        if (pasture[i][j] > max){
          pasture[i][j] = max; //stomp the square
        }
      }
    }
  }


  public static long silver(String filename) throws FileNotFoundException {
    File f = new File (filename);
    Scanner inf = new Scanner(f);

    Scanner line = new Scanner(inf.nextLine()); //Line 1: Three space-separated integers: N, M, and T
    int N = line.nextInt(); //rows
    int M = line.nextInt(); //columns
    int T = line.nextInt(); //travel time

    int[][] pasture = new int[N][M];
    for (int i = 0; i < N; i++) {
      String s = inf.nextLine();
      for (int j = 0; j < M; j++) {
        if (s.charAt(j) == '*') {
          pasture[i][j] = -1; //tree at square
        }
      }
    }

    //Line N+2: Four space-separated integers: R1, C1, R2, and C2
    //cow goes from (R1, C1) to (R2, C2)
    line = new Scanner(inf.nextLine());
    int R1 = line.nextInt() - 1;
    int C1 = line.nextInt() - 1;
    int R2 = line.nextInt() - 1;
    int C2 = line.nextInt() - 1;

    pasture[R1][C1] = 1; //set (R1, C1) to 1 to start finding paths by using sums
    for (int i = 0; i < T; i++) {
      pasture = findPaths(pasture); //continually update the pasture until time runs out
                                    //number of times updated = number of moves/seconds
    }
    return pasture[R2][C2];
  }

  //we need a second 2D array to calculate the number of ways to get to a square
  //one array would make it hard to update and keep track of adjacent squares
  public static int[][] findPaths(int[][] pasture)  {
    int[][] paths = new int[pasture.length][pasture[0].length]; //new array that holds the sum how many ways each square can be reached
    int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}}; //2D array of moves
    for (int r = 0; r < pasture.length; r++) {
      for (int c = 0; c < pasture[r].length; c++) {
        int sum = 0;
        if (pasture[r][c] == -1) {
          paths[r][c] = -1; //keep track of the trees in the pasture
        } else {
          //loop to try every direction
          for (int m = 0; m < moves.length; m++) { //check every direction
            if (!notFree(pasture, r + moves[m][0], c + moves[m][1])) {
              sum += pasture[r + moves[m][0]][c + moves[m][1]]; //sum of the values of neighbors
            }
          }
          paths[r][c] = sum; //update array with the number of ways to get to the square
        }
      }
    }
    return paths;
  }

  public static boolean notFree(int[][] pasture, int r, int c) {
    return r < 0 || c < 0 || r >= pasture.length || c >= pasture[0].length || pasture[r][c] == -1;
  }

}
