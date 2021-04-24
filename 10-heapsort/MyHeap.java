import java.util.*;

public class MyHeap {
  /*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided that child is larger.
  This stops when a leaf is reached, or neither child is larger.
  *@param size the number of heap elements in the data array.
          This is needed to allow a partially full array to be provided.
  *@precondition the children of data[index] are valid heaps.
  *@precondition index is between 0 and size-1 inclusive
  *@precondition size is between 0 and data.length inclusive.
  */
  private static void pushDown(int[] data, int size, int index) {
    boolean done = false;
    while (!done) {
      int l = 2 * index + 1; //left child
      int r = 2 * index + 2; //right child
      if (l >= size) done = true; //if a leaf is reached, terminate loop (no left child = no children)
      else {
        int temp = data[index];
        int max = Math.max(temp, data[l]); //finds the larger value between the parent and left node
        if (r < size) max = Math.max(max, data[r]); //finds the largest node if there is a right child
        if (max == temp) done = true; //if neither child is larger, terminate loop
        //swap with the larger of the child nodes
        else if (max == data[l]) { //if left child is the largest
          data[index] = data[l];
          data[l] = temp;
          index = l; //keep track of index
        } else { //if right child is the largest
          data[index] = data[r];
          data[r] = temp;
          index = r; //keep track of index
        }
      }
    }
  }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
  private static void buildHeap(int[] data) {
    int row = ((data.length - 1) - 1) / 2; //parent of the last child
    for (int i = row; i >= 0; i--) { //start at the last index with a child
      pushDown(data, data.length, i); //push down children to the correct place
    }
  }

  /*Swap the root node with the element at the provided index.
  *Then push the new root down, but not past the index that it swapped with.
  *@precondition: size is between 0 and data.length inclusive.
  */
  private static void remove(int[] data, int size) {
    int temp = data[0];
    data[0] = data[size-1]; //swap the root with the last node
    data[size-1] = temp;
    pushDown(data, size-1, 0); //reduce the heap size by 1 and push down the new root to the correct place
                               //size of heap is equal to the index
  }

  /*Sort the provided array
  *@param data is the array to be sorted
  */
  public static void heapsort(int[] data) {
    buildHeap(data); //turn the array into a heap
    for (int i = data.length; i > 0; i--) {
      remove(data, i); //remove all elements
    }
  }

  public static void main(String[] args) {
    /*
    int[] arr = {3, 11, 8, 7, 6, 5, 4, 2, 1};
    System.out.println("arr before: " + Arrays.toString(arr));
    pushDown(arr, arr.length, 0);
    System.out.println("arr after: " + Arrays.toString(arr) + "\n");

    int[] arr1 = {1, 2, 3, 4, 5, 6};
    System.out.println("arr1: " + Arrays.toString(arr1));
    buildHeap(arr1);
    System.out.println("arr1: " + Arrays.toString(arr1) + "\n");

    int[] arr2 = {1, 10, 9, 8, 7, 1, 9};
    System.out.println("arr2: " + Arrays.toString(arr2));
    buildHeap(arr2);
    System.out.println("arr2: " + Arrays.toString(arr2) + "\n");

    int[] arr3 = {23, 1, 6, 19, 14, 18, 8, 24, 15};
    buildHeap(arr3);
    System.out.println("arr3: " + Arrays.toString(arr3));
    remove(arr3, arr3.length);
    System.out.println("arr3: " + Arrays.toString(arr3));
    remove(arr3, arr3.length-1);
    System.out.println("arr3: " + Arrays.toString(arr3));
    heapsort(arr3);
    System.out.println("arr3: " + Arrays.toString(arr3) + "\n");
    */
    int size = 10000000;
    //sorted array
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
    heapsort(data1);
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
