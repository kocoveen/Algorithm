import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] Size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Size = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Size[i][0] = Integer.parseInt(st.nextToken());
            Size[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (Size[i][0] == Size[j][0] && Size[i][1] == Size[j][1])
                    continue;

                if (Size[i][0] < Size[j][0] && Size[i][1] < Size[j][1])
                    count++;
            }
            sb.append(count).append(" ");
        }

        bw.write(sb + "");
        bw.flush();
    }
}