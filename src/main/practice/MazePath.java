package practice;

import java.util.List;
import java.util.ArrayList;
import stack.Stack;
import stack.ArrayStack;
import queue.Queue;
import queue.LinkedQueue;

/** Solution to the maze path problem. */
public final class MazePath {

  private MazePath() {
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

  // Are we standing on the exit? The exit is the bottom-right cell.
  private static boolean isExit(char[][] maze, int row, int col) {
    return row == maze.length - 1 && col == maze[0].length - 1;
  }

  // Returns the cells of the route the queue search takes from the top-left
  // cell to the bottom-right cell, in order from start to exit, or an empty
  // list if the exit cannot be reached. Assumes maze is not null,
  // rectangular, and has at least one cell.
  public static List<Position> pathToExit(char[][] maze) {
    if (!isOpen(maze, 0, 0)) {
      return new ArrayList<>();  // empty: no route
    }

    int rows = maze.length;
    int cols = maze[0].length;
    Position[][] cameFrom = new Position[rows][cols];
    boolean[][] visited = new boolean[rows][cols];

    Queue<Position> toExplore = new LinkedQueue<>();
    toExplore.enqueue(new Position(0, 0));
    visited[0][0] = true;

    int[] rowChange = {0, 1, 0, -1};
    int[] colChange = {1, 0, -1, 0};

    while (!toExplore.isEmpty()) {
      Position current = toExplore.front();
      toExplore.dequeue();

      if (isExit(maze, current.row, current.col)) {
        return reconstruct(cameFrom, current);
      }

      for (int i = 0; i < rowChange.length; i++) {
        int nextRow = current.row + rowChange[i];
        int nextCol = current.col + colChange[i];
        if (isOpen(maze, nextRow, nextCol) && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          cameFrom[nextRow][nextCol] = current;  // remember the way back
          toExplore.enqueue(new Position(nextRow, nextCol));
        }
      }
    }

    return new ArrayList<>();  // empty: the exit is unreachable
  }

  // Follows the cameFrom links back from the exit and returns the cells in
  // order from start to exit.
  private static List<Position> reconstruct(Position[][] cameFrom, Position exit) {
    Stack<Position> stack = new ArrayStack<>();
    for (Position at = exit; at != null; at = cameFrom[at.row][at.col]) {
      stack.push(at);
    }

    List<Position> path = new ArrayList<>();
    while (!stack.isEmpty()) {
      path.add(stack.top());
      stack.pop();
    }
    return path;
  }
}
