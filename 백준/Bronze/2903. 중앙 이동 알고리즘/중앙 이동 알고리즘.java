import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int exp = 1;

        for (int i = 0; i < n; i++) {
            exp *= 2;
        }
        System.out.println((exp+1)*(exp+1));
    }
}