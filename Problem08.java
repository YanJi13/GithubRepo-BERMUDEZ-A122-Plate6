import java.util.*;

public class Problem08 {

    public static boolean areIsomorphic(int n, List<int[]> edges1, List<int[]> edges2) {
        if (edges1.size() != edges2.size()) {
            return false;
        }

        int[][] adjMatrix1 = createAdjacencyMatrix(n, edges1);
        int[][] adjMatrix2 = createAdjacencyMatrix(n, edges2);

        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        return checkIsomorphism(adjMatrix1, adjMatrix2, perm, 0);
    }

    private static int[][] createAdjacencyMatrix(int n, List<int[]> edges) {
        int[][] adjMatrix = new int[n][n];
        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]]++;
            adjMatrix[edge[1]][edge[0]]++;
        }
        return adjMatrix;
    }

    private static boolean checkIsomorphism(int[][] adjMatrix1, int[][] adjMatrix2, int[] perm, int index) {
        int n = perm.length;
        if (index == n) {
            return isIsomorphicUnderPermutation(adjMatrix1, adjMatrix2, perm);
        }

        for (int i = index; i < n; i++) {
            swap(perm, i, index);
            if (checkIsomorphism(adjMatrix1, adjMatrix2, perm, index + 1)) {
                return true;
            }
            swap(perm, i, index);
        }

        return false;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static boolean isIsomorphicUnderPermutation(int[][] adjMatrix1, int[][] adjMatrix2, int[] perm) {
        int n = perm.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix1[i][j] != adjMatrix2[perm[i]][perm[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 2});
        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        System.out.println(areIsomorphic(3, edges1, edges2)); // true

        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3});
        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3});
        System.out.println(areIsomorphic(4, edges3, edges4)); // true

        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0});
        List<int[]> edges6 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{0, 2});
        System.out.println(areIsomorphic(4, edges5, edges6)); // false

        List<int[]> edges7 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 2});
        List<int[]> edges8 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}, new int[]{2, 3});
        System.out.println(areIsomorphic(4, edges7, edges8)); // false

        List<int[]> edges9 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{0, 2});
        List<int[]> edges10 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0}, new int[]{0, 2});
        System.out.println(areIsomorphic(4, edges9, edges10)); // true
    }
}

