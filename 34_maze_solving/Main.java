public class Main {

  static int N;

  // Method to print the solution matrix
  void printSolution(int sol[][]) {
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              System.out.print(" " + sol[i][j] + " ");
          }
          System.out.println();
      }
  }

  // Method to check if x, y is a valid position in the maze
  boolean isSafe(int maze[][], int x, int y) {
      return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
  }

  // Method to solve the maze problem
  boolean solveMaze(int maze[][]) {
      int sol[][] = new int[N][N]; // Solution matrix

      if (!solveMazeUtil(maze, 0, 0, sol)) {
          System.out.println("Solution doesn't exist");
          return false;
      }

      printSolution(sol);
      return true;
  }

  // Utility method to solve the maze using backtracking
  boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
      // If (x, y) is the destination, return true
      if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
          sol[x][y] = 1;
          return true;
      }

      // Check if maze[x][y] is valid
      if (isSafe(maze, x, y)) {
          // Mark x, y as part of the solution path
          sol[x][y] = 1;

          // Move forward in the x direction
          if (solveMazeUtil(maze, x + 1, y, sol)) {
              return true;
          }

          // Move down in the y direction
          if (solveMazeUtil(maze, x, y + 1, sol)) {
              return true;
          }

          // Move backward in the x direction
          if (solveMazeUtil(maze, x - 1, y, sol)) {
              return true;
          }

          // Move upward in the y direction
          if (solveMazeUtil(maze, x, y - 1, sol)) {
              return true;
          }

          // If none of the above movements work, BACKTRACK
          sol[x][y] = 0;
          return false;
      }

      return false;
  }

  // Main method
  public static void main(String args[]) {
      Main m = new Main();
      int maze[][] = {
          { 1, 0, 0, 0 },
          { 1, 1, 0, 1 },
          { 0, 1, 0, 0 },
          { 1, 1, 1, 1 }
      };

      N = maze.length; // Setting N based on the maze size
      m.solveMaze(maze);
  }
}