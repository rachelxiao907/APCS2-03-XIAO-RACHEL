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
    while (l < left.length && r < right.length) { //comapre corresponding values of left and right subarrays
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
    mergesortH(data, 0, data.length-1);
    System.out.println(Arrays.toString(data));

    int size = 1000000;
    int max = size;
    int[] data1 = new int[size];
    int[] data2 = new int[size];
    for(int i = 0; i < data1.length; i++) {
      data1[i] = (int)(Math.random()*max);
      data2[i] = data1[i];
    }

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

  }

}
