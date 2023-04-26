import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        l = new long[101];
        l[0] = 0;
        l[1] = 1;
        l[2] = 1;

        for (int i = 3; i < 101; i++)
            l[i] = -1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(fib(N) + "\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }

    public static long fib(int N) {
        if (l[N] == -1)
            l[N] = fib(N-2) + fib(N-3);
        return l[N];
    }
}