import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph = new int[51][51];
    static boolean[] visited = new boolean[51];
    static boolean[] cleanParty = new boolean[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 사람 수
        int m = Integer.parseInt(split[1]); // 파티 수

        Queue<Integer> q = new LinkedList<>();

        split = br.readLine().split(" ");
        for (int i = 1; i < split.length; i++) {
            q.offer(Integer.valueOf(split[i]));
        }

        for (int i = 1; i <= m; i++) {
            split = br.readLine().split(" ");
            for (int j = 1; j < split.length; j++) {
                int human = Integer.parseInt(split[j]);
                graph[i][human] = 1;
            }
        }

        while (!q.isEmpty()) {
            int curMan = q.poll();
            visited[curMan] = true;
            for (int p = 1; p <= m; p++) {
                if (graph[p][curMan] == 0) continue;
                if (cleanParty[p]) continue;
                for (int h = 1; h <= n; h++) {
                    if (visited[h]) continue;
                    if (graph[p][h] == 0) continue;
                    q.add(h);
                    visited[h] = true;
                }
                cleanParty[p] = true;
            }
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            if (!cleanParty[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}