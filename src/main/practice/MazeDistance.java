package practice;

import queue.Queue;
import queue.LinkedQueue;

/** Solution to the maze distance problem. */
public final class MazeDistance {

  private MazeDistance() {
    // This class should not be instantiated!
  }

  /** A cell in the maze: a row and a column. */
  private static class Position {
    int row;
    int col;

    Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  // Can we enter cell (row, col)? It must be inside the maze and not a wall.
  // The bounds checks come before reading maze[row][col] so a move off the
  // edge never accesses an invalid array index.
  private static boolean isOpen(char[][] maze, int row, int col) {
    return row >= 0
        && row < maze.length
        && col >= 0
        && col < maze[0].length
        && maze[row][col] != '#';
  }

  // Are we standing on the exit? The exit is the bottom-right cell.
  private static boolean isExit(char[][] maze, int row, int col) {
    return row == maze.length - 1 && col == maze[0].length - 1;
  }

  // Returns the number of moves the queue search takes from the top-left cell
  // to the bottom-right cell, or -1 if the exit cannot be reached. Assumes
  // maze is not null, rectangular, and has at least one cell.
  public static int distanceToExit(char[][] maze) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
