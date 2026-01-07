import java.io.*;

public class Main {
    static String[] line;
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int W = Integer.parseInt(line[1]);
        int[] degree = new int[N + 1]; // 연결 간선 개수

        for (int i = 0; i < N - 1; i++) {
            line = reader.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            
            degree[u]++;
            degree[v]++;
        }
        int leafCount = 0;
        for (int i = 2; i <= N; i++) {
            if (degree[i] == 1) {
                leafCount++;
            }
        }
        System.out.println((double) W / leafCount);
    }
}