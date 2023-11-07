import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String[] split;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");

        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(split[i]);
            B[i] = A[i];
        }
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) {
                    System.out.print(j + " ");
                    B[j] = -1;
                    break;
                }
            }
        }
    }
}