import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        parent[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (parent[next] != 0) continue;
                parent[next] = cur;
                q.offer(next);
            }
        }
    }

}