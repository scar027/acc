import java.util.Scanner;
import java.util.Arrays;

public class Main {

  private int V, pathCount;
  private int[] path;
  private int[][] graph;

  // Method to find the Hamiltonian Cycle
  public void findHamiltonianCycle(int[][] g) {
    V = g.length;
    path = new int[V];
    Arrays.fill(path, -1);
    graph = g;

    try {
      path[0] = 0; // Start at the first vertex
      pathCount = 1;
      solve(0); // Attempt to solve
      System.out.println("No solution");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      display();
    }
  }

  // Recursive method to solve the problem
  public void solve(int vertex) throws Exception {
    // Base case: If all vertices are included and there's an edge back to the start
    if (graph[vertex][0] == 1 && pathCount == V) {
      throw new Exception("Solution found");
    }

    if (pathCount == V) {
      return;
    }

    // Explore all vertices adjacent to the current vertex
    for (int v = 0; v < V; v++) {
      if (graph[vertex][v] == 1) { // Check adjacency
        path[pathCount++] = v;
        graph[vertex][v] = 0; // Mark the edge as visited
        graph[v][vertex] = 0;

        if (!isPresent(v)) {
          solve(v);
        }

        // Backtrack
        graph[vertex][v] = 1;
        graph[v][vertex] = 1;
        path[--pathCount] = -1;
      }
    }
  }

  // Check if a vertex is already in the path
  public boolean isPresent(int v) {
    for (int i = 0; i < pathCount - 1; i++) {
      if (path[i] == v) {
        return true;
      }
    }
    return false;
  }

  // Display the Hamiltonian cycle
  public void display() {
    System.out.print("\nPath: ");
    for (int i = 0; i <= V; i++) {
      System.out.print(path[i % V] + " ");
    }
    System.out.println();
  }

  // Main method
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Main hc = new Main(); // Create an instance of the class

    System.out.print("Enter the number of vertices: ");
    int V = scan.nextInt();
    int[][] graph = new int[V][V];

    System.out.println("Enter the adjacency matrix:");
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        graph[i][j] = scan.nextInt();
      }
    }

    hc.findHamiltonianCycle(graph);
    scan.close();
  }
}