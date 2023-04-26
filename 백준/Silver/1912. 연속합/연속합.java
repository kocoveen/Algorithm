import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] Num;
    static int[] Sum;
    static int N;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[100001];
        Sum = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(Sum, -1001);
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            Num[i] = n;
        }
        bw.write(findMax(N) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int N) {
        Sum[0] = Num[0];
        max = Num[0];
        for (int i = 1; i < N; i++) {
            Sum[i] = Math.max(Sum[i - 1] + Num[i], Num[i]);
            if (max < Sum[i])
                max = Sum[i];
        }
        return max;
    }
}