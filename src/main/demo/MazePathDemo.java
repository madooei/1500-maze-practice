package demo;

import java.util.List;
import practice.MazePath;
import practice.MazePath.Position;

/** A demo of MazePath on the notes' first example. */
public final class MazePathDemo {

  private MazePathDemo() {
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

    // Expect (0, 0) -> (0, 1) -> (0, 2) -> (1, 2) -> (2, 2).
    List<Position> path = MazePath.pathToExit(maze);
    String route = "";
    for (int i = 0; i < path.size(); i++) {
      if (i > 0) {
        route += " -> ";
      }
      route += "(" + path.get(i).row + ", " + path.get(i).col + ")";
    }
    System.out.println("Path: " + route);
  }
}
