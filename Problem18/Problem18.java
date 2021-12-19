import java.io.*;
import java.util.*;

public class Problem18 {
  //================================================================================
  // CODE RUNNER
  //================================================================================
  public static void main(String[] args) throws IOException {
    //init
    Scanner input = new Scanner(new File("input.txt"));
    ArrayList<SnailNumber> snailNums = new ArrayList<SnailNumber>();
    ArrayList<String> raw = new ArrayList<String>();
    while (input.hasNextLine()) {
      raw.add(input.nextLine());
    }

    for (int i = 0; i < raw.size(); i++) {
      snailNums.add(new SnailNumber(raw.get(i)));
    }

    System.out.println("Part 1: " + totalSum(snailNums));
  }

  private static int totalSum(ArrayList<SnailNumber> snailNums) {
    SnailNumber sum = snailNums.get(0);
    for (int i = 1; i < snailNums.size(); i++) {
      sum.add(snailNums.get(i));
    }
    return sum.getMagnitude();
  }
}
