import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] Count;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Count = new int[2][7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            Count[S][Y]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                count += (Count[i][j] / K);
                if (Count[i][j] % K != 0)
                    count++;
            }
        }
        bw.write(count + "");

        bw.flush();
        br.close();
        bw.close();
    }
}