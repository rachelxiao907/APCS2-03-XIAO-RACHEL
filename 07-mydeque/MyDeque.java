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
    for (int i = start; i < size; i++) {
      output += data[i];
      if (i != size - 1) output += ", ";
    }
    return output + "}";
  }

  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }

  public static void main(String[] args) {
    MyDeque <Integer> d = new MyDeque<Integer>();
    System.out.println(d);
  }

}
