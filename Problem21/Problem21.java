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

    //int part1 = part1(startPos);

    // return answers
    //System.out.println("Part 1: " + part1);
    long[] results = winTimes(new int[]{0,0}, startPos, 0);
    System.out.println("Part 2: " + Math.min(results[0], results[1]));
    System.out.println(Arrays.toString(results));

  }

  //================================================================================
  // RECURSIVE PART 2
  //================================================================================
  private static long[] winTimes(int[] scores, int[] pos, int turn) {
    int[][] rolls = new int[][]{{3, 1}, {4, 3}, {5, 6}, {6, 7}, {7, 6}, {8, 3}, {9, 1}};
    long[] count = new long[]{0,0};

    for (int[] roll : rolls) {
      // clean for each iteration
      int newScores[] = new int[2];
      int newPos[] = new int[2];
      for (int i = 0; i < 2; i++) {
        newScores[i] = scores[i];
        newPos[i] = pos[i];
      }

      newPos[turn] = (newPos[turn] + roll[0]) % 10;
      if (newPos[turn] == 0) newPos[turn] = 10;
      newScores[turn] += newPos[turn];

      if (newScores[turn] >= 21) {
        count[turn] += roll[1];
      } else {
        turn = (turn == 0) ? 1 : 0;
        long[] results = winTimes(newScores, newPos, turn);
        count[0] += results[0] * roll[1];
        count[1] += results[1] * roll[1];
      }
    }
    return count;
  }

  //================================================================================
  // NAIVE PART 1
  //================================================================================
  private static int part1(int[] startPos) {
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
