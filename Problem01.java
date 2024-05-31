import java.util.*;

public class Problem01 {

    // Checks if the entire graph is connected
    public static boolean isConnected(int n, List<int[]> edges) {
        List<List<Integer>> graph = createGraph(n, edges);
        boolean[] visited = new boolean[n];
        dfs(0, graph, visited);
        for (boolean v : visited) {
            if (!v) return false;  // Return false if any node is unvisited
        }
        return true;
    }

    // Counts the number of connected components in the graph
    public static int countConnectedComponents(int n, List<int[]> edges) {
        List<List<Integer>> graph = createGraph(n, edges);
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                count++;  // Increment count for each new component
            }
        }
        return count;
    }

    // Creates the graph as an adjacency list
    private static List<List<Integer>> createGraph(int n, List<int[]> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    // Performs Depth-First Search (DFS)
    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                for (int neighbor : graph.get(current)) {
                    if (!visited[neighbor]) stack.push(neighbor);
                }
            }
        }
    }

    // Main method to test the functions
    public static void main(String[] args) {
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2}, new int[]{2, 3});
        System.out.println("Is connected: " + isConnected(4, edges1)); // true
        System.out.println("Connected components: " + countConnectedComponents(4, edges1)); // 1

        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{2, 3});
        System.out.println("Is connected: " + isConnected(4, edges2)); // false
        System.out.println("Connected components: " + countConnectedComponents(4, edges2)); // 2

        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{3, 4});
        System.out.println("Is connected: " + isConnected(5, edges3)); // false
        System.out.println("Connected components: " + countConnectedComponents(5, edges3)); // 2

        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4});
        System.out.println("Is connected: " + isConnected(5, edges4)); // true
        System.out.println("Connected components: " + countConnectedComponents(5, edges4)); // 1

        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 3});
        System.out.println("Is connected: " + isConnected(6, edges5)); // false
        System.out.println("Connected components: " + countConnectedComponents(6, edges5)); // 2
    }
}

