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
  public static void buildHeap (int[] data) {

  }

  public static String print(int[] data){
    String result = "[";
    for(int i = 0; i < data.length; i++){
      result += data[i];
      if(i != data.length - 1) result += ", ";
    }
    result += "]";
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {3, 11, 8, 7, 6, 5, 4, 2, 1};
    System.out.println("arr before: " + print(arr));
    pushDown(arr, arr.length, 0);
    System.out.println("arr after: " + print(arr) + "\n");
  }

}
