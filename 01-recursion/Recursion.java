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
    return sqrt(n, 1);
  }
  /*
  *@param n : any non-negative value you want to take the sqrt of
  *@param guess : guess any number for the sqrt of n
  *@return the approximate sqrt of n within a certain tolerance
  */
  public static double sqrt(double n, double guess) {
    if (Math.abs((guess * guess - n) / n) * 100 < 0.001) {  //done until guess squared is close to n by a % difference of some threshold
      return guess;
    }
    return sqrt(n, (n / guess + guess) / 2);
  }

  public static void main(String[] args) {
    System.out.println(reverse("abcd"));
    System.out.println(sqrt(100));
  }

}
