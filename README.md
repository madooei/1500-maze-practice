# Maze Solving — Practice

Three practice problems, one class each. `ReachableCells` counts the open cells reachable from the top-left cell. `MazeDistance` returns the number of moves the queue search takes from the top-left cell to the bottom-right cell. `MazePath` returns the route that search takes.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      stack/
        Stack.java                      # the Stack ADT contract (copied from the Stack chapter)
        ArrayStack.java                 # array-backed Stack (copied from the Stack chapter)
      queue/
        Queue.java                      # the Queue ADT contract (copied from the Queue chapter)
        LinkedQueue.java                # linked Queue (copied from the Queue chapter)
      practice/
        ReachableCells.java             # count the cells reachable from the start
        MazeDistance.java               # moves to the exit
        MazePath.java                   # the route to the exit
    test/
      practice/
        ReachableCellsTest.java         # tests for ReachableCells
        MazeDistanceTest.java           # tests for MazeDistance
        MazePathTest.java               # tests for MazePath
  scripts/
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh practice.ReachableCellsTest` — compiles everything and runs only that test class. Use this while you are working on one problem and the others are still empty.

There is no demo program for these problems; the tests are how you check your work.

## What's here

- `stack.Stack<T>`, `stack.ArrayStack<T>`, `queue.Queue<T>`, and `queue.LinkedQueue<T>` — unchanged copies from the Stack and Queue chapters. The practice solutions use them, so they are included here to keep this code self-contained.
- `practice.ReachableCells` — `reachableCount`, a search with an explicit stack and a visited array.
- `practice.ReachableCellsTest` — tests for `ReachableCells`.
- `practice.MazeDistance` — `distanceToExit`, a queue search with a distance array.
- `practice.MazeDistanceTest` — tests for `MazeDistance`.
- `practice.MazePath` — `pathToExit`, a queue search that records where each cell was first reached and rebuilds the route with a stack. Its `Position` class is public because `pathToExit` returns a list of them.
- `practice.MazePathTest` — tests for `MazePath`.
