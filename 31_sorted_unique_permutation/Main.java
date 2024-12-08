import java.util.*;

public class Main {

    // Method to calculate the factorial of a number
    static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    // Method to print the array as a string
    static void print(char[] temp) {
        for (char c : temp) {
            System.out.print(c);
        }
        System.out.println();
    }

    // Method to find the total number of permutations
    static int calculateTotal(char[] temp, int n) {
        int f = factorial(n);

        // Building HashMap to store frequencies of all characters
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : temp) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // Traversing HashMap and handling duplicate elements
        for (int count : hm.values()) {
            if (count > 1) {
                f /= factorial(count);
            }
        }

        return f;
    }

    // Method to generate the next permutation of the array
    static void nextPermutation(char[] temp) {
        // Find the first position i-1 where temp[i-1] < temp[i]
        int i;
        for (i = temp.length - 1; i > 0; i--) {
            if (temp[i] > temp[i - 1]) {
                break;
            }
        }

        if (i > 0) {
            // Find the smallest character after i-1 which is greater than temp[i-1]
            int min = i;
            char x = temp[i - 1];
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[j] > x && temp[j] < temp[min]) {
                    min = j;
                }
            }

            // Swap the characters at i-1 and min
            char tempToSwap = temp[i - 1];
            temp[i - 1] = temp[min];
            temp[min] = tempToSwap;
        }

        // Sort all characters after position i-1
        Arrays.sort(temp, i, temp.length);

        // Print the resulting permutation
        print(temp);
    }

    // Method to print all unique permutations of a string
    static void printAllPermutations(String s) {
        // Convert string to character array and sort it
        char[] temp = s.toCharArray();
        Arrays.sort(temp);

        // Print the first permutation
        print(temp);

        // Find and print all other permutations
        int total = calculateTotal(temp, temp.length);
        for (int i = 1; i < total; i++) {
            nextPermutation(temp);
        }
    }

    // Main method
    public static void main(String[] args) {
        // Input your string
        String s = "AAB";
        printAllPermutations(s);
    }
}

