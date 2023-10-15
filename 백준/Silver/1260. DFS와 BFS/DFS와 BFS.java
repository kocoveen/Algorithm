import java.util.*;

public class Main {

    static Map<Integer, TreeSet<Integer>> mapBfs = new HashMap<>();
    static Map<Integer, TreeSet<Integer>> mapDfs = new HashMap<>();
    static boolean[] visited;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            mapBfs.put(i, new TreeSet<>());
            mapDfs.put(i, new TreeSet<>(Collections.reverseOrder()));
        }

        while (m-- > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            mapBfs.get(n1).add(n2); mapBfs.get(n2).add(n1);
            mapDfs.get(n1).add(n2); mapDfs.get(n2).add(n1);
        }

        System.out.println(dfs(s, n));
        System.out.println(bfs(s, n));
    }

    public static String dfs(int st, int n) {
        visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> S = new Stack<>();
        S.push(st);

        while (!S.isEmpty()) {
            int cur = S.pop();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            sb.append(cur).append(" ");
            for (int i : mapDfs.get(cur)) {
                if (visited[i]) continue;
                S.push(i);
            }
        }
        return sb.toString();
    }

    public static String bfs(int st, int n) {
        visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> Q = new LinkedList<>();
        Q.add(st);

        while (!Q.isEmpty()) {
            int cur = Q.remove();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            sb.append(cur).append(" ");
            for (int i : mapBfs.get(cur)) {
                if (visited[i]) continue;
                Q.add(i);
            }
        }
        return sb.toString();
    }
}