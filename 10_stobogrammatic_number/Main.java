import java.util.*;

public class Main {
  public static boolean isStrobogrammatic(String num) {
    // Map to store strobogrammatic pairs
    Map<Character, Character> strobogrammaticDictionary = new HashMap<>();
    strobogrammaticDictionary.put('0', '0');
    strobogrammaticDictionary.put('1', '1');
    strobogrammaticDictionary.put('6', '9');
    strobogrammaticDictionary.put('8', '8');
    strobogrammaticDictionary.put('9', '6');

    int n = num.length();
    for (int i = 0, j = n - 1; i <= j; i++, j--) {
      char digitLeft = num.charAt(i);
      char digitRight = num.charAt(j);

      // Check if the current digit can be strobogrammatic
      char mapping = strobogrammaticDictionary.getOrDefault(digitLeft, '-');
      if (mapping != digitRight) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    String num = sc.nextLine();

    if (isStrobogrammatic(num)) {
      System.out.println(num + " is a strobogrammatic number");
    } else {
      System.out.println(num + " is not a strobogrammatic number");
    }

    sc.close();
  }
}