import java.util.*;

public class MyHeap {
  /*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided that child is larger.
  This stops when a leaf is reached, or neither child is larger.
  *@param size the number of heap elements in the data array.
          This is needed to allow a partially full array to be provided.
  *@precondition the children of data[index] are valid heaps.
  *@precondition index is between 0 and size-1 inclusive
  *@precondition size is between 0 and data.length-1 inclusive.
  */
  private static void pushDown (int[] data, int size, int index) {
    boolean done = false;
    while (!done) {
      int l = 2 * index + 1; //left child
      int r = 2 * index + 1; //right child
      if (l >= size && r >= size) done = true; //if a leaf is reached, terminate loop
      else {
        int max = Math.max(data[index], data[l]); //finds the larger value between the parent and left node
        Math.max(max, data[r]); //finds the largest node
        if (max == data[index]) done = true; //if neither child is larger, terminate loop
      }
    }
  }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
  public static void buildHeap (int[] data) {

  }

}
