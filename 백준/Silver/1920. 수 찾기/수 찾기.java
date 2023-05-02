import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int Num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Num = new int[N];
        for (int i = 0; i < N; i++)
            Num[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {

            boolean exist = false;
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (Num[j] == k) {
                    exist = true;
                    break;
                }
            }

            if (exist)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
    }
}