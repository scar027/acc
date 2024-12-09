import java.util.Scanner;

public class Main {
  public static int LongestSequenceOfOnes(int[] a, int k){
    int maxOnes = Integer.MIN_VALUE;
    int numReplacements = 0;
    int windowStart = 0;

    for(int windowEnd = 0; windowEnd < a.length; windowEnd++){
      if(a[windowEnd] == 0)numReplacements++;

      while(numReplacements > k){
        if(a[windowStart] == 0)numReplacements--;
        windowStart++;
      }
      maxOnes = Math.max(maxOnes, windowEnd - windowStart + 1);
    }
    return maxOnes;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter space-separated integers(elements of the array): ");
    String input = sc.nextLine();
    String[] inputArray = input.split(" ");

    int[] a = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++){
      a[i] = Integer.parseInt(inputArray[i]);
    }

    System.out.print("Enter the value of k: ");
    int k = sc.nextInt();

    System.out.println("The longest sequence of 1's is: " + LongestSequenceOfOnes(a, k));
    sc.close();
  }
}