import java.util.*;
class Solution {
    public static boolean isSafe(int node, int[] color, boolean[][] graph, int n, int col) {
        for (int k = 0; k < n; k++) {
            if (k != node && graph[k][node] && color[k] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int node, int[] color, int m, int N, boolean[][] graph) {
        if (node == N) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, color, graph, N, i)) {
                color[node] = i;
                if (solve(node + 1, color, m, N, graph)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(boolean[][] graph, int m, int N) {
        int[] color = new int[N];
        Arrays.fill(color, 0);
        if (solve(0, color, m, N, graph)) return true;
        return false;
    }
}

public class NColoringProblem {

    public static void main(String[] args) {
        int N = 4;
        int m = 3;

        boolean[][] graph = new boolean[101][101];
        graph[0][1] = graph[1][0] = true;
        graph[1][2] = graph[2][1] = true;
        graph[2][3] = graph[3][2] = true;
        graph[3][0] = graph[0][3] = true;
        graph[0][2] = graph[2][0] = true;

        System.out.println(Solution.graphColoring(graph, m, N));
    }
}