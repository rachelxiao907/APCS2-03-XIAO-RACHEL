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
    for (String token: expression) {
      System.out.println(token); //test your tokens by printing each one!
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(eval("11 3 - 4 + 2.5 *"));
  }

}
