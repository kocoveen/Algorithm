import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int unit[] = {25, 10, 5, 1};
        int Q;

        for (int i = 0; i < N; i++) {
            int change = sc.nextInt();
            for (int j = 0; j < unit.length; j++) {
                Q = change / unit[j];
                change -= Q * unit[j];
                System.out.print(Q + " ");
            }
            System.out.println();
        }
    }
}