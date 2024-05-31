import java.util.*;

public class Problem04 {

    // Calculates the degree of each vertex in the graph
    public static Map<Integer, Integer> calculateDegrees(int n, List<int[]> edges) {
        Map<Integer, Integer> degreeMap = new HashMap<>();

        // Initialize the degree of each vertex to 0
        for (int i = 0; i < n; i++) {
            degreeMap.put(i, 0);
        }

        // Calculate the degree for each vertex
        for (int[] edge : edges) {
            degreeMap.put(edge[0], degreeMap.get(edge[0]) + 1); // Increment degree for first vertex
            degreeMap.put(edge[1], degreeMap.get(edge[1]) + 1); // Increment degree for second vertex
        }

        return degreeMap;
    }

    public static void main(String[] args) {
        // Test case 1: Simple triangle graph
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0});
        Map<Integer, Integer> degrees1 = calculateDegrees(3, edges1);
        System.out.println("Degrees for graph 1: " + degrees1); // {0=2, 1=2, 2=2}

        // Test case 2: Linear graph
        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2});
        Map<Integer, Integer> degrees2 = calculateDegrees(3, edges2);
        System.out.println("Degrees for graph 2: " + degrees2); // {0=1, 1=2, 2=1}

        // Test case 3: Star graph
        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3});
        Map<Integer, Integer> degrees3 = calculateDegrees(4, edges3);
        System.out.println("Degrees for graph 3: " + degrees3); // {0=3, 1=1, 2=1, 3=1}

        // Test case 4: Disconnected graph
        List<int[]> edges4 = Arrays.asList(new int[]{0, 1}, new int[]{2, 3});
        Map<Integer, Integer> degrees4 = calculateDegrees(4, edges4);
        System.out.println("Degrees for graph 4: " + degrees4); // {0=1, 1=1, 2=1, 3=1}

        // Test case 5: Graph with a loop
        List<int[]> edges5 = Arrays.asList(new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 2});
        Map<Integer, Integer> degrees5 = calculateDegrees(3, edges5);
        System.out.println("Degrees for graph 5: " + degrees5); // {0=1, 1=4, 2=1}
    }
}
