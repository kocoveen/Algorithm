import java.io.*;
import java.util.Scanner;

public class Main {
    static int T, H, W, N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            int f = (N - 1) % H + 1;
            int n = (N - 1) / H + 1;
            System.out.println(f * 100 + n);
        }
    }
}