import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            l = br.readLine().split(" ");
            int a = Integer.parseInt(l[0]);
            int b = Integer.parseInt(l[1]);

            sb.append(lcm(a, b)).append('\n');
        }
        System.out.print(sb);
    }

    private static long lcm(long a, long b) {
        return a / gcb(a, b) * b;
    }

    private static long gcb(long a, long b) {
        if (b == 0) return a;
        return gcb(b, a % b);
    }
}