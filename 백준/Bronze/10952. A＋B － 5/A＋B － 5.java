import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n, m;
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0) break;
            System.out.println(n + m);
        }
    }
}