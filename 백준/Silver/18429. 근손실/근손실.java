import java.io.*;

public class Main {

    static String[] st;
    static int n, k;
    static int[] kits;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        k = Integer.parseInt(st[1]);

        kits = new int[n];
        visit = new boolean[n];
        st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            kits[i] = Integer.parseInt(st[i]);
        }

        backtracking(500, 0);
        System.out.println(answer);
    }

    private static void backtracking(int cur, int depth) {
        if (cur < 500) {
            return;
        }

        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            backtracking(cur - k + kits[i], depth + 1);
            visit[i] = false;
        }
    }
}