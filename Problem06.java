import java.util.*;

public class Problem06 {

    // Create an adjacency matrix for a graph
    public static int[][] createAdjacencyMatrix(int n, List<int[]> edges, boolean directed) {
        int[][] adjacencyMatrix = new int[n][n];
        
        // Fill the adjacency matrix based on the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyMatrix[u][v]++;
            if (!directed) {
                adjacencyMatrix[v][u]++;
            }
        }
        
        return adjacencyMatrix;
    }

    // Print the adjacency matrix
    public static void printAdjacencyMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Undirected graph
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{2, 3});
        int[][] matrix1 = createAdjacencyMatrix(4, edges1, false);
        System.out.println("Test Case 1: Undirected graph");
        printAdjacencyMatrix(matrix1);
        
        // Test Case 2: Directed graph with multiple edges
        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{0, 1});
        int[][] matrix2 = createAdjacencyMatrix(3, edges2, true);
        System.out.println("Test Case 2: Directed graph with multiple edges");
        printAdjacencyMatrix(matrix2);
        
        // Test Case 3: Undirected graph with a loop
        List<int[]> edges3 = Arrays.asList(new int[]{0, 0}, new int[]{0, 2}, new int[]{0, 3}, new int[]{3, 4});
        int[][] matrix3 = createAdjacencyMatrix(5, edges3, false);
        System.out.println("Test Case 3: Undirected graph with a loop");
        printAdjacencyMatrix(matrix3);
        
        // Test Case 4: Directed graph
        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 0});
        int[][] matrix4 = createAdjacencyMatrix(5, edges4, true);
        System.out.println("Test Case 4: Directed graph");
        printAdjacencyMatrix(matrix4);
        
        // Test Case 5: Undirected graph with multiple edges and loops
        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 4});
        int[][] matrix5 = createAdjacencyMatrix(5, edges5, false);
        System.out.println("Test Case 5: Undirected graph with multiple edges and loops");
        printAdjacencyMatrix(matrix5);
    }
}


