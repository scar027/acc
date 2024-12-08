import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter a number");
    int num = sc.nextInt();

    boolean[] bool = new boolean[num];

    // Initially mark all numbers as prime (true)
    Arrays.fill(bool, true);

    // 0 and 1 are not prime numbers
    bool[0] = bool[1] = false;

    // Implementing Sieve of Eratosthenes
    for (int i = 2; i < Math.sqrt(num); i++) {
      if (bool[i]) {
        // Mark all multiples of i as non-prime
        for (int j = i * i; j < num; j += i) {
          bool[j] = false;
        }
      }
    }

    System.out.println("List of prime numbers up to the given number are:");

    // Print all prime numbers
    for (int i = 2; i < bool.length; i++) {
      if (bool[i]) {
        System.out.println(i);
      }
    }
    sc.close();
  }
}
