import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] A;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = 100; int sum = 0;
        for (int i = 0; i < 7; i++) {
            int K = Integer.parseInt(br.readLine());
            if ((K & 1) == 1) {
                sum += K;
                min = Math.min(K, min);
            }
        }
        if (min == 100) {
            System.out.println(-1);
            System.exit(0);
        }

        System.out.println(sum);
        System.out.println(min);
    }

}

