import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visit = new boolean[n+1];
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            visit[i] = false;
        }
    }
}