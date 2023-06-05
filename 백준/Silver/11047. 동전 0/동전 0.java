import java.io.*;

public class Main {
    static String[] l;

    static int N, K;

    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        K = Integer.parseInt(l[1]);
        value = new int[N];
        for (int i = 0; i < N; i++)
            value[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            ans += K / value[i];
            K %= value[i];
        }
        System.out.println(ans);
    }
}