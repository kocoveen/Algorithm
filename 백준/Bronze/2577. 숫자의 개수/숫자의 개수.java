import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] Num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        Num = new int[10];
        int T = A * B * C;
        String r = String.valueOf(T);

        for (int i = 0; i < r.length(); i++)
            Num[r.charAt(i) - '0']++;

        for (int i : Num)
            System.out.println(i);
    }
}