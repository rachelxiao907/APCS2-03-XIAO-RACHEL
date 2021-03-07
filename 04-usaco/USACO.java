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
    for (int i = r; i < r + 3; i++) {
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
          pasture[i][j] = -1;
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
    return 0;
  }

}
