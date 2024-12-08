import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the board size (N): ");
    int n = sc.nextInt();

    char[][] board = new char[n][n];

    // Initialize the board with '-'
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '-';
      }
    }

    // Solve the N-Queens problem
    if (solveNQueens(board, 0, n)) {
      System.out.println("Solution found:");
      printSolution(board, n);
    } else {
      System.out.println("No solution exists.");
    }

    sc.close();
  }

  // Method to print the solution
  public static void printSolution(char[][] board, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(" " + board[i][j] + " ");
      }
      System.out.println();
    }
  }

  // Method to check if placing a queen at board[row][col] is safe
  public static boolean isSafe(char[][] board, int row, int col, int n) {
    int i, j;

    // Check this row on the left side
    for (i = 0; i < col; i++) {
      if (board[row][i] == 'Q') {
        return false;
      }
    }

    // Check upper diagonal on the left side
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // Check lower diagonal on the left side
    for (i = row, j = col; i < n && j >= 0; i++, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  // Method to solve the N-Queens problem using backtracking
  public static boolean solveNQueens(char[][] board, int col, int n) {
    // Base case: All queens are placed
    if (col >= n) {
      return true;
    }

    // Consider each row in the current column
    for (int i = 0; i < n; i++) {
      // Check if it is safe to place a queen here
      if (isSafe(board, i, col, n)) {
        board[i][col] = 'Q'; // Place queen

        // Recur to place the rest of the queens
        if (solveNQueens(board, col + 1, n)) {
          return true;
        }

        // Backtrack if placing queen here doesn't lead to a solution
        board[i][col] = '-';
      }
    }

    // If no placement is possible, return false
    return false;
  }
}
