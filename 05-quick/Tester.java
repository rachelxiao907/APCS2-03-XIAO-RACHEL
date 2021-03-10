public class Tester {
  public static void main(String[] args) {
    int[] data1 = {999,999,999,4,3,2,1,0,999,999,999};
    System.out.println(toString(data1));
    partition(data1, 0, data1.length-1);
    System.out.println(toString(data1));

    int[] data2 = {1,15,27,32,8,5,17,3};
    System.out.println(toString(data2));
    partition(data2, 0, data2.length-1);
    System.out.println(toString(data2));
  }

  public static String toString(int[] data) {
    String output = "";
    for (int i = 0; i < data.length; i++) {
      output += data[i] + " ";
    }
    return output;
  }

  public static void partition(int [] data, int start, int end) {
    if (data.length <= 1) System.out.println(start);
    int index = (int)(Math.random() * data.length);
    int pivot = data[index];
    System.out.println(pivot);
    data[index] = data[start];
    data[start] = pivot;
    index = start;
    start++;

    while (start != end) {
      if (data[start] > pivot) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end--;
      } else {
        start++;
      }
    }
    if (data[start] < pivot) {
      data[index] = data[start];
      data[start] = pivot;
      index = start;
    } else {
      data[index] = data[start-1];
      data[start - 1] = pivot;
      index = start - 1;
    }
    System.out.println(index);
  }

}
