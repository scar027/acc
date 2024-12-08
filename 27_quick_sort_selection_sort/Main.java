import java.util.*;

public class Main {
  // QuickSort function
  static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      // Partition the array
      int pivotIndex = partition(arr, low, high);

      // Recursively sort the two halves
      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }

  // Partition function for QuickSort
  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high]; // Taking the last element as pivot
    int i = low - 1;       // Index of smaller element

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        // Swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // Swap arr[i + 1] and arr[high] (the pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  // Selection Sort function
  static void selectionSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      // Find the minimum element in unsorted array
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      // Swap the found minimum element with the first element
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }

  // Main method
  public static void main(String[] args) {
    int[] array1 = {64, 34, 25, 12, 22, 11, 90};
    int[] array2 = {64, 34, 25, 12, 22, 11, 90};

    // QuickSort
    System.out.println("Original Array for QuickSort: " + Arrays.toString(array1));
    quickSort(array1, 0, array1.length - 1);
    System.out.println("Sorted Array using QuickSort: " + Arrays.toString(array1));

    // Selection Sort
    System.out.println("\nOriginal Array for Selection Sort: " + Arrays.toString(array2));
    selectionSort(array2);
    System.out.println("Sorted Array using Selection Sort: " + Arrays.toString(array2));
  }
}
