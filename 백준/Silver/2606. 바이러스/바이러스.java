import java.util.*;

public class Main {
    
    static int N, M, count;
    static int[][] graph;
    static boolean[] visit;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N+1][N+1];
        visit = new boolean[N+1];

        while (M-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        infect(1);
        System.out.print(count);
    }

    private static void infect(int u) {
        visit[u] = true;

        for (int v = 1; v <= N; v++) {
            if (!visit[v] && graph[u][v] == 1) {
                infect(v);
                count++;
            }
        }
    }
}
