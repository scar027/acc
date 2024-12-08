import java.util.*;

public class Main {
  public static String findSmallestPalindrome(String input) {
    // Count the frequency of each character
    int[] frequency = new int[26];
    for (char c : input.toCharArray()) {
        frequency[c - 'a']++;
    }

    // Check if it's possible to form a palindrome
    int oddCount = 0;
    char oddChar = '\0';
    for (int i = 0; i < 26; i++) {
        if (frequency[i] % 2 != 0) {
            oddCount++;
            oddChar = (char) (i + 'a');
        }
    }

    // A palindrome can have at most one odd-count character
    if (oddCount > 1) {
        return null;
    }

    // Build the first half of the palindrome
    StringBuilder firstHalf = new StringBuilder();
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < frequency[i] / 2; j++) {
            firstHalf.append((char) (i + 'a'));
        }
    }

    // Construct the full palindrome
    String secondHalf = new StringBuilder(firstHalf).reverse().toString();
    if (oddCount == 1) {
        return firstHalf.toString() + oddChar + secondHalf;
    } else {
        return firstHalf.toString() + secondHalf;
    }
  }

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String input = scanner.nextLine();
    
    String palindrome = findSmallestPalindrome(input);
    if (palindrome == null) {
        System.out.println("No palindrome can be formed.");
    } else {
        System.out.println("The lexicographically smallest palindrome is: " + palindrome);
    }
    scanner.close();
  }
  
}