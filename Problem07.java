import java.util.*;

public class Problem07 {

    public static int[][] createIncidenceMatrix(int n, List<int[]> edges) {
        int edgeCount = edges.size();
        int[][] incidenceMatrix = new int[n][edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            int[] edge = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            incidenceMatrix[u][i]++;
            if (u != v) {
                incidenceMatrix[v][i]++;
            }
        }

        return incidenceMatrix;
    }

    public static void printIncidenceMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test cases
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[]{2, 3});
        int[][] matrix1 = createIncidenceMatrix(4, edges1);
        System.out.println("Test Case 1:");
        printIncidenceMatrix(matrix1);

        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}, new int[]{0, 1});
        int[][] matrix2 = createIncidenceMatrix(3, edges2);
        System.out.println("Test Case 2:");
        printIncidenceMatrix(matrix2);

        List<int[]> edges3 = Arrays.asList(new int[]{0, 0}, new int[]{0, 2}, new int[]{0, 3}, new int[]{3, 4});
        int[][] matrix3 = createIncidenceMatrix(5, edges3);
        System.out.println("Test Case 3:");
        printIncidenceMatrix(matrix3);

        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 0});
        int[][] matrix4 = createIncidenceMatrix(5, edges4);
        System.out.println("Test Case 4:");
        printIncidenceMatrix(matrix4);

        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 4});
        int[][] matrix5 = createIncidenceMatrix(5, edges5);
        System.out.println("Test Case 5:");
        printIncidenceMatrix(matrix5);
    }
}

