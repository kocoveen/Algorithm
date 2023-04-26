import java.io.*;

public class Main {
    static int[] Num;
    static Integer[] Sum;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[N+1];
        Sum = new Integer[N+1];

        for (int i = 1; i <= N; i++)
            Num[i] = Integer.parseInt(br.readLine());

        Sum[0] = Num[0];
        Sum[1] = Num[1];

        if (N >= 2)
            Sum[2] = Num[1] + Num[2];

        bw.write(findMax(N) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int N) {
        if (Sum[N] == null)
            Sum[N] = Math.max(findMax(N - 2), findMax(N - 3) + Num[N - 1]) + Num[N];
        return Sum[N];
    }
}