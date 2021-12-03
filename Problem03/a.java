import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class a {
  //================================================================================
  // TESTER
  //================================================================================
  public static void main(String[] args) {
    ArrayList<String> binary = new ArrayList<String>();

    binary.add("00100");
    binary.add("11110");
    binary.add("10110");
    binary.add("10111");
    binary.add("10101");
    binary.add("01111");
    binary.add("00111");
    binary.add("11100");
    binary.add("11001");
    binary.add("10000");
    binary.add("00010");
    binary.add("01010");

    String[] common = gammaEpsilon(binary);
    System.out.println(Arrays.toString(common));
    //System.out.println(Integer.parseInt(common[0],2)*Integer.parseInt(common[1],2));

    String oxygen = oxygen(binary, common[0]);
    String carbon = carbon(binary, common[1]);
    System.out.println(oxygen);
    System.out.println(carbon);
    System.out.println(Integer.parseInt(oxygen,2)*Integer.parseInt(carbon,2));


  }

  // length 12 each binary
  //================================================================================
  // PART 1
  //================================================================================
  private static String[] gammaEpsilon(ArrayList<String> nums) {
    int[] num1s = new int[]{0,0,0,0,0};

    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.get(i).length(); j++) {
        if (nums.get(i).charAt(j) == '1') num1s[j]++;
      }
    }
    System.out.println(Arrays.toString(num1s));

    String gamma = "";
    String epsilon = "";
    for (int i = 0; i < num1s.length; i++) {
      if (num1s[i] > 6) {
        gamma += "1";
        epsilon += "0";
      } else if (num1s[i] < 6) {
        gamma += "0";
        epsilon += "1";
      } else {
        gamma += "2";
        epsilon += "2";
      }
    }

    String[] result = new String[2];
    result[0] = gamma;
    result[1] = epsilon;

    return (result);
  }
  //================================================================================
  // PART 2
  //================================================================================
  private static String oxygen(ArrayList<String> numss, String gamma) {
    ArrayList<String> nums=new ArrayList<>(numss);
    System.out.println(nums);
    int pos = 0;
    char greatest;
    char current;
    while (nums.size() > 1) {
      greatest = gamma.charAt(pos);
      for (int i = 0; i < nums.size(); i++) {
        current = nums.get(i).charAt(pos);
        if (current != greatest) {
          nums.remove(i);
          i--;
        }
      }
      System.out.println(nums);
      pos++;
    }
    return (nums.get(0));
  }

  private static String carbon(ArrayList<String> numss, String epsilon) {
    ArrayList<String> nums=new ArrayList<>(numss);
    System.out.println(nums);
    int pos = 0;
    char least;
    while (nums.size() > 1) {
      least = epsilon.charAt(pos);
      for (int i = 0; i < nums.size(); i++) {
        if (nums.get(i).charAt(pos) != least) {
          nums.remove(i);
          i--;
        }
      }
      System.out.println(nums);
      pos++;
    }
    return (nums.get(0));
  }

}
