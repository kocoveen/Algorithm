import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        for (int i : A) {
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}