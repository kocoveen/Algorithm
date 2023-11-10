import java.io.*;

public class Main {

    static String[] sign;
    static int[] arr;
    static boolean[] visit;
    static int n;
    static long mx = Long.MIN_VALUE, mn = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visit = new boolean[10];
        sign = br.readLine().split(" ");

        dfs(0);
        print(mx);
        print(mn);
    }

    private static void print(long l) {
        for (int i = n; i >= 0; i--) {
            arr[i] = (int) (l % 10);
            l /= 10;
        }

        for (int i = 0; i <= n; i++) {
            System.out.printf("%d", arr[i]);
        }
        System.out.println();
    }

    private static void dfs(int depth) {
        if (depth == n + 1) {
            long num = makeNumber(arr);
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i]) continue;
            arr[depth] = i;
            visit[i] = true;
            if (depth == 0) {
                dfs(depth + 1);
            } else {
                if (("<").equals(sign[depth - 1]) && arr[depth - 1] < i ||
                    (">").equals(sign[depth - 1]) && arr[depth - 1] > i) {
                    dfs(depth + 1);
                }
            }
            visit[i] = false;
        }
    }

    private static long makeNumber(int[] arr) {
        long a = 1, b = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            b += arr[i] * a;
            a *= 10;
        }
        return b;
    }
}