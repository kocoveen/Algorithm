import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = 2;
        while (N > 1) {
            while (N % i == 0) {
                N /= i;
                System.out.println(i);
            }
            i++;
        }
    }
}