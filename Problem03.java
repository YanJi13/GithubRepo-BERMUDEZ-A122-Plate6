import java.util.*;

public class Problem03 {

    // Checks if the graph has a cycle
    public static boolean hasCycle(int n, List<int[]> edges) {
        List<List<Integer>> graph = createGraph(n, edges);
        boolean[] visited = new boolean[n];

        // Explore each vertex and its neighbors
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // If a cycle is found, return true
                if (dfs(i, -1, graph, visited)) {
                    return true;
                }
            }
        }
        return false; // No cycle found
    }

    // Creates an adjacency list representation of the graph
    private static List<List<Integer>> createGraph(int n, List<int[]> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected)
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    // Depth-First Search (DFS) to detect cycles
    private static boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        // Iterate over the neighbors of the current node
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                // Recursively explore unvisited neighbors
                if (dfs(neighbor, node, graph, visited)) {
                    return true; // Cycle detected in the subtree
                }
            } else if (neighbor != parent) {
                return true; // Found a back edge indicating a cycle
            }
        }
        return false; // No cycle detected
    }

    public static void main(String[] args) {
        // Test cases
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        System.out.println("Test Case 1: " + (hasCycle(3, edges1) ? "Graph has a cycle" : "Graph does not have a cycle")); // true

        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2});
        System.out.println("Test Case 2: " + (hasCycle(3, edges2) ? "Graph has a cycle" : "Graph does not have a cycle")); // false

        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 1});
        System.out.println("Test Case 3: " + (hasCycle(4, edges3) ? "Graph has a cycle" : "Graph does not have a cycle")); // true

        List<int[]> edges4 = Arrays.asList();
        System.out.println("Test Case 4: " + (hasCycle(3, edges4) ? "Graph has a cycle" : "Graph does not have a cycle")); // false

        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 2});
        System.out.println("Test Case 5: " + (hasCycle(5, edges5) ? "Graph has a cycle" : "Graph does not have a cycle")); // true
    }
}
