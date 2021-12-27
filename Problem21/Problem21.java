import java.io.*;
import java.util.*;

public class Problem21 {
  //================================================================================
  // CODE RUNNER
  //================================================================================
  public static void main(String[] args) throws IOException {
    // init
    Scanner input = new Scanner(new File("input.txt"));
    int[] startPos = new int[2];
    for (int i = 0; i < 2; i++) {
      startPos[i] = Integer.parseInt( input.nextLine().split(" ")[4] );
    }

    int part1 = part1(startPos);
    // return answers
    System.out.println("Part 1: " + part1);
    System.out.println("Part 2: " + "N/A");

  }

  private static int part1(int[] startPos) { // naive
    Player p1 = new Player(startPos[0]);
    Player p2 = new Player(startPos[1]);

    int playerTurn = 1;
    int rollCount = 0;
    while (p1.getScore() < 1000 && p1.getScore() < 1000) {
      for (int i = 1; i <= 3; i++) {
        rollCount++;
        int currentRoll = rollCount % 100;
        if (currentRoll == 0) currentRoll = 100;

        if (playerTurn == 1) p1.move(currentRoll);
        if (playerTurn == 2) p2.move(currentRoll);
      }
      if (playerTurn == 1) p1.addScore();
      if (playerTurn == 2) p2.addScore();

      playerTurn = (playerTurn == 1) ? 2 : 1;
    }
    return Math.min(p1.getScore(), p2.getScore()) * rollCount;
  }
}
