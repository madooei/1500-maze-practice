package practice;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the maze path problem. In every maze, 'S' marks the start and 'E'
 * marks the exit, both as ordinary open cells; '.' marks the other open cells
 * and '#' marks walls.
 */
public class MazePathTest {

  @Test
  public void pathIsJustTheStartWhenStartIsAlsoTheExit() {
    char[][] maze = {
      {'S'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertRoute(new int[][] {{0, 0}}, path);
  }

  @Test
  public void pathIsEmptyWhenStartIsWall() {
    char[][] maze = {
      {'#', '.', '.'},
      {'.', '.', '.'},
      {'.', '.', 'E'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertTrue(path.isEmpty());
  }

  @Test
  public void pathIsEmptyWhenExitIsWalledOff() {
    char[][] maze = {
      {'S', '.', '#'},
      {'#', '.', '#'},
      {'.', '#', 'E'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertTrue(path.isEmpty());
  }

  @Test
  public void pathFollowsTheOnlyRoute() {
    char[][] maze = {
      {'S', '.', '.'},
      {'#', '#', '.'},
      {'.', '.', 'E'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertRoute(new int[][] {{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 2}}, path);
  }

  @Test
  public void pathHasFewestMovesWhenThereAreSeveralRoutes() {
    char[][] maze = {
      {'S', '.', '.'},
      {'.', '.', '.'},
      {'.', '.', 'E'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertEquals(5, path.size());
  }

  @Test
  public void pathMovesOneCellAtATimeWhenThereAreSeveralRoutes() {
    char[][] maze = {
      {'S', '.', '.'},
      {'.', '.', '.'},
      {'.', '.', 'E'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertTrue(movesOneCellAtATime(path));
  }

  @Test
  public void pathChoosesShorterOfUnequalRoutes() {
    char[][] maze = {
      {'S', '.', '.', '.', '.'},
      {'.', '#', '#', '#', '.'},
      {'.', '#', '.', '.', '.'},
      {'.', '#', '.', '#', '#'},
      {'.', '.', '.', '.', 'E'},
    };
    List<MazePath.Position> path = MazePath.pathToExit(maze);
    assertRoute(new int[][] {
      {0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0},
      {4, 1}, {4, 2}, {4, 3}, {4, 4}
    }, path);
  }

  // Asserts that path visits exactly the given (row, col) cells, in order.
  private static void assertRoute(int[][] cells, List<MazePath.Position> path) {
    assertEquals(cells.length, path.size());
    for (int i = 0; i < cells.length; i++) {
      assertEquals(cells[i][0], path.get(i).row);
      assertEquals(cells[i][1], path.get(i).col);
    }
  }

  // Is every cell of path one step up, right, down, or left from the one
  // before it?
  private static boolean movesOneCellAtATime(List<MazePath.Position> path) {
    for (int i = 1; i < path.size(); i++) {
      int rowStep = Math.abs(path.get(i).row - path.get(i - 1).row);
      int colStep = Math.abs(path.get(i).col - path.get(i - 1).col);
      if (rowStep + colStep != 1) {
        return false;
      }
    }
    return true;
  }
}
