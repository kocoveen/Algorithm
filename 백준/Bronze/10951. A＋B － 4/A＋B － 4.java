import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n, m;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();
            System.out.println(n + m);
        }
    }
}