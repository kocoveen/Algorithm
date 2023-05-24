import java.io.*;
import java.util.Stack;

public class Main {

    static String[] l;
    static int[][] Gears = new int[4][8];
    static int[] Index12 = new int[4];
    static int[] CW = new int[4];
    static boolean[] vis = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            l = br.readLine().split("");
            for (int j = 0; j < 8; j++)
                Gears[i][j] = Integer.parseInt(l[j]);
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            l = br.readLine().split(" ");
            int gNum = Integer.parseInt(l[0]) - 1;
            int cw = Integer.parseInt(l[1]);

            Stack<Integer> S = new Stack<>();
            S.add(gNum);
            CW[gNum] = cw;
            vis[gNum] = true;
            while (!S.isEmpty()) {
                Integer cur = S.pop();
                for (int i : new int[]{1, -1}) {
                    int nx = cur + i;
                    if (nx < 0 || nx >= 4 || vis[nx]) continue;
                    if (i == -1) { // 왼 기어 비교
                        int curLP = Gears[cur][(Index12[cur] + 6) % 8];
                        int prevRP = Gears[nx][(Index12[nx] + 2) % 8];
                        if (curLP != prevRP) CW[nx] = -CW[cur];
                    } else { // 오른 기어 비교
                        int curRP = Gears[cur][(Index12[cur] + 2) % 8];
                        int prevLP = Gears[nx][(Index12[nx] + 6) % 8];
                        if (curRP != prevLP) CW[nx] = -CW[cur];
                    }
                    S.push(nx);
                    vis[nx] = true;
                }
            }

            // 기어 돌리기
            for (int i = 0; i < 4; i++) {
                Index12[i] = (Index12[i] + 8 - CW[i]) % 8;
                CW[i] = 0;
                vis[i] = false;
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++)
            score += (int) Math.pow(2, i) * Gears[i][Index12[i]];

        System.out.print(score);
    }
}