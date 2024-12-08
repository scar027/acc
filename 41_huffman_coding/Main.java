import java.util.PriorityQueue;
import java.util.Comparator;

// Class representing a node of the Huffman Tree
class HuffmanNode {
  int data; // Frequency of the character
  char c; // Character itself
  HuffmanNode left, right; // Left and right child nodes

  // Constructor to create a new HuffmanNode
  public HuffmanNode(char c, int data) {
    this.c = c;
    this.data = data;
    this.left = this.right = null;
  }
}

// Comparator class to order Huffman nodes by their frequency
class MyComparator implements Comparator<HuffmanNode> {
  @Override
  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.data - y.data; // Sort in ascending order of frequency
  }
}

public class Main {

  // Recursive method to print Huffman Codes for characters
  public static void printCode(HuffmanNode root, String s) {
    if (root == null) {
      return;
    }

    // If it's a leaf node (character node), print the character and its code
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {
      System.out.println(root.c + ": " + s);
      return;
    }

    // Traverse left and append '0' to the code
    printCode(root.left, s + "0");

    // Traverse right and append '1' to the code
    printCode(root.right, s + "1");
  }

  // Main method to build Huffman Tree and print the Huffman Codes
  public static void main(String[] args) {
    // Input character array and their corresponding frequencies
    char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
    int[] charFreq = { 5, 9, 12, 13, 16, 45 };
    int n = charArray.length; // Number of distinct characters

    // Priority queue to hold the nodes, ordered by frequency
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, new MyComparator());

    // Step 1: Create leaf nodes for each character and add them to the priority
    // queue
    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode(charArray[i], charFreq[i]);
      queue.add(hn);
    }

    // Step 2: Build the Huffman Tree
    HuffmanNode root = null;

    // While there is more than one node in the queue
    while (queue.size() > 1) {
      // Extract two nodes with the smallest frequencies
      HuffmanNode x = queue.poll();
      HuffmanNode y = queue.poll();

      // Create a new internal node with the sum of the frequencies
      HuffmanNode f = new HuffmanNode('-', x.data + y.data);
      f.left = x;
      f.right = y;

      // Set the current node as the root
      root = f;

      // Add this new internal node back into the queue
      queue.add(f);
    }

    // Step 3: Print the Huffman Codes for each character
    System.out.println("Huffman Codes for the given characters:");
    printCode(root, "");
  }
}