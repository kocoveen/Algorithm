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

        int[][] A = new int[n][2];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i][0] = Integer.parseInt(split[i]); // 값 저장
            A[i][1] = i; // 인덱스 저장
        }
        Arrays.sort(A, (a1, a2) -> {
            return a1[0] - a2[0];
        });

        for (int i = 0; i < n; i++) {
            B[A[i][1]] = i;
        }

        for (int b : B) {
            System.out.printf(b + " ");
        }
    }
}