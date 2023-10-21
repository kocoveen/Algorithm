import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static TreeMap<Integer, Integer>[] graph;
    static int mx;
    static int[] dists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new TreeMap[n + 1];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int node1 = Integer.parseInt(split[0]);
            graph[node1] = new TreeMap<>(Collections.reverseOrder());
            for (int j = 1; j < split.length - 1; j += 2) {
                int node2 = Integer.parseInt(split[j]);
                int dist = Integer.parseInt(split[j + 1]);
                graph[node1].put(node2, dist);
            }
        }

        dists = new int[n + 1];
        dfs(1, new boolean[n + 1]);
        int n1 = getMaxDistIndex(1); // 1에서 가장 먼 노드

        // 1에서 가장 먼 노드에서 한 번만 이동할 때 가장 먼 노드
        Map.Entry<Integer, Integer> n2 = graph[n1].firstEntry();

        dists = new int[n + 1];
        dfs(n2.getKey(), new boolean[n + 1]);

        for (int i = 1; i <= n; i++) {
            if (i == n1) continue;
            mx = Math.max(dists[i], mx);
        }

        System.out.println(n2.getValue() + mx);
    }

    private static void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (Map.Entry<Integer, Integer> en : graph[i].entrySet()) {
            if (visited[en.getKey()]) continue;
            visited[en.getKey()] = true;
            dists[en.getKey()] = dists[i] + en.getValue();
            dfs(en.getKey(), visited);
        }
    }

    private static int getMaxDistIndex(int index) {
        int maxI = index, max = 0;
        for (int i = 1; i < dists.length; i++) {
            if (max < dists[i]) {
                max = dists[i];
                maxI = i;
            }
        }
        return maxI;
    }
}