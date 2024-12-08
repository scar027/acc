class Main {

  // Method to solve the Josephus problem
  static int josephus(int n, int k) {
    // Base case: only one person remains
    if (n == 1) {
      return 1;
    } else {
      /*
       * The position returned by josephus(n - 1, k) is adjusted because
       * the recursive call considers the original position (k % n) + 1
       * as position 1.
       */
      return (josephus(n - 1, k) + k - 1) % n + 1;
    }
  }

  public static void main(String[] args) {
    int n = 14; // Number of people in the circle
    int k = 2; // Step count for elimination

    // Print the safe position
    System.out.println("The safe position is: " + josephus(n, k));
  }
}
