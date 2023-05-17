import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l = br.readLine().split(" ");
        int A = Integer.parseInt(l[0]);
        int B = Integer.parseInt(l[1]);
        int C = Integer.parseInt(l[2]);
        System.out.println(power(A, B, C));
    }

    private static long power(int A, int B, int C) {
        if (B == 1) return A % C;
        long tmp = power(A, B / 2, C);
        tmp = tmp * tmp % C;
        if (B % 2 == 0) return tmp;
        return tmp * A % C;
    }
}