import java.util.*;
public class Frontier {
  private ArrayDeque<int[]> frontier; //collection of the positions of FIRE

  public Frontier() {
    frontier = new ArrayDeque<int[]>();
  }

  public int size() {
    return frontier.size(); //get the current size of the Frontier
  }

  public void add(int[] location) {
    //process the older positions before the new positions
    frontier.addLast(location); //add a new position to the Frontiers
  }

  public int[] remove() {
    //FIFO behavior
    return frontier.removeFirst(); //remove the position and return it
  }
}
