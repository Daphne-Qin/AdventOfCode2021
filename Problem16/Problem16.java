import java.io.*;
import java.util.*;

public class Problem16 {
  public static int part1;

  //================================================================================
  // CODE RUNNER
  //================================================================================
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(new File("input.txt"));
    String hex = input.nextLine();

    String raw = "";
    for (int i = 0; i < hex.length(); i++) {
      raw += hexToBinary(hex.substring(i,i+1));
    }

    part1 = 0;
    System.out.println("Parsed Value: " + parsePacket(raw));
    System.out.println("Part 1: " + part1);
  }

  //================================================================================
  // PARSING THE MESSAGE
  //================================================================================
  public static int parsePacket(String raw) {
    int version;
    int packetTypeID;
    String data;

    version = Integer.parseInt(raw.substring(0,3), 2);
    packetTypeID = Integer.parseInt(raw.substring(3,6), 2);

    part1 += version; // specifically for part 1

    System.out.println("Version: " + version);
    System.out.println("Packet Type ID: " + packetTypeID);

    if (packetTypeID == 4) { // literal
      data = raw.substring(6);
      ArrayList<String> groups = new ArrayList<String>();
      boolean end = false;
      while (!end) {
        String currentGroup = data.substring(0,5);
        data = data.substring(5);

        if (currentGroup.charAt(0) == '0') end = true;

        groups.add(currentGroup.substring(1,5));
      }
      String binaryNum = "";
      for (String group : groups) {
        binaryNum += group;
      }
      return Integer.parseInt(binaryNum, 2);

    } else { // operator
      int lengthTypeID = Integer.parseInt(raw.substring(6,7));
      data = raw.substring(7);

      if (lengthTypeID == 0) {
        int lengthSubpackets = Integer.parseInt(data.substring(0,15), 2);
        // code here
      } else if (lengthTypeID == 1) {
        int numSubpackets = Integer.parseInt(data.substring(0,11), 2);
        // code here
      }
      return 0; // placeholder
    }
  }

  //================================================================================
  // CONVERT HEXADECIMAL TO BINARY
  //================================================================================
  public static String hexToBinary(String hexChar) {
    String[] hex = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    String[] binary = new String[]{"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    for (int i = 0; i < hex.length; i++) {
      if (hex[i].equals(hexChar)) {
        return binary[i];
      }
    }
    return "";
  }
}
