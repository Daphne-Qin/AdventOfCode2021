import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProblemXX {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<Integer>();
    int input = 0;

    // integers
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

    // strings
    try {
      String line;
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        line = input.nextLine();
        String[] data = line.split(" ");
        // do something with data[]
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found!");
    }

    System.out.println("stuff");
  }

  //================================================================================
  // PART 1
  //================================================================================
  private static int name1(ArrayList<Integer> nums) {
    int result = 0;
    return result;
  }

  //================================================================================
  // PART 2
  //================================================================================
  private static int name2(ArrayList<Integer> nums) {
    int result = 0;
    return result;
  }
}
