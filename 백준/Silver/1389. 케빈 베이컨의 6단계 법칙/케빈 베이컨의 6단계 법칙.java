import java.util.*;

public class Main {

    static int[][] graph;
    static int[] level;
    static int min = 5050;
    static int minIdx;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n][n];

        while (m-- > 0) {
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            level = new int[n];
            Arrays.fill(level, -1);

            int kevin = bfs(q, i, n);
            if (min > kevin) {
                min = kevin;
                minIdx = i;
            }
        }

        System.out.println(minIdx + 1);
    }

    private static int bfs(Queue<Integer> q, int i, int n) {
        q.offer(i);
        level[i] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int j = 0; j < n; j++) {
                if (graph[cur][j] > 0 && level[j] < 0) {
                    q.offer(j);
                    level[j] = level[cur] + 1;
                }
            }
        }

        return getKevins(level);
    }

    private static int getKevins(int[] level) {
        return Arrays.stream(level).sum();
    }
}