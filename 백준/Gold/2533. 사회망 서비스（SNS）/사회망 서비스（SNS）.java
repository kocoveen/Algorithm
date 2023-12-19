import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] visited;
    static List<Integer>[] graph;

    // dp : 해당 지점까지의 얼리어답터 수(트리 구조이기 때문에 자식 노드들의 dp 값을 더함)
    // [i][j]일 때,
    // i : 노드 번호;
    // j : 0 -> 해당 노드번호가 얼리어답터 X, 1 -> 해당 노드번호가 얼리어답터
    static int[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p].add(c);
            graph[c].add(p);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int p) {
        visited[p] = true;
        dp[p][0] = 0; // i 노드가 얼리어답터 X
        dp[p][1] = 1; // i 노드가 얼리어답터

        for (int c : graph[p]) {
            if (visited[c]) continue;
            dfs(c);
            dp[p][0] += dp[c][1]; //부모가 얼리어답터 X -> 자식은 무조건 얼리어답터
            dp[p][1] += Math.min(dp[c][0], dp[c][1]); //부모가 얼리어답터 O -> 자식은 얼리어답터일 수도, 아닐 수도
            //하지만, 해당 자식 노드가 가진 최소의 얼리어답터만 구함
        }
    }
}