import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[])new Object[10]; //default constructor
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    data = (E[])new Object[initialCapacity];
  }

  public int size() {
    return size; //number of elements in array
  }

  public String toString() {
    String output = "{";
    int index = start;
    for (int i = 0; i < size; i++) { //loop through all elements
      output += data[index % data.length]; //add element at index modded by data.length
      if (i != size - 1) output += ", ";
      index++; //increase index
    }
    return output + "}";
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] arr = (E[]) new Object[data.length * 2 + 1]; //create a bigger and new array
    int index = start;
    for (int i = 0; i < size; i++) { //loop through all elements
      arr[i] = data[index % data.length];
      index++; //increase index
    }
    data = arr;
    start = 0; //set start to zero
    end = size - 1; //set end to size-1
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException(); //if the specified element is null
    if (size == data.length) resize(); //if the array is filled with elements
    if (size != 0) { //if size is zero, start doesn't need to be changed
      if (start == 0) { //if start is zero, front moves to the back of array
        start = data.length - 1; //loop around the back
      } else {
        start--; //decrease start to add to left of front
      }
    }
    //System.out.println(start); //debugging
    data[start] = element;
    size++;
  }

  public void addLast(E element) {
    if (element == null) throw new NullPointerException(); //if the specified element is null
    if (size == data.length) resize(); //if the array is filled with elements
    if (size != 0) { //if size is zero, end doesn't need to be changed
      if (end == data.length - 1) { //if end is the last index, back moves to the front of array
        end = 0; //loop around the front
      } else {
        end++; //increase end to add to the right of back
      }
    }
    //System.out.println(end); //debugging
    data[end] = element;
    size++;
  }

  public E removeFirst() {
    if (size == 0) throw new NoSuchElementException(); //if deque is empty
    E removed = data[start]; //removed element
    data[start] = null;
    if (size != 1) { //if size is 1, start stays the same because there is no element to the right of it
      if (start == data.length - 1) { //if start is at the end of the array, loop to the front
        start = 0;
      } else {
        start++; //increase start to the right of front
      }
    }
    //System.out.println(start); //debugging
    size--;
    return removed;
  }

  public E removeLast() {
    if (size == 0) throw new NoSuchElementException(); //if deque is empty
    E removed = data[end]; //removed element
    data[end] = null;
    if (size != 1) { //if size is 1, end stays the same because there is no element to the left of it
      if (end == 0) { //if end is at the front of the array, loop to the back
        end = data.length - 1;
      } else {
        end--; //decrease end to the left of back
      }
    }
    //System.out.println(end); //debugging
    size--;
    return removed;
  }

  public static void main(String[] args) {
    MyDeque <Integer> d = new MyDeque<Integer>();
    d.addFirst(1);
    System.out.println(d);
    d.addFirst(2);
    System.out.println(d);
    d.addLast(3);
    System.out.println(d);
    d.addLast(4);
    System.out.println(d);
    System.out.println(d.removeFirst());
    System.out.println(d);
    System.out.println(d.removeLast());
    System.out.println(d);
  }

}
