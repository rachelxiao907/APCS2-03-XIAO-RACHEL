import java.util.*;
import java.io.*;
public class Tester {
  public static void main(String[] args) {
    System.out.println("\n---------------Mr K's Tester---------------");
    System.out.println(test6(5000));
    System.out.println("\n---------------MyDeque---------------");
    MyDeque<Integer> d = new MyDeque<Integer>();
    ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
    for (int i = 0; i < 8; i++) {
      d.addFirst(i); //first element is 7
      dq.addFirst(i);
    }
    System.out.println(d);
    System.out.println(d.getFirst());
    for (int i = 8; i < 16; i++) {
      d.addLast(i); //last element is 15
      dq.addLast(i);
    }
    System.out.println(d);
    System.out.println(dq);
    if (d.getFirst() == dq.getFirst() && d.getLast() == dq.getLast() && d.removeFirst() == dq.removeFirst() && d.removeLast() == dq.removeLast()) {
      System.out.println("WOOHOO");
    } else System.out.println("FAIL");

    MyDeque<Integer> d1 = new MyDeque<Integer>(100);
    ArrayDeque<Integer> dq1 = new ArrayDeque<Integer>(100);
    int size = 1000;
    for (int i = 0; i < size; i++) {
      int r = (int)(Math.random() * size);
      d1.addFirst(r);
      dq1.addFirst(r);
    }
    String s1 = d1.toString();
    String sq1 = dq1.toString();
    if (sameString(s1, sq1)) {
      System.out.println("WOOHOO");
    } else System.out.println("FAIL");

    System.out.println("\n---------------Empty MyDeque---------------");
    MyDeque <Integer> d0 = new MyDeque<Integer>(0);
    System.out.println(d0);
    System.out.println(d0.size());
    d0.addLast(2);
    System.out.println(d0);
    MyDeque <Integer> d01 = new MyDeque<Integer>(0);
    d01.addFirst(1);
    System.out.println(d01);
  }

  public static boolean sameString(String a, String b) {
      return a.substring(1, a.length()-1).equals(b.substring(1, b.length()-1));
  }

  public static boolean equals(MyDeque<Integer>a, ArrayDeque<Integer>b){
    if(a==null && b==null)
      return true;
    if(a==null || b==null)
        return false;
    if(a.size()!=b.size())
      return false;
    if(a.size()==0 && b.size()==0)
      return true;

    try{
      while(b.size()>0){
        if(!a.removeFirst().equals(b.removeFirst())){
          return false;
        }
      }
    }catch(NoSuchElementException e){
      return false;
    }
    return b.size()==0;
  }

  public static int test6(int max){
    MyDeque<Integer> a = new MyDeque<Integer>();
    ArrayDeque<Integer>b = new ArrayDeque<Integer>();

    for(int i = 0; i < max; i++){
      int op = (int)(Math.random()*4);
      if(op == 0){
        a.addLast(i);
        b.addLast(i);
      }
      if(op == 1){
        a.addFirst(i);
        b.addFirst(i);
      }
      if(op == 2){
        if(b.size()>0){
          if(! a.getLast().equals(b.getLast())){
            System.out.println("Fail test6a "+a.getLast()+" vs "+b.getLast());
            return 0;
          }
          a.removeLast();
          b.removeLast();
        }
      }
      if(op == 3){
        if(b.size()>0){
          if(! a.getFirst().equals(b.getFirst())){
            System.out.println("Fail test6a "+a.getFirst()+" vs "+b.getFirst());
            return 0;
          }
          a.removeFirst();
          b.removeFirst();
        }
      }
    }
    if( equals(a,b) ){
      return 1;
    }
    System.out.println("Fail test6 end");
    return 0;
  }

}
