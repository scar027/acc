public class Main {

  private static final int[] ROW_MOVES = { 2, 1, -1, -2, -2, -1, 1, 2 };
  private static final int[] COL_MOVES = { 1, 2, 2, 1, -1, -2, -2, -1 };

  // Check if the move is within bounds and the cell is unvisited
  public static boolean isSafe(int[][] board, int row, int col, int N) {
    return (row >= 0 && row < N && col >= 0 && col < N && board[row][col] == -1);
  }

  // Print the solution board
  public static void printSolution(int[][] board) {
    for (int[] row : board) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  // Solve the Knight's Tour problem
  public static boolean solveKnightTour(int N) {
    int[][] board = new int[N][N];

    // Initialize the board with -1 (unvisited)
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = -1;
      }
    }

    // Start the knight's tour from the top-left corner (0, 0)
    board[0][0] = 0;

    // Recursive function to find a solution
    if (solveUtil(board, 0, 0, 1, N)) {
      printSolution(board);
      return true;
    } else {
      System.out.println("No solution exists.");
      return false;
    }
  }

  // Recursive utility function to solve the Knight's Tour problem
  public static boolean solveUtil(int[][] board, int row, int col, int moveCount, int N) {
    // Base case: all cells are visited
    if (moveCount == N * N) {
      return true;
    }

    // Try all possible moves
    for (int i = 0; i < 8; i++) {
      int nextRow = row + ROW_MOVES[i];
      int nextCol = col + COL_MOVES[i];

      if (isSafe(board, nextRow, nextCol, N)) {
        board[nextRow][nextCol] = moveCount;

        // Recur to place the next move
        if (solveUtil(board, nextRow, nextCol, moveCount + 1, N)) {
          return true;
        }

        // Backtrack if the move does not lead to a solution
        board[nextRow][nextCol] = -1;
      }
    }

    return false; // No solution exists for this configuration
  }

  public static void main(String[] args) {
    int N = 8; // Board size
    solveKnightTour(N);
  }
}
