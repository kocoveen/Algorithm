import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] switches;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        switches = new int[N+1];
        for (int i = 1; i <= N; i++) {
            switches[i] = sc.nextInt();
        }

        M = sc.nextInt();
        while (M-- > 0) {
            int g = sc.nextInt();
            int n = sc.nextInt();

            if (g == 1) {
                for (int i = n; i <= N; i += n) {
                    switches[i] = switches[i] > 0 ? 0 : 1;
                }
            } else {
                switches[n] = switches[n] > 0 ? 0 : 1;
                for (
                    int i = n-1, j = n+1; 
                    i >= 1 && j <= N && switches[i] == switches[j]; 
                    i--, j++
                ) {
                    switches[i] = switches[i] > 0 ? 0 : 1;
                    switches[j] = switches[j] > 0 ? 0 : 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}