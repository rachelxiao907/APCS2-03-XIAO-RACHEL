import java.util.*;

public class MyHeap {
  /*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided thatchild is larger.
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

    int[] arr1 = {1, 2, 3, 4, 5, 6};
    System.out.println("arr1: " + print(arr1));
    buildHeap(arr1);
    System.out.println("arr1: " + print(arr1) + "\n");

    int[] arr2 = {1, 10, 9, 8, 7, 1, 9};
    System.out.println("arr2: " + print(arr2));
    buildHeap(arr2);
    System.out.println("arr2: " + print(arr2) + "\n");

    int[] arr3 = {23, 1, 6, 19, 14, 18, 8, 24, 15};
    buildHeap(arr3);
    System.out.println("arr3: " + print(arr3));
    remove(arr3, arr3.length);
    System.out.println("arr3: " + print(arr3));
    remove(arr3, arr3.length-1);
    System.out.println("arr3: " + print(arr3));
    heapsort(arr3);
    System.out.println("arr3: " + print(arr3) + "\n");
  }

}
