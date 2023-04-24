import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] Num;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Num = new int[M];
        isVisited = new boolean[N];

        findNum(0, 1);
        System.out.print(sb);

    }

    public static void findNum(int depth, int from) {
        if (depth == M) {
            for (int i : Num)
                sb.append(i).append(' ');
            sb.append("\n");
            return;
        }
        for (int i = from; i <= N; i++) {
            Num[depth] = i;
            findNum(depth + 1, i);
        }
    }
}