import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    System.out.println("\n----------Testing partition----------\n");
    int[] data1 = {999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(toString(data1));
    System.out.println(Quick.partition(data1, 0, data1.length-1));
    System.out.println(toString(data1));

    int[] data2 = {1,15,27,32,8,5,17,3};
    System.out.println(toString(data2));
    System.out.println(Quick.partition(data2, 0, data2.length-1));
    System.out.println(toString(data2));

    System.out.println("\n----------Testing quickselect----------\n");
    int[] ary  = {2, 10, 15, 23, 0,  5};
    //If sorted: {0,  2,  5, 10, 15, 23}
    //since we are modifying the array you would not call this repeatedly.
    //This is to show what the returned value would be in all cases.
    System.out.println(Quick.quickselect( ary , 0 ));  //would return 0
    System.out.println(Quick.quickselect( ary , 1 ));  //would return 2
    System.out.println(Quick.quickselect( ary , 2 ));  //would return 5
    System.out.println(Quick.quickselect( ary , 3 ));  //would return 10
    System.out.println(Quick.quickselect( ary , 4 ));  //would return 15
    System.out.println(Quick.quickselect( ary , 5 ));  //would return 23
    System.out.println(toString(ary));

    //sorted array
    int size = 1000000;
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }
    //System.out.println(Quick.quickselect(arr, 53290));

    //array with one value
    int[] arr1 = new int[size];
    for (int i = 0; i < size; i++) {
      arr1[i] = 2;
    }

    //array with 1s and 0s
    int[] arr2 = new int[size];
    for (int i = 0; i < size; i++) {
      int r = (int)(Math.random() * 2);
      if (r == 0) arr2[i] = 0;
      else arr2[i] = 1;
    }
    //System.out.println(Quick.quickselect(arr2, 999999));

    //array with random values
    int[] arr3 = new int[size];
    for (int i = 0; i < size; i++) {
      arr3[i] = (int)(Math.random() * 10);
    }
    //System.out.println(Quick.quickselect(arr3, 999999));

    //reverse sorted array
    int[] arr4 = new int[size];
    for (int i = 0; i < size; i++) {
      arr4[i] = size - i;
    }
    //System.out.println(Quick.quickselect(arr4, 73989));

    System.out.println("\n----------Testing quicksort----------\n");
  }

  public static String toString(int[] data) {
    String output = "[";
    for (int i = 0; i < data.length; i++) {
      output += data[i];
      if (i != data.length-1) output += " ";
    }
    return output + "]";
  }

}
