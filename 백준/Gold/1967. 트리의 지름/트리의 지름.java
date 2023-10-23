import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int maxIndex = 1;
    static int maxCost = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(parent).add(new Node(child, cost));
            graph.get(child).add(new Node(parent, cost));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[maxIndex] = true;
        dfs(maxIndex, 0);
        System.out.println(maxCost);
    }

    private static void dfs(int start, int cost) {
        if (maxCost < cost) {
            maxCost = cost;
            maxIndex = start;
        }

        for (Node node : graph.get(start)) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, cost + node.cost);
            }
        }
    }

    static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}