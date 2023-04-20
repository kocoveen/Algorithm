import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            long result = bridge(left, right);
            sb.append(result).append("\n");
        }

        bw.write( sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static long bridge(long left, long right) {
        long result = 1;
        long temp = Math.max(right - left, left);
        for (long i = right; i > temp; i--)
            result *= i;
        for (int i = 2; i <= right - temp; i++)
            result /= i;
        return result;
    }
}