import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static String[] l;

    static int N, i;

    static long[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        num = new long[N];


        while (i < N) {
            sb = new StringBuilder();
            String s = sc.next();
            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            s = String.valueOf(sb);
            num[i++] = Long.parseLong(s);
        }

        Arrays.sort(num);

        sb = new StringBuilder();
        for (long n : num) sb.append(n).append("\n");
        System.out.print(sb);

    }
}