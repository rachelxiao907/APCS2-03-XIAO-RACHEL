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
    if (data.length <= 1 || start == end) return start; //fixed out of bounds error

    int index = (start + end) / 2 + start; //middle index of subset
    //when choosing a pivot, use the median value of the lo, hi, and middle elements
    if (data[end] >= data[start] && data[start] >= data[index] || data[end] <= data[start] && data[start] <= data[index]) {
      index = start; //if start value is the median, make index of pivot start
    } else if (data[start] >= data[end] && data[end] >= data[index] || data[start] <= data[end] && data[end] <= data[index]) {
      index = end; //if start value is the median, make index of pivot end
    }

    int pivot = data[index]; //the corresponding element of median index is designated to the pivot element
    //System.out.println(index); //debugging
    //System.out.println(pivot);
    data[index] = data[start]; //swap start value and pivot value
    data[start] = pivot;
    index = start;
    start++; //increase start by 1 to check other values

    //sorting array according to pivot
    while (start != end) {
      int r = (int)(Math.random() * 2); //assigns r = 0 to right and r = 1 to left
      if (data[start] > pivot || (data[start] == pivot && r == 0)) { //if greater than pivot, move to the end (right side)
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
