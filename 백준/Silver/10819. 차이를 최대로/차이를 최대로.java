import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int[] tmp;
    static boolean[] vis;
    static int n, mx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        vis = new boolean[n];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        tmp = new int[n];

        backtracking(0);
        System.out.println(mx);
    }

    public static void backtracking(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(tmp[i] - tmp[i + 1]);
            }
            mx = Math.max(mx, sum);
        }

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            tmp[depth] = arr[i];
            vis[i] = true;
            backtracking(depth + 1);
            vis[i] = false;
        }
    }
}