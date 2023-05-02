import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long r = 31;
    static long M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = hash(str, N);

        sb.append(answer);

        bw.write(sb + "");
        bw.flush();
    }

    private static long hash(String str, int N) {
        long answer = 0;
        for (int i = 0; i < N; i++) {
            long tmp = str.charAt(i) - 'a' + 1;
            answer += (tmp * powMod(r, i));
        }

        return answer;
    }

    private static long powMod(long r, long i) {
        if (i == 0)
            return 1;
        return r * powMod(r, i - 1) % M;
    }
}