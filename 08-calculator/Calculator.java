import java.util.*;

public class Calculator {
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  */
  public static double eval(String s) {
    if (s.length() == 0) {
      throw new IllegalArgumentException();
    }
    String[] expression = s.split(" "); //convert your string into tokens (a list of values and operators)
    ArrayDeque<Double> stack = new ArrayDeque<Double>(); //use a Deque to store your values and act as the stack

    for (String token: expression) {
      //System.out.println(token); //test your tokens by printing each one!
      //instead of printing each one, decide what you should do with them and the stack (operators are never stored)
      if (token.equals("+")) { //addition
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands"); //all operators are binary
        stack.addFirst(stack.removeFirst() + stack.removeFirst()); //remove first two values and replace them with the solution
      }
      else if (token.equals("-")) { //subtraction
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands");
        double second = stack.removeFirst();
        double first = stack.removeFirst();
        stack.addFirst(first - second); //evaluate left to right
      }
      else if (token.equals("/")) { //division
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands");
        double second = stack.removeFirst();
        double first = stack.removeFirst();
        stack.addFirst(first / second);
      }
      else if (token.equals("*")) { //multiplication
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands");
        stack.addFirst(stack.removeFirst() * stack.removeFirst()); //communitive property
      }
      else if (token.equals("%")) { //modulo
        if (stack.size() < 2) throw new IllegalArgumentException("too few operands");
        double second = stack.removeFirst();
        double first = stack.removeFirst();
        stack.addFirst(first % second);
      }
      else { //if token is a number and not an operator
        stack.addFirst(Double.parseDouble(token)); //add number to top of stack
      }
    }
    if (stack.size() != 1) { //if there is more than one value in the stack, there are too many operands as the only value left should be the solution
      throw new IllegalArgumentException("too many operands");
    }
    return stack.getFirst(); //return solution
  }

  public static void main(String[] args) {
    System.out.println(eval("11 3 - 4 + 2.5 *")); //30.0
    System.out.println(eval("10 2.0 +")); //12.0
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //893.0
    System.out.println(eval("1 2 3 4 5 + * - -")); //26.0
    System.out.println(eval("5 9 + 2 * 6 5 * +")); //58.0
    System.out.println(eval("32 17 -")); //15.0
    System.out.println(eval("4 2 + 3 5 1 - * +")); //18.0
    System.out.println(eval("5 7 + 6 2 - *")); //48.0
    System.out.println(eval("4 5 7 2 + - *")); //-16.0
    System.out.println(eval("3 4 + 2 * 7 /")); //2.0
    System.out.println(eval("-3 -6 +")); //-9.0
    try {
      System.out.println(eval(""));
    } catch (IllegalArgumentException e) {
      System.out.println("woo");
    }
    try {
      System.out.println(eval("5 3 7 9 + +")); //too many operands
    } catch (IllegalArgumentException e) {
      System.out.println("woo too much");
    }
    try {
      System.out.println(eval("4 2 3 5 1 - + * + *")); //not enough operands
    } catch (IllegalArgumentException e) {
      System.out.println("woo too little");
    }
  }

}
