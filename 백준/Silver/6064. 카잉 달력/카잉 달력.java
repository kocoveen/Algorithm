import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int T, M, N, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            l = br.readLine().split(" ");
            int M = Integer.parseInt(l[0]);
            int N = Integer.parseInt(l[1]);
            int x = Integer.parseInt(l[2]);
            int y = Integer.parseInt(l[3]);
            sb.append(func(M, N, x, y)).append('\n');
        }

        System.out.print(sb);
    }

    private static int func(int M, int N, int x, int y) {
        if (M == x) x = 0;
        if (N == y) y = 0;
        int val = lcm(M, N);

        for (int i = x; i <= val; i += M) {
            if (i == 0) continue;
            if (i % N == y) return i;
        }
        return -1;
    }

    private static int gcb(int A, int B) {
        if (A == 0) return B;
        return gcb(B % A, A);
    }

    private static int lcm(int A, int B) {
        return A / gcb(A, B) * B;
    }

}