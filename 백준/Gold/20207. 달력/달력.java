import java.util.Scanner;

public class Main {

    static int[] ranges = new int[365];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt() - 1;
            int E = sc.nextInt() - 1;

            for (int j = S; j <= E; j++) {
                ranges[j]++;
            }
        }

        int total = 0;
        int maxH = 0, maxW = 0;
        
        for (int i = 0; i <= 365; i++) {
            if (i == 365 || ranges[i] == 0) {
                total += maxH * maxW;
                maxH = 0; maxW = 0;
                continue;
            }

            maxH = Math.max(maxH, ranges[i]);

            if (maxH < ranges[i]) {
                maxH = ranges[i];
            }
            maxW++;
        }

        System.out.println(total);
    }
}