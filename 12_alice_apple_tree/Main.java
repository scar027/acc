import java.util.*;

class Main {

  // Function to calculate the minimum number of apples that can be collected
  static int minApples(int M, int K, int N, int S, int W, int E) {
    // Case when the number of apples to collect is less than or equal to the apples
    // from the south trees
    if (M <= S * K) {
      return M;
    }
    // Case when the apples can be collected from both south and other trees
    else if (M <= S * K + E + W) {
      return S * K + (M - S * K);
    }
    // If it's not possible to collect the required apples
    else {
      return -1;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Taking inputs from the user
    System.out.print("Enter number of apples to be collected: ");
    int M = sc.nextInt(); // Number of apples to collect

    System.out.print("Enter number of apples in each tree: ");
    int K = sc.nextInt(); // Apples per tree

    System.out.print("Enter number of trees in north: ");
    int N = sc.nextInt(); // Number of trees in the north

    System.out.print("Enter number of trees in south: ");
    int S = sc.nextInt(); // Number of trees in the south

    System.out.print("Enter number of trees in west: ");
    int W = sc.nextInt(); // Number of trees in the west

    System.out.print("Enter number of trees in east: ");
    int E = sc.nextInt(); // Number of trees in the east

    // Call the function to compute the minimum apples that can be collected
    int ans = minApples(M, K, N, S, W, E);

    // Output the result
    System.out.println("Minimum apples that can be collected: " + ans);
    sc.close();
  }
}
