import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        
        H = new int[N];
        for (int i = 0; i < N; i++) {
            H[i] = sc.nextInt();
        }

        Arrays.sort(H);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                int A = H[i] + H[j];

                int l = 0;
                int r = N-1;

                while (l < r) {
                    if (l == i || l == j) {
                        l++;
                        continue;
                    }

                    if (r == i || r == j) {
                        r--;
                        continue;
                    }

                    int B = H[l] + H[r];
                    int diff = A-B;

                    min = Math.min(min, Math.abs(diff));

                    if (diff > 0) {
                        l++;
                    } else if (diff < 0) {
                        r--;
                    } else {
                        System.out.print(0);
                        System.exit(0);
                    }
                }
            } 
        }
        System.out.println(min);
    }
}