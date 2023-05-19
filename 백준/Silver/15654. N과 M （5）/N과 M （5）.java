import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static boolean[] vis;
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = br.readLine().split(" ");
        N = Integer.parseInt(l1[0]);
        M = Integer.parseInt(l1[1]);

        vis = new boolean[N];
        arr = new int[N];
        tmp = new int[M];

        String[] l2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(l2[i]);
        Arrays.sort(arr);

        func(0);
        System.out.print(sb);
    }

    private static void func(int depth) {
        if (depth == M) {
            for (int i : tmp)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            tmp[depth] = arr[i];
            func(depth + 1);
            vis[i] = false;
        }
    }
}