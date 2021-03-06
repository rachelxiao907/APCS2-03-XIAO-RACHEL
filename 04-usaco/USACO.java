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
    stomp(pasture, 0, 0, 3);
    return pasture[0][0];
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

  //public static long silver(String filename)

  public static void main(String[] args) {
    try {
      System.out.println(bronze("lake1.input"));
    } catch (FileNotFoundException e) {}
  }

}
