import java.io.*;
import java.util.*;

public class Problem12BFS {
  private static ArrayList<String[]> paths;

  //================================================================================
  // CODE RUNNER
  //================================================================================
  public static void main(String[] args) throws IOException {
    paths = new ArrayList<String[]>(); // format for each path array: start, end

    // init
    Scanner input = new Scanner(new File("input1.txt"));
    String[] lines;
    while (input.hasNextLine()) {
      lines = input.nextLine().split("-");
      paths.add(new String[]{lines[0], lines[1]});
      paths.add(new String[]{lines[1], lines[0]});
    }

    ArrayList<ArrayList<String>> pathsQueue = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> workingPaths = new ArrayList<ArrayList<String>>();

    ArrayList<String> start = new ArrayList<String>();
    start.add("start");

    // run and return part 1
    pathsQueue.add(start);
    findPaths(pathsQueue, workingPaths, 1);
    System.out.println("Part 1: " + workingPaths.size());

    // run and return part 2
    workingPaths.clear();
    pathsQueue.add(start);
    //findPaths(pathsQueue, workingPaths, 2);
    //System.out.println("Part 2: " + workingPaths.size());
  }


  //================================================================================
  // FINDPATHS FUNCTIONS
  //================================================================================
  private static void findPaths(ArrayList<ArrayList<String>> pathsQueue, ArrayList<ArrayList<String>> workingPaths, int smallCaveTimes) {
    while (pathsQueue.size() > 0) {
      ArrayList<String> currentPath = pathsQueue.remove(0);
      String currentCave = currentPath.get(0);

      if (currentCave.equals("end")) { // check if it's the end
        workingPaths.add(currentPath);

      } else {
        for (String[] path : paths) {
          ArrayList<String> nextPath = new ArrayList<String>();
          nextPath.addAll(currentPath);

          if (path[0].equals(currentCave)) { // check that starting cave is the same as the one we're in
            if (isSmallCave(path[1])) { // small cave, check for restrictions
              if (smallCaveVisitedTimes(nextPath, smallCaveTimes)) {
                if (!hasVisited(nextPath, currentCave)) {
                  nextPath.add(0, path[1]);
                  pathsQueue.add(nextPath);
                }
              } else {
                nextPath.add(0, path[1]);
                pathsQueue.add(nextPath);
              }

            } else if { // big cave, no restrictions
              nextPath.add(0, path[1]);
              pathsQueue.add(nextPath);
              System.out.println(nextPath);
            }
          }
        }

      }

    }
  }


  //================================================================================
  // CAVE-SPECIFIC HELPER FUNCTIONS
  //================================================================================

  // check if the cave is small (meaning all lowercase letters)
  private static boolean isSmallCave(String location) {
    for (int i = 0; i < location.length(); i++) {
      if (!Character.isLowerCase(location.charAt(i))) return false;
    }
    return true;
  }

  // check if any small cave has been visited numTimes times
  private static boolean smallCaveVisitedTimes(ArrayList<String> nextPath, int numTimes) {
    for (String cave : nextPath) {
      if (!cave.equals("start")) {
        if (isSmallCave(cave) && (Collections.frequency(nextPath, cave) == numTimes)) {
          return true;
        }
      }
    }
    return false;
  }

  // check if the cave has been visited
  private static boolean hasVisited(ArrayList<String> nextPath, String targetCave) {
    for (int i = 0; i < nextPath.size(); i++) {
      if (nextPath.get(i).equals(targetCave)) return true;
    }
    return false;
  }
}
