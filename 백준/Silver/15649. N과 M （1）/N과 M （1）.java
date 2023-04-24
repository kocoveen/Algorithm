import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisited = new boolean[10];
    static int[] Num = new int[10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        findNum(1, N, M);
        System.out.println(sb);

    }

    private static void findNum(int index, int N, int M) {
        if (index == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(Num[i]);
                if (i != M) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            Num[index] = i;
            findNum(index + 1, N, M);
            isVisited[i] = false;
        }
    }

}