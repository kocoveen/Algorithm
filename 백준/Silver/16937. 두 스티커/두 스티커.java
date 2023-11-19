import java.io.*;

public class Main {

    static String[] st;
    static int[][] stickers;
    static int mx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split(" ");
        int h = Integer.parseInt(st[0]);
        int w = Integer.parseInt(st[1]);
        int n = Integer.parseInt(br.readLine());

        stickers = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int r = Integer.parseInt(st[0]);
            int c = Integer.parseInt(st[1]);
            stickers[i][0] = r;
            stickers[i][1] = c;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                mx = Math.max(mx, getMaxArea(stickers[i], stickers[j], h, w));
            }
        }
        System.out.println(mx);
    }

    private static int getMaxArea(int[] s1, int[] s2, int h, int w) {
        int area = s1[0] * s1[1] + s2[0] * s2[1];

        if (// s1, s2 무회전
            (Math.max(s1[0], s2[0]) <= h && s1[1] + s2[1] <= w) || // 가로 이어 붙임
            (s1[0] + s2[0] <= h && Math.max(s1[1], s2[1]) <= w) || // 세로 이어 붙임
            // s2만 회전
            (Math.max(s1[0], s2[1]) <= h && s1[1] + s2[0] <= w) || // 가로 이어 붙임
            (s1[0] + s2[1] <= h && Math.max(s1[1], s2[0]) <= w) || // 세로 이어 붙임
            // s1만 회전
            (Math.max(s1[1], s2[0]) <= h && s1[0] + s2[1] <= w) || // 가로 이어 붙임
            (s1[1] + s2[0] <= h && Math.max(s1[0], s2[1]) <= w) || // 세로 이어 붙임
            // s1, s2 회전
            (Math.max(s1[1], s2[1]) <= h && s1[0] + s2[0] <= w) || // 가로 이어 붙임
            (s1[1] + s2[1] <= h && Math.max(s1[0], s2[0]) <= w)    // 세로 이어 붙임
        ) {
            return area;
        }
        return 0;
    }
}