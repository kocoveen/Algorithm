import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(Factorial(N));
    }

    private static long Factorial(long n) {
        if (n == 0 || n == 1) return 1;
        return n * Factorial(n - 1);
    }
}