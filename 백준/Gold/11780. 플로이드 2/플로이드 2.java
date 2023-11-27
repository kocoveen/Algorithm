import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int INF = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        List<Integer>[][] routes = new ArrayList[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                routes[i][j] = new ArrayList<>();
                map[i][j] = INF;
            }
            map[i][i] = 0;
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], w);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        trackingRoute(routes, i, k, j);
                    }
                }
            }
        }
        printMap(map);
        printRoute(routes, map);
    }

    private static void trackingRoute(List<Integer>[][] routes, int i, int k, int j) {
        routes[i][j].clear();
        for (int route : routes[i][k]) {
            routes[i][j].add(route);
        }
        routes[i][j].add(k);
        for (int route : routes[k][j]) {
            routes[i][j].add(route);
        }
    }

    static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[i].length; j++) {
                if (map[i][j] != INF) {
                    sb.append(map[i][j]).append(" ");
                } else {
                    sb.append("0").append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void printRoute(List<Integer>[][] routes, int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < routes.length; i++) {
            for (int j = 1; j < routes[i].length; j++) {
                int size = routes[i][j].size();
                if (i != j && map[i][j] != INF) {
                    sb.append((size + 2)).append(" ").append(i).append(" ");
                    for (int num : routes[i][j]) {
                        sb.append(num).append(" ");
                    }
                    sb.append(j);
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}