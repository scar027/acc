public class Main {

  public static void rotateToLeft(int[] arr, int n, int k) {
    if (n == 0) {
      return;
    }

    k = k % n; // Normalize k to avoid unnecessary rotations
    if (k > n) {
      return;
    }

    int[] temp = new int[k];

    // Copy first k elements to temp
    for (int i = 0; i < k; i++) {
      temp[i] = arr[i];
    }

    // Shift the remaining elements to the left
    for (int i = 0; i < n - k; i++) {
      arr[i] = arr[i + k];
    }

    // Place temp elements at the end
    for (int i = n - k; i < n; i++) {
      arr[i] = temp[i - n + k];
    }
  }

  public static void main(String[] args) {
    int n = 7;
    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    int k = 2;

    rotateToLeft(arr, n, k);

    System.out.println("After rotating the elements to the left:");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}