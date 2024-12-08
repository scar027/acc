import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int x = sc.nextInt();

    System.out.println("Before swapping the nibble: " + x);
    System.out.println("After swapping the nibble: " + ((x & 0x0F) << 4 | (x & 0xF0) >> 4));
    
    sc.close();
  }
}