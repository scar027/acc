import java.util.Scanner;

public class Main {
  public static boolean Palindrome(int n){
    String s = Integer.toBinaryString(n);

    int i = 0; int j = s.length() - 1;
    while(i < j){
      if (s.charAt(i) != s.charAt(j))return false;
      i++; j--;
    }
    return true;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int x = sc.nextInt();
    System.out.println(Palindrome(x));
    sc.close();
  }
}