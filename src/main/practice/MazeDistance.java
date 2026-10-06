package practice;

import java.util.List;
import java.util.ArrayList;
import stack.Stack;
import stack.ArrayStack;
import queue.Queue;
import queue.LinkedQueue;

/** Solutions to the maze distance and maze path problems. */
public final class MazeDistance {

  private MazeDistance() {
    // This class should not be instantiated!
  }

  /**
   * A cell in the maze: a row and a column. It is public because
   * pathToExit returns a list of them.
   */
  public static class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
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

  // Returns the number of moves the queue search takes from the top-left cell
  // to the bottom-right cell, or -1 if the exit cannot be reached. Assumes
  // maze is not null, rectangular, and has at least one cell.
  public static int distanceToExit(char[][] maze) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Returns the cells of the route the queue search takes from the top-left
  // cell to the bottom-right cell, in order from start to exit, or an empty
  // list if the exit cannot be reached. Assumes maze is not null,
  // rectangular, and has at least one cell.
  public static List<Position> pathToExit(char[][] maze) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Follows the cameFrom links back from the exit and returns the cells in
  // order from start to exit.
  private static List<Position> reconstruct(Position[][] cameFrom, Position exit) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
