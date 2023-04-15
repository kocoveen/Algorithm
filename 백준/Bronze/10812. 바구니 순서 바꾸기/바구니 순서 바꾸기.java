import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int b[] = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            b[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            for (int j = 0; j < mid - begin; j++) {
                int temp = b[begin];
                for (int k = begin; k < end; k++) {
                    b[k] = b[k+1];
                }
                b[end] = temp;
            }
        }

        for (int i = 1; i <= N; i++)
            bw.write(b[i] + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}