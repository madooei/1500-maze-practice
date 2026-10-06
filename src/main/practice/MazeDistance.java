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
    if (!isOpen(maze, 0, 0)) {
      return -1;
    }

    int rows = maze.length;
    int cols = maze[0].length;
    int[][] distance = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        distance[row][col] = -1;
      }
    }

    Queue<Position> toExplore = new LinkedQueue<>();
    toExplore.enqueue(new Position(0, 0));
    distance[0][0] = 0;

    int[] rowChange = {0, 1, 0, -1};
    int[] colChange = {1, 0, -1, 0};

    while (!toExplore.isEmpty()) {
      Position current = toExplore.front();
      toExplore.dequeue();

      if (isExit(maze, current.row, current.col)) {
        return distance[current.row][current.col];
      }

      for (int i = 0; i < rowChange.length; i++) {
        int nextRow = current.row + rowChange[i];
        int nextCol = current.col + colChange[i];
        if (isOpen(maze, nextRow, nextCol)
            && distance[nextRow][nextCol] == -1) {
          distance[nextRow][nextCol] =
              distance[current.row][current.col] + 1;
          toExplore.enqueue(new Position(nextRow, nextCol));
        }
      }
    }

    return -1;
  }
}
