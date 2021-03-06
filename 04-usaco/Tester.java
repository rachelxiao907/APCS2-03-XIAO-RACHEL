import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    try {
      int[][] pasture = make("lake1.input");
      String output = "";
      for (int i = 0; i < pasture.length; i++) {
        for (int j = 0; j < pasture[i].length; j++) {
          output += pasture[i][j] + " ";
        }
        output += "\n";
      }
      System.out.println(output);
    } catch (FileNotFoundException e) {}

    try {
      int ans = USACO.bronze("lake1.input");
      System.out.println(ans);
    } catch (FileNotFoundException e) {}

  }

  public static int[][] make(String filename) throws FileNotFoundException {
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

}
