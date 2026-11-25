import java.util.*;

public class Main {

    static int N, M, k;
    static int[] cost;
    static List<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        k = sc.nextInt();

        visit = new boolean[N+1];
        cost = new int[N+1];
        graph = new ArrayList[N+1];
        graph[0] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            graph[0].add(i);
            graph[i] = new ArrayList<>();
            cost[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 1. 0부터 탐색해서 최소 값을 구함.
        visit[0] = true;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            sum += search(i);
        }

        // 2. 예산 충족하는지 확인
        if (sum <= k) {
            System.out.println(sum);
        } else {
            System.out.println("Oh no");
        }
    }

    // 백트래킹으로 찾음.
    private static int search(int curr) {
        int min = cost[curr];
        visit[curr] = true;
        for (int next : graph[curr]) {
            if (visit[next]) continue;
            min = Math.min(min, search(next));
        }
        return min;
    }
}