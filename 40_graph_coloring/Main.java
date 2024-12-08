import java.util.*;

class Graph {

    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list for graph

    // Constructor
    @SuppressWarnings("unchecked")
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph (since the graph is undirected, add edges both ways)
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Greedy Coloring method
    public void greedyColoring() {
        int[] result = new int[V]; // Array to store the color assigned to each vertex
        Arrays.fill(result, -1); // Initialize all vertices as uncolored (-1)
        result[0] = 0; // Color the first vertex with color 0

        // Boolean array to keep track of available colors
        boolean[] available = new boolean[V];
        Arrays.fill(available, true); // Initially, all colors are available

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {
            // Mark the colors of adjacent vertices as unavailable
            for (int i : adj[u]) {
                if (result[i] != -1) {
                    available[result[i]] = false;
                }
            }

            // Find the first available color
            int color;
            for (color = 0; color < V; color++) {
                if (available[color]) {
                    break;
                }
            }

            result[u] = color; // Assign the found color to vertex u

            // Reset the available array for the next vertex
            Arrays.fill(available, true);
        }

        // Print the result of vertex-color mapping
        for (int u = 0; u < V; u++) {
            System.out.println("Vertex " + u + " ---> Color " + result[u]);
        }
    }

    // Main method to create and color graphs
    public static void main(String[] args) {
        
        // Create and color Graph 1
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of Graph 1:");
        g1.greedyColoring();
        
        System.out.println(); // Blank line for better readability
        
        // Create and color Graph 2
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of Graph 2:");
        g2.greedyColoring();
    }
}