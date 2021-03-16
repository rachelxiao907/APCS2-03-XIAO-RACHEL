import java.util.*;
public class Merge {
  public static void mergesort(int[] data) {
    mergesortH(data, 0, data.length-1);
  }

  /* pseudocode
  mergesort(data,lo,hi){
    if more than 1 element{
      mergesort left side
      mergesort right side
      merge
    }
  }
  */
  public static void mergesortH(int[] data, int lo, int hi) {
    if (lo < hi) { //if more than one element
      int mid = (hi - lo) / 2 + 1; //middle point to divide the array in half
      int[] left = new int[mid]; //left side
      for (int i = 0; i < left.length; i++) {
        left[i] = data[i];
        //System.out.println(left[i]);
      }
      int[] right = new int[hi - mid + 1]; //right side
      for (int i = 0; i < right.length; i++) {
        right[i] = data[mid + i];
        //System.out.println(right[i]);
      }
    }
  }

  public static void main(String[] args) {
    int[] data = new int[] {38,27,43,3,9,82,10};
    mergesortH(data, 0, data.length-1);
    System.out.println(Arrays.toString(data));
  }

}
