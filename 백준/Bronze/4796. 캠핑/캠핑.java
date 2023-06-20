import java.io.*;

public class Main {
    static String[] l;

    static int L, P, V;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            l = br.readLine().split(" ");
            L = Integer.parseInt(l[0]);
            P = Integer.parseInt(l[1]);
            V = Integer.parseInt(l[2]);
            if (L == 0 && P == 0 && V == 0) break;
            cnt++;

            int a = V / P;
            int b = V % P;

            System.out.printf("Case %d: %d\n", cnt, a * L + Math.min(b, L));
        }

    }
}