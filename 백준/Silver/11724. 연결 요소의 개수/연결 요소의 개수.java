import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int[][] network;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        network = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        while (M-- > 0) {
            split = br.readLine().split(" ");
            network[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            network[Integer.parseInt(split[1])][Integer.parseInt(split[0])] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            Stack<Integer> S = new Stack<>();
            S.push(i);
            visited[i] = true;
            while (!S.isEmpty()) {
                int cur = S.pop();
                for (int j = 1; j <= N; j++) {
                    if (visited[j] || network[cur][j] == 0) continue;
                    S.add(j);
                    visited[j] = true;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
