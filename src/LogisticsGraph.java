import java.util.*;

public class LogisticsGraph {
    static final int SIZE = 5;
    static String[] warehouses = {"A", "B", "C", "D", "E"};
    static int[][] adjMatrix = new int[SIZE][SIZE];

    public static void main(String[] args) {
        // Inisialisasi graph
        addEdge(0, 1); // A -> B
        addEdge(0, 2); // A -> C
        addEdge(1, 3); // B -> D
        addEdge(2, 3); // C -> D
        addEdge(3, 4); // D -> E
        addEdge(1, 4); // B -> E
        addEdge(2, 4); // C -> E

        // Tampilkan adjacency matrix
        System.out.println("Adjacency Matrix:");
        printMatrix();

        // BFS dari A
        System.out.println("\nBFS dari Gudang A:");
        bfs(0);

        // DFS dari A
        System.out.println("\nDFS dari Gudang A:");
        boolean[] visited = new boolean[SIZE];
        dfs(0, visited);
    }

    static void addEdge(int from, int to) {
        adjMatrix[from][to] = 1;
    }

    static void printMatrix() {
        System.out.print("   ");
        for (String warehouse : warehouses) {
            System.out.print(warehouse + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(warehouses[i] + ": ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[SIZE];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(warehouses[node] + " ");

            for (int i = 0; i < SIZE; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(warehouses[node] + " ");

        for (int i = 0; i < SIZE; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }
}
