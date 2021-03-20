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
    for (int i = 0; i < size; i++) {
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
    for (int i = 0; i < size; i++) {
      arr[i] = data[index % data.length];
      index++; //increase index
    }
    data = arr;
    start = 0; //set start to zero
    end = size - 1; //set end to size-1
  }

  public static void main(String[] args) {
    MyDeque <Integer> d = new MyDeque<Integer>();
    System.out.println(d);
  }

}
