import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = br.readLine().split(" ");
        N = Integer.parseInt(l1[0]);
        M = Integer.parseInt(l1[1]);

        arr = new int[N];
        tmp = new int[M];

        String[] l2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(l2[i]);
        Arrays.sort(arr);

        func(0, 0);
        System.out.print(sb);
    }

    private static void func(int depth, int s) {
        if (depth == M) {
            for (int i : tmp)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        int t = 0;
        for (int i = s; i < N; i++) {
            if (t == arr[i]) continue;
            tmp[depth] = arr[i];
            t = tmp[depth];
            func(depth + 1, i + 1);
        }
    }
}