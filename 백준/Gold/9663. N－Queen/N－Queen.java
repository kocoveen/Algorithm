import java.io.*;

public class Main {
    static int N, cnt = 0;

    static boolean[] vis1, vis2, vis3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        vis1 = new boolean[N];
        vis2 = new boolean[2 * N - 1];
        vis3 = new boolean[2 * N - 1];

        func(0);
        System.out.println(cnt);
    }

    private static void func(int i) {
        if (i == N) {
            cnt++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (vis1[j] || vis2[i + j] || vis3[i - j + N - 1]) continue;
            vis1[j] = vis2[i + j] = vis3[i - j + N - 1] = true;
            func(i + 1);
            vis1[j] = vis2[i + j] = vis3[i - j + N - 1] = false;
        }
    }
}
