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

      mergesortH(left, 0, left.length-1); //mergesort left side
      mergesortH(right, 0, right.length-1); //mergesort right side
      merge(data, left, right); //merge the two halves
    }
  }

  public static void merge(int[] data, int[] left, int[] right) {
    int l = 0, r = 0, m = 0; //indices of subarrays (left, right, merge)
    while (l < left.length && r < right.length) { //compare top/most recent values of left and right subarrays
      if (left[l] <= right[r]) { //if left value is less than right value
        data[m] = left[l];
        l++; //increase left index
      } else { //if right value is less than left value
        data[m] = right[r];
        r++; //increase right index
      }
      m++; //increase merge indexx
    }

    while (l < left.length) { //merge the remaining elements of the left side
      data[m] = left[l];
      m++;
      l++;
    }

    while (r < right.length) { //merge the remaining elements of the right side
      data[m] = right[r];
      m++;
      r++;
    }
  }

  public static void main(String[] args) {
    int[] data = new int[] {38,27,43,3,9,82,10};
    mergesort(data);
    System.out.println(Arrays.toString(data));

    //sorted array
    int size = 10000000;
    int[] arr = new int[size];
    int[] check = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
      check[i] = arr[i];
    }

    //array with one value
    int[] arr1 = new int[size];
    int[] check1 = new int[size];
    for (int i = 0; i < size; i++) {
      arr1[i] = 2;
      check1[i] = 2;
    }

    //array with random values
    int[] arr2 = new int[size];
    int[] check2 = new int[size];
    for (int i = 0; i < size; i++) {
      int r = (int)(Math.random() * size);
      arr2[i] = r;
      check2[i] = arr2[i];
    }

    //array with 1s and 0s
    int[] arr3 = new int[size];
    int[] check3 = new int[size];
    for (int i = 0; i < size; i++) {
      int r = (int)(Math.random() * 2);
      if (r == 0) arr3[i] = 0;
      else arr3[i] = 1;
      check3[i] = arr3[i];
    }

    //reverse sorted array
    int[] arr4 = new int[size];
    int[] check4 = new int[size];
    for (int i = 0; i < size; i++) {
      arr4[i] = size - i;
      check4[i] = arr4[i];
    }

    int[] data1 = arr2;
    int[] data2 = check2;

    long t1, t2, mtime, stime;
    t1 = System.currentTimeMillis();
    mergesort(data1);
    t2 = System.currentTimeMillis();
    mtime = t2 - t1;
    t1 = System.currentTimeMillis();
    Arrays.sort(data2);
    t2 = System.currentTimeMillis();
    stime = t2 - t1;
    System.out.println("Merge: " + mtime + "\nArray.Sort: " + stime);
    System.out.println("Ratio: " + (double)mtime/stime);
    if(!Arrays.equals(data1, data2)){
      System.out.println("FAILED!");
    } else {
      System.out.println("WOOHOO!");
    }
  }

}
