public class Main {
  // Function to calculate Euler's Totient Function
  static int phi(int n) {
    int result = n; // Initialize result as n

    // Consider all prime factors of n
    for (int p = 2; p * p <= n; p++) {
      // Check if p is a factor of n
      if (n % p == 0) {
        // If yes, then update result and remove p from n
        while (n % p == 0) {
          n /= p;
        }
        result -= result / p;
      }
    }

    // If n has a prime factor greater than √n
    if (n > 1) {
      result -= result / n;
    }

    return result;
  }

  public static void main(String[] args) {
    int n = 5; // Change this value for a different input
    System.out.println("Euler's Totient Function value for " + n + " is: " + phi(n));
  }
}