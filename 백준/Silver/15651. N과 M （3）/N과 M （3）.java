import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] Num;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Num = new int[M];

        findNum(0);
        System.out.print(sb);

    }

    public static void findNum(int depth) {
        if (depth == M) {
            for (int i : Num)
                sb.append(i).append(' ');
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            Num[depth] = i + 1;
            findNum(depth + 1);
        }
    }
}