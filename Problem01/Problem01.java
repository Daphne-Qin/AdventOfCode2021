import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem01 {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<Integer>();

    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextInt()) {
        nums.add(input.nextInt());
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    System.out.println(findGreaterSingle(nums));
    System.out.println(findGreaterTriple(nums));


/*
    try {
      String mode = args[1];

      int result = 0;
      ArrayList<Integer> numContainers = new ArrayList<Integer>(); // used for part 2

      // goes through each iteration
      for (int i = 0; i < Math.pow(2, totalContainers); i++) {
        String on = fillBinary(Integer.toBinaryString(i), totalContainers); // 1s are added, 0s are not
        if (selectiveSum(containers, on) == desiredSum) {
          if (mode.equals("1")) {
            result++;
          } else if (mode.equals("2")) {
            numContainers.add(Integer.bitCount(i)); // bitCount() is used for counting how many containers are used
          }
        }
      }

      // extra part 2 steps to find the lowest number of containers needed and how many permutations of that there are
      if (mode.equals("2")) {
        Collections.sort(numContainers);
        int leastContainers = numContainers.get(0);
        for (int i = 0; numContainers.get(i) == leastContainers; i++) {
          result++;
        }
      }

      if (!mode.equals("1") && !mode.equals("2")) result = -1;
      System.out.println(result);

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid syntax: use \"java Problem17 [filename] [1/2]\".");
    }
    */
  }

  //================================================================================
  // PART 1
  //================================================================================
  private static int findGreaterSingle(ArrayList<Integer> nums) {
    int result = 0;
    for (int i = 1; i < nums.size(); i++) {
      if (nums.get(i) > nums.get(i-1)) result++;
    }
    return result;
  }
  //================================================================================
  // PART 2
  //================================================================================
  private static int findGreaterTriple(ArrayList<Integer> nums) {
    int result = 0;
    int sum1, sum2;
    for (int i = 1; i < 1999; i += 6) {
      sum1 = nums.get(i)+nums.get(i+1)+nums.get(i+2);
      sum2 = nums.get(i+3)+nums.get(i+4)+nums.get(i+5);
      if (sum2 > sum1) result++;
    }
    return result;
  }
}
