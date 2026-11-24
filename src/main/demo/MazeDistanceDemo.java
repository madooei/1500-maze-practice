package demo;

import practice.MazeDistance;

/** A demo of MazeDistance on the notes' first example. */
public final class MazeDistanceDemo {

  private MazeDistanceDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // 'S' is the start, 'E' is the exit, '#' is a wall, and '.' is an open cell.
    char[][] maze = {
      {'S', '.', '.'},
      {'#', '#', '.'},
      {'.', '.', 'E'},
    };

    System.out.println("Maze:");
    for (int row = 0; row < maze.length; row++) {
      System.out.println(new String(maze[row]));
    }
    System.out.println();

    // The only path goes along the top row and down the right column. Expect 4.
    System.out.println("Moves to the exit: " + MazeDistance.distanceToExit(maze));
  }
}
