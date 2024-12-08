public class Main {
  // Method to find the maximum equilibrium sum
  public static int getMaxEquilibriumSumOptimized(int[] arr) {
      int totalSum = 0;    // This will store the sum of all elements in the array
      int leftSum = 0;     // This will store the sum of elements to the left of the current index
      int maxSum = Integer.MIN_VALUE;   // This will store the maximum equilibrium sum found
      
      // First loop to calculate the total sum of the array
      for (int i = 0; i < arr.length; i++) {
          totalSum += arr[i];    // Add each element to totalSum
      }

      // Second loop to find the equilibrium index and the maximum equilibrium sum
      for (int i = 0; i < arr.length; i++) {
          totalSum -= arr[i];    // Subtract the current element to get the right sum (sum of elements to the right of index i)
          
          // Check if left sum equals right sum (totalSum now holds the right sum)
          if (leftSum == totalSum && leftSum > maxSum) {
              maxSum = leftSum;  // Update maxSum if a new equilibrium sum is found and it's greater than the previous maxSum
          }

          leftSum += arr[i];    // Add the current element to leftSum (for the next iteration)
      }
      // Return the maximum equilibrium sum found
      return maxSum;
  }

  // Main method to test the function
  public static void main(String[] args) {
      // Test array
      int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};

      // Calculate and print the maximum equilibrium sum
      int maxSum = getMaxEquilibriumSumOptimized(arr);
      System.out.println("Max Equilibrium Sum : " + maxSum);
  }
}