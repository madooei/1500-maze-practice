package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the maze distance problem. In every maze, 'S' marks the start and
 * 'E' marks the exit, both as ordinary open cells; '.' marks the other open
 * cells and '#' marks walls.
 */
public class MazeDistanceTest {

  @Test
  public void distanceIsZeroWhenStartIsAlsoTheExit() {
    char[][] maze = {
      {'S'},
    };
    assertEquals(0, MazeDistance.distanceToExit(maze));
  }

  @Test
  public void distanceIsMinusOneWhenStartIsWall() {
    char[][] maze = {
      {'#', '.', '.'},
      {'.', '.', '.'},
      {'.', '.', 'E'},
    };
    assertEquals(-1, MazeDistance.distanceToExit(maze));
  }

  @Test
  public void distanceIsMinusOneWhenExitIsWalledOff() {
    char[][] maze = {
      {'S', '.', '#'},
      {'#', '.', '#'},
      {'.', '#', 'E'},
    };
    assertEquals(-1, MazeDistance.distanceToExit(maze));
  }

  @Test
  public void distanceFollowsTheOnlyRoute() {
    char[][] maze = {
      {'S', '.', '.'},
      {'#', '#', '.'},
      {'.', '.', 'E'},
    };
    assertEquals(4, MazeDistance.distanceToExit(maze));
  }

  @Test
  public void distanceIsTheFewestMovesAroundCenterWall() {
    char[][] maze = {
      {'S', '.', '.'},
      {'.', '#', '.'},
      {'.', '.', 'E'},
    };
    assertEquals(4, MazeDistance.distanceToExit(maze));
  }

  @Test
  public void distanceChoosesShorterOfUnequalRoutes() {
    char[][] maze = {
      {'S', '.', '.', '.', '.'},
      {'.', '#', '#', '#', '.'},
      {'.', '#', '.', '.', '.'},
      {'.', '#', '.', '#', '#'},
      {'.', '.', '.', '.', 'E'},
    };
    // The route starting right takes 12 moves; the route starting down takes 8.
    assertEquals(8, MazeDistance.distanceToExit(maze));
  }
}
