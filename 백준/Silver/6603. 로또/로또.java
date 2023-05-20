import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int k;

    static int[] arr;
    static int[] lotto = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] l = br.readLine().split(" ");
            k = Integer.parseInt(l[0]);

            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(l[i + 1]);

            func(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void func(int depth, int s) {
        if (depth == 6) {
            for (int i : lotto)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = s; i < k; i++) {
            lotto[depth] = arr[i];
            func(depth + 1, i + 1);
        }
    }
}