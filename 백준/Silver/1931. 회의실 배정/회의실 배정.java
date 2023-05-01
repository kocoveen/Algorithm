import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] P;
    static Integer[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        P = new int[N][2];
        V = new Integer[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            P[i][0] = Integer.parseInt(st.nextToken());
            P[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int count = 0;
        int endtime = 0;

        for (int i = 0; i < N; i++) {
            if (endtime <= P[i][0]) {
                endtime = P[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}