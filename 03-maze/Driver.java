import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String[]args){
      String filename = "data1.dat";
      try {
        Maze f;
        f = new Maze(filename); //true animates the maze.

        f.setAnimate(true); //comment this if you are using windows cmd/powershell
        System.out.println(f.solve() + " steps");
        System.out.println(f);
      }
      catch (FileNotFoundException e) {
        System.out.println("Invalid filename: " + filename);
      }

      String filename2 = "data2.dat";
      try {
        Maze f2;
        f2 = new Maze(filename2);//true animates the maze.

        f2.setAnimate(true); //comment this if you are using windows cmd/powershell
        System.out.println(f2.solve() + " steps");
        System.out.println(f2);
      }
      catch(FileNotFoundException e) {
        System.out.println("Invalid filename: " + filename2);
      }

      String filename3 = "data3.dat";
      try {
        Maze f3;
        f3 = new Maze(filename3);//true animates the maze.

        f3.setAnimate(true); //comment this if you are using windows cmd/powershell
        System.out.println(f3.solve() + " steps");
        System.out.println(f3);
      }
      catch(FileNotFoundException e) {
        System.out.println("Invalid filename: " + filename3);
      }

      String filename4 = "Maze1.txt";
      try {
        Maze f4;
        f4 = new Maze(filename4);//true animates the maze.

        f4.setAnimate(true); //comment this if you are using windows cmd/powershell
        System.out.println(f4.solve() + " steps");
        System.out.println(f4);
      }
      catch(FileNotFoundException e) {
        System.out.println("Invalid filename: " + filename4);
      }

      String filename5 = "LargeMazeWindows.txt";
      try {
        Maze f5;
        f5 = new Maze(filename5);//true animates the maze.

        f5.setAnimate(true); //comment this if you are using windows cmd/powershell
        System.out.println(f5.solve() + " steps");
        System.out.println(f5);
      }
      catch(FileNotFoundException e) {
        System.out.println("Invalid filename: " + filename5);
      }

      String filename6 = "Gen.txt";
      try {
        Maze f6;
        f6 = new Maze(filename6);//true animates the maze.

        f6.setAnimate(true); //comment this if you are using windows cmd/powershell
        System.out.println(f6.solve() + " steps");
        System.out.println(f6);
      }
      catch(FileNotFoundException e) {
        System.out.println("Invalid filename: " + filename6);
      }

    }
}
