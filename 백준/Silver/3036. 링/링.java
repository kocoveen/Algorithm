import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] l = br.readLine().split(" ");

        int[] R = new int[N];
        for (int i = 0; i < N; i++)
            R[i] = Integer.parseInt(l[i]);

        for (int i = 1; i < N; i++) {
            int GCD = gcd(R[0], R[i]);
            if (GCD == 1) System.out.printf("%d/%d\n", R[0], R[i]);
            else System.out.printf("%d/%d\n", R[0] / GCD, R[i] / GCD);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}