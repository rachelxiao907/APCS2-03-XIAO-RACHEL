public class Driver {
  public static void main(String[] args) {
    QueenBoard b = new QueenBoard(1);
    QueenBoard b1 = new QueenBoard(2);
    QueenBoard b2 = new QueenBoard(3);
    QueenBoard b3 = new QueenBoard(4);
    QueenBoard b4 = new QueenBoard(5);
    QueenBoard b5 = new QueenBoard(6);
    QueenBoard b6 = new QueenBoard(7);
    QueenBoard b7 = new QueenBoard(8);

    System.out.println("\n---Testing countSolutions---");

    System.out.println(b.countSolutions());
    System.out.println(b1.countSolutions());
    System.out.println(b2.countSolutions());
    System.out.println(b3.countSolutions());
    System.out.println(b4.countSolutions());
    System.out.println(b5.countSolutions());
    System.out.println(b6.countSolutions());
    System.out.println(b7.countSolutions());

    System.out.println("-------------------------------");

    System.out.println("---Testing solve and toString---");
    System.out.println(b.solve());
    System.out.println(b);
    System.out.println(b1.solve());
    System.out.println(b1);
    System.out.println(b2.solve());
    System.out.println(b2);
    System.out.println(b3.solve());
    System.out.println(b3);
    System.out.println(b4.solve());
    System.out.println(b4);
    System.out.println(b5.solve());
    System.out.println(b5);
    System.out.println(b6.solve());
    System.out.println(b6);
    System.out.println(b7.solve());
    System.out.println(b7);

    System.out.println("---Testing Exceptions---");
    //System.out.println(b4.solve());
    System.out.println(b4.countSolutions());

  }
}
