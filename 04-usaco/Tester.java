import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    try {
      int[][] pasture = makeBronze("lake1.input");
      String output = "";
      for (int i = 0; i < pasture.length; i++) {
        for (int j = 0; j < pasture[i].length; j++) {
          output += pasture[i][j] + " ";
        }
        if (i != pasture.length-1) output += "\n";
      }
      System.out.println(output);
    } catch (FileNotFoundException e) {}
    try {
      int ans = USACO.bronze("lake1.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {

    }

    try {
      int ans = USACO.bronze("lake2.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {
    }

    try {
      int ans = USACO.bronze("lake3.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {
    }
    System.out.println("------------------------");

    try {
      int[][] pasture = makeSilver("cowPath1.input");
      String output = "";
      for (int i = 0; i < pasture.length; i++) {
        for (int j = 0; j < pasture[i].length; j++) {
          output += pasture[i][j] + " ";
        }
        if (i != pasture.length-1) output += "\n";
      }
      System.out.println(output);
    } catch (FileNotFoundException e) {}
    try {
      long ans = USACO.silver("cowPath1.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {
    }

    try {
      long ans = USACO.silver("cowPath2.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {
    }

    try {
      long ans = USACO.silver("cowPath3.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {
    }

  }

  public static int[][] makeBronze(String filename) throws FileNotFoundException {
    File f = new File (filename);
    Scanner inf = new Scanner(f);

    Scanner line = new Scanner(inf.nextLine());
    int R = line.nextInt();
    int C = line.nextInt();
    int E = line.nextInt();
    int N = line.nextInt();

    int[][] pasture = new int[R][C];
    for (int i = 0; i < R; i++) {
      Scanner row = new Scanner(inf.nextLine());
      for (int j = 0; j < C; j++) {
        pasture[i][j] = row.nextInt();
      }
    }
    return pasture;
  }
  public static int[][] makeSilver(String filename) throws FileNotFoundException {
    File f = new File (filename);
    Scanner inf = new Scanner(f);

    Scanner line = new Scanner(inf.nextLine()); //Line 1: Four space-separated integers: R, C, E, N
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
    return pasture;
  }

}
