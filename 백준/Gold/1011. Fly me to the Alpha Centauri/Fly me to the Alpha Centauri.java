import java.io.*;

public class Main {
    static String[] l;

    private static final int C = 46341;

    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            l = br.readLine().split(" ");
            long diff = Integer.parseInt(l[1]) - Integer.parseInt(l[0]);

            for (long i = 0; i <= C; i++) {
                if (i * i <= diff && diff < (i + 1) * (i + 1)) {
                    if (diff == i * i) cnt = 2 * i - 1;
                    else if (diff - (i * i) <= i) cnt = 2 * i;
                    else if (diff - (i * i) > i) cnt = 2 * i + 1;
                }
            }

            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}