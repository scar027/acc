public class Main {

  static int row = 5;
  static int col = 5;

  static int findMaxSum(int[][] mat) {
    if (row < 3 || col < 3) {
      System.out.println("Not possible to give");
      System.exit(0);
    }

    int max_sum = Integer.MIN_VALUE;

    // Loop through each possible top-left corner of hourglass
    for (int i = 0; i < row - 2; i++) {
      for (int j = 0; j < col - 2; j++) {
        // Calculate the sum of the hourglass centered at (i, j)
        int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) +
            mat[i + 1][j + 1] +
            (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]);

        // Update max_sum if current sum is greater
        max_sum = Math.max(max_sum, sum);
      }
    }

    return max_sum;
  }

  public static void main(String[] args) {
    // 5x5 matrix for testing
    int[][] mat = {
        { 1, 2, 3, 0, 0 },
        { 0, 0, 0, 0, 0 },
        { 2, 1, 4, 0, 0 },
        { 0, 0, 0, 0, 0 },
        { 1, 1, 0, 1, 0 }
    };

    // Find and print the maximum hourglass sum
    int res = findMaxSum(mat);
    System.out.println("Maximum sum of hourglass = " + res);
  }
}
