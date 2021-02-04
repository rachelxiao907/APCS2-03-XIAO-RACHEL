public class Recursion {
  public static String reverse(String s) {
    if (s.equals("")) {
      return s;
    }
    //ABCD -> D + reverse(ABC)
    return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
  }

  public static void main(String[] args) {
    System.out.println(reverse("abcd"));
  }

}
