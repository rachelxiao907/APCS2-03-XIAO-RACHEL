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
    return sqrt(n, n / 2); //guess any number for the sqrt of n. (like n/2, or even 1)
  }
  /*
  *@param n : any non-negative value you want to take the sqrt of
  *@param guess : guess any number for the sqrt of n
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n, double guess) {
    if (Math.abs((guess * guess - n) / n) * 100 < 0.001) { //done until guess squared is close to n by a % difference of some threshold
      return guess;
    }
    return sqrt(n, (n / guess + guess) / 2); //make a better guess
  }

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z.
  *Repetition allowed except when letters are adjacent.
  */
  public static long countNoDoubleLetterWords(int length,String word){
    //Hint: not a wrapper method, but you must call it starting with "" as your word.
    if (length == 0) {
      return 1; //when word is the correct length, count 1
    } else {
      long ans = 0;
      for (char c = 'a'; c <= 'z'; c++) {
        if (word.length() == 0 || c != word.charAt(word.length()-1)) {
          ans = 1 + countNoDoubleLetterWords(length-1, word + c);
        }
      }
      return ans;
    }
  }

  public static void main(String[] args) {
    System.out.println(reverse("abcd"));
    System.out.println(sqrt(100));
    System.out.println(countNoDoubleLetterWords(2, ""));
  }

}
