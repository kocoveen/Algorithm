import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        l = br.readLine().split(" ");

        int E = Integer.parseInt(l[0]);
        int S = Integer.parseInt(l[1]);
        int M = Integer.parseInt(l[2]);

        int val = 0;
        int lcm = lcm(28, 19);

        for (int i = S; i <= 10000000; i += 28) {
            if (i % 19 == M % 19) {
                val = i;
                break;
            }
        }

        for (int i = val; i <= 10000000; i += lcm) {
            if (i % 15 == E % 15) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }

    private static int lcm(int s, int m) {
        return s / gcd(s, m) * m;
    }

    private static int gcd(int s, int m) {
        if (m == 0) return s;
        return gcd(m, s % m);
    }
}