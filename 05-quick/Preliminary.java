import java.util.*;
import java.io.*;
public class Preliminary {
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  public static int partition (int [] data, int start, int end) {
    int index = (int)(Math.random() * data.length); //select random index for pivot value
    int pivot = data[index]; //the corresponding element of random is designated to the pivot element
    data[index] = data[start]; //swap start value and pivot value
    data[start] = pivot;
    index = start;

    return index;
  }

  public static void main(String[] args) {
    int[] data1 = {999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(partition(data1, 0, data1.length-1));

    int start = 0;
    int index = (int)(Math.random() * data1.length); //select random index for pivot value
    int pivot = data1[index]; //the corresponding element of random is designated to the pivot element
    data1[index] = data1[start]; //swap start value and pivot value
    data1[start] = pivot;
    String output = "";
    for (int i = 0; i < data1.length; i++) {
      output += data1[i] + " ";
    }
    System.out.println(output + "");

  }

}