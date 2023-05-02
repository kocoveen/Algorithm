import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int Num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(gcd(A, B));
        System.out.println(lcm(A, B));

    }

    private static int lcm(int A, int B) {
        return A * B / gcd(A, B);
    }

    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}