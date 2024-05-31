import java.util.*;

public class Problem02 {

    // Converts adjacency matrix to edge list
    public static List<int[]> getEdges(int[][] adjMatrix) {
        List<int[]> edges = new ArrayList<>();
        int n = adjMatrix.length;

        // Iterate over the upper triangular portion of the matrix to avoid duplicates
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (adjMatrix[i][j] > 0) { // If there is a non-zero value, there is an edge
                    edges.add(new int[]{i, j, adjMatrix[i][j]});  // Add edge with its weight
                }
            }
        }
        return edges;
    }

    // Prints the edges along with their weights
    public static void printEdges(List<int[]> edges) {
        for (int[] edge : edges) {
            // Print the edge coordinates and its weight
            System.out.println("Edge: (" + edge[0] + ", " + edge[1] + ") - Weight: " + edge[2]);
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] adjMatrix1 = {
            {0, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {0, 0, 1, 0}
        };
        List<int[]> edges1 = getEdges(adjMatrix1);
        System.out.println("Test Case 1:");
        printEdges(edges1);

        // Test case 2
        int[][] adjMatrix2 = {
            {0, 2, 0},
            {2, 0, 1},
            {0, 1, 0}
        };
        List<int[]> edges2 = getEdges(adjMatrix2);
        System.out.println("Test Case 2:");
        printEdges(edges2);

        // Test case 3
        int[][] adjMatrix3 = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };
        List<int[]> edges3 = getEdges(adjMatrix3);
        System.out.println("Test Case 3:");
        printEdges(edges3);

        // Test case 4
        int[][] adjMatrix4 = {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0}
        };
        List<int[]> edges4 = getEdges(adjMatrix4);
        System.out.println("Test Case 4:");
        printEdges(edges4);

        // Test case 5
        int[][] adjMatrix5 = {
            {0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 0}
        };
        List<int[]> edges5 = getEdges(adjMatrix5);
        System.out.println("Test Case 5:");
        printEdges(edges5);
    }
}


