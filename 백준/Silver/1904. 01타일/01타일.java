import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] tile;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        tile = new int[N+1];
        tile[0] = 1;
        tile[1] = 1;

        for (int i = 2; i < N + 1; i++)
            tile[i] = -1;

        bw.write(fib(N) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int fib(int N) {
        if (tile[N] == -1)
            tile[N] = (fib(N-1) + fib(N-2)) % 15746;
        return tile[N];
    }
}
