public class Recursion {
  /*
  *@param s : any string
  *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion
  */
  public static String reverse(String s) {
    if (s.equals("")) {
      return s;
    }
    //ABCD -> D + reverse(ABC)
    return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
  }

  /*
  *@param n : any non-negative value you want to take the sqrt of
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n) {
    //Hint: This is a wrapper method
    if (n == 0) {
      return 0;
    }
    return sqrt(n, 1); //guess any number for the sqrt of n. (like n/2, or even 1)
  }
  /*
  *@param n : any non-negative value you want to take the sqrt of
  *@param guess : guess any number for the sqrt of n
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  private static double sqrt(double n, double guess) {
    if (Math.abs((guess * guess - n) / n) * 100 < 0.001) { //done until guess squared is close to n by a % difference of some threshold
      return guess;
    }
    return sqrt(n, (n / guess + guess) / 2); //make a better guess
  }

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z
  *Repetition allowed except when letters are adjacent
  */
  public static long countNoDoubleLetterWords(int length, String word){
    //Hint: not a wrapper method, but you must call it starting with "" as your word
    if (length == 0) {
      return 1; //when word is the correct length, count 1
    } else {
      long ans = 0;
      for (char c = 'a'; c <= 'z'; c++) {
        if (word.length() == 0 || c != word.charAt(word.length()-1)) {
          ans += countNoDoubleLetterWords(length-1, word + c); //increment from ans
        }
      }
      return ans;
    }
  }

  /* TESTING
  public static void main(String[] args) {
    System.out.println("\nTesting reverse");
    reverseTester("abcd");
    reverseTester("omg does this even work");
    reverseTester("this is crazy");
    System.out.println("--------------------------------");

    System.out.println("\nTesting sqrt");
    System.out.println(sqrt(100)); //return 10
    System.out.println(sqrt(49)); //return 7
    System.out.println(sqrt(0)); //return 0
    System.out.println(sqrt(35)); //return 5.916
    System.out.println(sqrt(10)); //return 3.162
    System.out.println(sqrt(2)); //return 1.414
    System.out.println(sqrt(5)); //return 2.236
    System.out.println(sqrt(4.5)); //return 2.121
    System.out.println("--------------------------------");

    System.out.println("\nTesting countNoDoubleLetterWords");
    //System.out.println(countNoDoubleLetterWords(2, ""));
    countNoDoubleLetterWordsTester(1);
    countNoDoubleLetterWordsTester(3);
    countNoDoubleLetterWordsTester(6);
    System.out.println("--------------------------------");
  }

  //return WRONG when there is an error
  public static void reverseTester(String str) {
    String actual = reverse(str);
    String expected = "";
    if (str.length() > 0) {
      for (int i = str.length()-1; i >= 0; i--) {
        expected += str.charAt(i);
      }
    }
    if (!actual.equals(expected)) {
      System.out.println("WRONG");
    }
    System.out.println("actual:   " + actual);
    System.out.println("expected: " + expected);
  }
  public static void countNoDoubleLetterWordsTester(int length) {
    long actual = countNoDoubleLetterWords(length, "");
    long expected = 26 * (long)Math.pow(25, length-1);
    if (actual != expected) {
      System.out.println("WRONG");
    }
    System.out.println("actual:   " + actual);
    System.out.println("expected: " + expected);
  }
  */

}
