import java.io.*;

public class Main {
    static String[] l;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int N = Integer.parseInt(l[0]);
        int a = Integer.parseInt(l[1]) - 1;
        int b = Integer.parseInt(l[2]) - 1;

        while (N / 2 != 0) {
            cnt++;
            if (a / 2 == b / 2) break;

            if (N % 2 == 0) N /= 2;
            else N = N / 2 + 1;
            a /= 2;
            b /= 2;
        }

        System.out.println(cnt);
    }
}