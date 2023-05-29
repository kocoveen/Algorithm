import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static StringBuilder sb = new StringBuilder();

    static int[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        C = new int[N];

        for (int i = 0; i < N; i++) C[i] = Integer.parseInt(br.readLine());

        Arrays.sort(C);

        for (int i : C) sb.append(i).append("\n");
        System.out.print(sb);
    }
}