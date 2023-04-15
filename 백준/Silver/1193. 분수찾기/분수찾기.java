import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 1;
        while(n > f) {
            n -= f;
            f++;
        }
        if (f % 2 == 0)
            System.out.printf("%d/%d", n, (f+1-n));
        else
            System.out.printf("%d/%d", (f+1-n), n);
    }
}