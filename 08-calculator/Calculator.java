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
    String[] expression = s.split(" "); //convert your string into tokens (a list of values and operators)
    ArrayDeque<Double> stack = new ArrayDeque<Double>(); //use a Deque to store your values and act as the stack

    for (String token: expression) {
      //System.out.println(token); //test your tokens by printing each one!
      //instead of printing each one, decide what you should do with them and the stack (operators are never stored)
      if (token.equals("+")) { //addition
        stack.addFirst(stack.removeFirst() + stack.removeFirst()); //remove first two values and replace them with the solution
      }
      else if (token.equals("-")) { //subtraction
        double second = stack.removeFirst();
        double first = stack.removeFirst();
        stack.addFirst(first - second); //evaluate left to right
      }
      else if (token.equals("/")) { //division
        double second = stack.removeFirst();
        double first = stack.removeFirst();
        stack.addFirst(first / second);
      }
      else if (token.equals("*")) { //multiplication
        stack.addFirst(stack.removeFirst() * stack.removeFirst()); //communitive property
      }
      else if (token.equals("%")) { //modulo
        double second = stack.removeFirst();
        double first = stack.removeFirst();
        stack.addFirst(first % second);
      }
      else { //if token is a number and not an operator
        stack.addFirst(Double.parseDouble(token)); //add number to top of stack
      }
    }
    //System.out.println(stack); //testing tokens
    return stack.getFirst(); //return solution
  }

  public static void main(String[] args) {
    System.out.println(eval("11 3 - 4 + 2.5 *")); //30.0
    System.out.println(eval("10 2.0 +")); //12.0
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //893.0
    System.out.println(eval("1 2 3 4 5 + * - -")); //26.0
  }

}
