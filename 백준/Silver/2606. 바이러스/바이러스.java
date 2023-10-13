import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static int n, m, answer;
    static List<Integer>[] networks;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n + 1];
        networks = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            networks[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            String[] link = br.readLine().split(" ");
            int node1 = Integer.parseInt(link[0]);
            int node2 = Integer.parseInt(link[1]);

            networks[node1].add(node2);
            networks[node2].add(node1);
        }

        Stack<Integer> S = new Stack<>();
        S.push(1);
        visited[1] = true;

        while (!S.isEmpty()) {
            int cur = S.pop();
            for (int next : networks[cur]) {
                if (!visited[next]) {
                    S.push(next);
                    visited[next] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
