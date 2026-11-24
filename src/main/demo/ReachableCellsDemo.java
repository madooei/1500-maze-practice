package demo;

import practice.ReachableCells;

/** A demo of ReachableCells on the notes' first example. */
public final class ReachableCellsDemo {

  private ReachableCellsDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // 'S' is the start, '#' is a wall, and '.' is an open cell.
    char[][] maze = {
      {'S', '.', '#'},
      {'.', '.', '#'},
      {'#', '.', '.'},
    };

    System.out.println("Maze:");
    for (int row = 0; row < maze.length; row++) {
      System.out.println(new String(maze[row]));
    }
    System.out.println();

    // Every open cell is reachable, the start included. Expect 6.
    System.out.println("Reachable cells: " + ReachableCells.reachableCount(maze));
  }
}
