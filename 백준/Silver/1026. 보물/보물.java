import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static int N, sum = 0;

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(l[i]);
        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) B[i] = -Integer.parseInt(l[i]);

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < N; i++) B[i] = -B[i];
        
        for (int i = 0; i < N; i++) sum += A[i] * B[i];
        
        System.out.println(sum);

    }
}