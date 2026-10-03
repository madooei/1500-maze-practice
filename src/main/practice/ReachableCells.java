package practice;

import stack.Stack;
import stack.ArrayStack;

/** Solution to the reachable cells problem. */
public final class ReachableCells {

  private ReachableCells() {
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

  // Returns the number of open cells reachable from the top-left cell, or 0
  // if the top-left cell is a wall. Assumes maze is not null, rectangular,
  // and has at least one cell.
  public static int reachableCount(char[][] maze) {
    if (!isOpen(maze, 0, 0)) {
      return 0;
    }

    int rows = maze.length;
    int cols = maze[0].length;
    boolean[][] visited = new boolean[rows][cols];
    Stack<Position> toExplore = new ArrayStack<>();

    toExplore.push(new Position(0, 0));
    visited[0][0] = true;

    int count = 0;
    int[] rowChange = {0, 1, 0, -1};
    int[] colChange = {1, 0, -1, 0};

    while (!toExplore.isEmpty()) {
      Position current = toExplore.top();
      toExplore.pop();
      count++;

      for (int i = 0; i < rowChange.length; i++) {
        int nextRow = current.row + rowChange[i];
        int nextCol = current.col + colChange[i];
        if (isOpen(maze, nextRow, nextCol) && !visited[nextRow][nextCol]) {
          toExplore.push(new Position(nextRow, nextCol));
          visited[nextRow][nextCol] = true;
        }
      }
    }

    return count;
  }
}
