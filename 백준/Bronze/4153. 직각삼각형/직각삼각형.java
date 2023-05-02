import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int Num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Num = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++)
                Num[i] = Integer.parseInt(st.nextToken());

            if (Num[0] == 0 && Num[1] == 0 && Num[2] == 0)
                System.exit(0);

            Arrays.sort(Num);

            if (ok(Num[0], Num[1], Num[2]))
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
    private static boolean ok(int P, int B, int H) {
        return P * P + B * B == H * H;
    }
}