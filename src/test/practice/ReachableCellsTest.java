package practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the reachable cells problem. In every maze, 'S' marks the start
 * as an ordinary open cell, '.' marks the other open cells, and '#' marks
 * walls.
 */
public class ReachableCellsTest {

  @Test
  public void countsSingleOpenCell() {
    char[][] maze = {
      {'S'},
    };
    assertEquals(1, ReachableCells.reachableCount(maze));
  }

  @Test
  public void returnsZeroWhenStartIsWall() {
    char[][] maze = {
      {'#', '.', '.'},
      {'.', '.', '.'},
      {'.', '.', '.'},
    };
    assertEquals(0, ReachableCells.reachableCount(maze));
  }

  @Test
  public void countsAllReachableOpenCells() {
    char[][] maze = {
      {'S', '.', '#'},
      {'.', '.', '#'},
      {'#', '.', '.'},
    };
    assertEquals(6, ReachableCells.reachableCount(maze));
  }

  @Test
  public void stopsAtWallsThatSealOffRegions() {
    char[][] maze = {
      {'S', '#', '.'},
      {'.', '#', '.'},
      {'.', '#', '.'},
    };
    assertEquals(3, ReachableCells.reachableCount(maze));
  }

  @Test
  public void countsEveryCellWhenThereAreNoWalls() {
    char[][] maze = {
      {'S', '.', '.', '.'},
      {'.', '.', '.', '.'},
      {'.', '.', '.', '.'},
    };
    assertEquals(12, ReachableCells.reachableCount(maze));
  }
}
