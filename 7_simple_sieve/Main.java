import java.util.Scanner;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = sc.nextInt();

    // Create a boolean array and initialize all to true
    boolean[] isPrime = new boolean[num + 1];
    for (int i = 2; i <= num; i++) {
      isPrime[i] = true;
    }

    // Mark non-prime numbers
    for (int i = 2; i * i <= num; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= num; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // Print all prime numbers
    System.out.println("Prime numbers up to " + num + ":");
    for (int i = 2; i <= num; i++) {
      if (isPrime[i]) {
        System.out.print(i + " ");
      }
    }
    sc.close();
  }
}