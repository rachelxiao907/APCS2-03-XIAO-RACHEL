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
  public static int partition (int[] data, int start, int end) {
    if (start == end || data.length <= 1) return start; //fixed out of bounds error

    int index = (int)(Math.random() * (end - start + 1)) + start; //when choosing a pivot, use a random index
    int pivot = data[index]; //the corresponding element of median index is designated to the pivot element
    //System.out.println(index); //debugging
    //System.out.println(pivot);
    data[index] = data[start]; //swap start value and pivot value
    data[start] = pivot;
    index = start;
    start++; //increase start by 1 to check other values

    boolean left = true;
    //sorting array according to pivot
    while (start != end) {
      //when a data element is equal to the pivot, make a 50% chance that you swap it to the other side
      if (data[start] == pivot) left = !left; //every time you see an equal value negate the boolean
      if (data[start] > pivot || (data[start] == pivot && left)) { //if greater than pivot, move to the end (right side)
        int temp = data[start];
        data[start] = data[end]; //swap data[start] and data[end]
        data[end] = temp;
        end--; //shorten middle section
      } else { //if less than pivot, leave value on left side
        start++; //shorten middle section
      }
    }

    //figure out where to put the last value (when start == end)
    if (data[start] < pivot) { //if value is less than pivot, then swap
      data[index] = data[start]; //swap values
      data[start] = pivot;
      index = start; //pivot index is the middle index
    } else { //if value is greater than pivot
      data[index] = data[start-1]; //move this value to left of pivot by swapping
      data[start - 1] = pivot; //place pivot before start value
      index = start - 1;
    }
    return index;
  }

}
