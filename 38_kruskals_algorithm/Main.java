import java.util.Arrays;

class Edge implements Comparable<Edge> {
  int src, dest, weight;

  // Comparator function to sort edges by weight
  public int compareTo(Edge compareEdge) {
    return this.weight - compareEdge.weight;
  }
}

class Subset {
  int parent, rank;
}

public class Main {

  int V, E; // Number of vertices and edges
  Edge[] edges; // Edge list

  // Constructor
  public Main(int v, int e) {
    V = v;
    E = e;
    edges = new Edge[E];
    for (int i = 0; i < e; i++) {
      edges[i] = new Edge();
    }
  }

  // Find the root of the subset containing element i
  int find(Subset[] subsets, int i) {
    if (subsets[i].parent != i) {
      subsets[i].parent = find(subsets, subsets[i].parent); // Path compression
    }
    return subsets[i].parent;
  }

  // Union of two subsets by rank
  void union(Subset[] subsets, int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);

    if (subsets[xroot].rank < subsets[yroot].rank) {
      subsets[xroot].parent = yroot;
    } else if (subsets[xroot].rank > subsets[yroot].rank) {
      subsets[yroot].parent = xroot;
    } else {
      subsets[yroot].parent = xroot;
      subsets[xroot].rank++;
    }
  }

  // Function to perform Kruskal's MST algorithm
  void kruskalMST() {
    Edge[] result = new Edge[V]; // Result array to store the MST
    int e = 0; // Index for result[]
    int i = 0; // Index for sorted edges

    for (i = 0; i < V; i++) {
      result[i] = new Edge();
    }

    // Step 1: Sort all edges by weight
    Arrays.sort(edges);

    // Step 2: Create subsets for each vertex
    Subset[] subsets = new Subset[V];
    for (i = 0; i < V; i++) {
      subsets[i] = new Subset();
      subsets[i].parent = i;
      subsets[i].rank = 0;
    }

    i = 0; // Index for sorted edges

    // Number of edges in MST is V-1
    while (e < V - 1) {
      // Step 3: Pick the smallest edge
      Edge nextEdge = edges[i++];

      int x = find(subsets, nextEdge.src);
      int y = find(subsets, nextEdge.dest);

      // If the edge does not form a cycle, include it in the result
      if (x != y) {
        result[e++] = nextEdge;
        union(subsets, x, y);
      }
    }

    // Print the MST
    int minimumCost = 0;
    System.out.println("Edges in the constructed MST:");
    for (i = 0; i < e; i++) {
      System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
      minimumCost += result[i].weight;
    }
    System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
  }

  // Main method
  public static void main(String[] args) {
    int V = 4; // Number of vertices
    int E = 5; // Number of edges
    Main graph = new Main(V, E);

    // Define edges
    graph.edges[0].src = 0;
    graph.edges[0].dest = 1;
    graph.edges[0].weight = 10;

    graph.edges[1].src = 0;
    graph.edges[1].dest = 2;
    graph.edges[1].weight = 6;

    graph.edges[2].src = 0;
    graph.edges[2].dest = 3;
    graph.edges[2].weight = 5;

    graph.edges[3].src = 1;
    graph.edges[3].dest = 3;
    graph.edges[3].weight = 15;

    graph.edges[4].src = 2;
    graph.edges[4].dest = 3;
    graph.edges[4].weight = 4;

    // Run Kruskal's algorithm
    graph.kruskalMST();
  }
}