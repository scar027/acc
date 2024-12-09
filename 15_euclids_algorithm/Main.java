import java.util.Scanner;

public class Main {
  public static int gcd(int a, int b)
  {
    if (a == 0)
    {
      return b;
    }
    return gcd(b % a, a);
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    int x = sc.nextInt();
    System.out.print("Enter the second number: ");
    int y = sc.nextInt();
    System.out.println("The GCD is: " + gcd(x, y));
    sc.close();
  }
}