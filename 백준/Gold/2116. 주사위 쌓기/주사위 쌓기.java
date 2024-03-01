import java.util.*;

public class Main {

    static int n, mx;
    static int[][] dices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dices = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dices[i][j] = sc.nextInt();
            }
            for (int j = 3; j < 6; j++) {
                dices[i][((j + 1) % 3) + 3] = sc.nextInt();
            }
        }

        for (int i = 0; i < 6; i++) {
            dfs(0, i, getMax(0, i, (i + 3) % 6));
        }

        System.out.println(mx);
    }

    private static void dfs(int depth, int cur_up, int maxSum) {
        if (depth == n - 1) {
            mx = Math.max(mx, maxSum);
            return;
        }

        int next_up = -1, max = 0;
        for (int next_down = 0; next_down < 6; next_down++) {
            if (dices[depth][cur_up] == dices[depth + 1][next_down]) {
                next_up = (next_down + 3) % 6;
                max = getMax(depth + 1, next_up, next_down);
                break;
            }
        }
        
        dfs(depth + 1, next_up, max + maxSum);
    }

    private static int getMax(int depth, int up, int down) {
        if (dices[depth][up] == 6 && dices[depth][down] == 5 || dices[depth][up] == 5 && dices[depth][down] == 6) {
            return 4;
        } else if (dices[depth][up] == 6 || dices[depth][down] == 6) {
            return 5;
        } else {
            return 6;
        }
    }
}