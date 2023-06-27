import java.io.*;

public class Main {
    static String S;
    static int N;

    static int[] arr = new int[10];
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        N = Integer.parseInt(S);

        for (int i = 1; i <= 10; i++)
            func(i, 0, 10);

        System.out.println(-1);
    }

    private static void func(int size, int depth, int prev) {
        if (size == depth) {
            cnt++;
            long k = 0;
            long num = 1;
            for (int p = depth - 1; p >= 0; p--) {
                k += arr[p] * num;
                num *= 10;
            }
            if (cnt == N) {
                System.out.println(k);
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < prev; i++) {
            arr[depth] = i;
            func(size, depth + 1, i);
        }
    }
}