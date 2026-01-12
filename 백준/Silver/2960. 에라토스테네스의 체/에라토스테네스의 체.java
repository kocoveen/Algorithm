import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        boolean[] sieve = new boolean[N + 1];
        
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (sieve[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (!sieve[j]) {
                    sieve[j] = true;
                    count++;
                    if (count == K) {   
                        System.out.println(j);
                        System.exit(0);
                    }
                }
            }
        }
    }
}