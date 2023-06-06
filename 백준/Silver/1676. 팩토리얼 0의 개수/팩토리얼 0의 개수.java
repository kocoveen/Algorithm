import java.io.*;

public class Main {
    static int N, fiveCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int tmp = i;
            while (tmp % 5 == 0) {
                tmp /= 5;
                fiveCnt++;
            }
        }

        if (N == 0) System.out.println(0);
        else System.out.println(fiveCnt);
    }
}