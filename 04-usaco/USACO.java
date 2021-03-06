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
    return pasture[0][0];
  }

  //public static long silver(String filename)

  public static void main(String[] args) {
    try {
      System.out.println(bronze("lake1.input"));
    } catch (FileNotFoundException e) {}
  }

}
