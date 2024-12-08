import java.util.ArrayList;
import java.util.Arrays;

public class Main{
  public static void main(String[] args) {
    int limit = 25; // Change this value to find primes up to another number

    // Step 1: Find all primes up to sqrt(limit)
    int sqrtLimit = (int) Math.sqrt(limit);
    boolean[] isPrime = new boolean[sqrtLimit + 1];
    Arrays.fill(isPrime, true);
    ArrayList<Integer> primes = new ArrayList<>();

    for (int i = 2; i <= sqrtLimit; i++) {
      if (isPrime[i]) {
        primes.add(i);
        for (int j = i * i; j <= sqrtLimit; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // Step 2: Use these primes to mark multiples in the range 1 to limit
    boolean[] isPrimeRange = new boolean[limit + 1];
    Arrays.fill(isPrimeRange, true);

    for (int p : primes) {
      for (int j = p * p; j <= limit; j += p) {
        isPrimeRange[j] = false;
      }
    }

    // Step 3: Print all primes in the range 1 to limit
    System.out.println("Prime numbers from 1 to " + limit + ":");
    for (int i = 2; i <= limit; i++) {
      if (isPrimeRange[i]) {
        System.out.print(i + " ");
      }
    }
  }
}