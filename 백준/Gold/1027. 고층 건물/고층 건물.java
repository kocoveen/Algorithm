import java.util.Scanner;

public class Main {

    static int n;
    static int[] buildings;
    static double[][] slopes;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        // 입력 받기
        String[] tmp = sc.nextLine().split(" ");
        buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(tmp[i]);
        }

        // 기울기 계산 slopes[a][b] = (buildings[a] - buildings[b]) / (a - b);
        slopes = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                slopes[i][j] = (double) (buildings[i] - buildings[j]) / (i - j);
            }
        }

        switch (n) {
            case 1:
            case 2:
            case 3:
                System.out.println(n - 1);
                return;
        }


        for (int x = 0; x < n; x++) {
            // x 왼쪽
            int lcount = x == 0 ? 0 : 1;
            for (int xl = x-2; xl >= 0; xl--) {
                boolean flag = true;
                for (int xa = xl + 1; xa < x; xa++) {
                    if (slopes[x][xl] >= slopes[x][xa]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) lcount++;
            }

            // x 오른쪽
            int rcount = x == n-1 ? 0 : 1;
            for (int xr = x+2; xr < n; xr++) {
                boolean flag = true;
                for (int xb = xr - 1; xb > x; xb--) {
                    if (slopes[x][xr] <= slopes[x][xb]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) rcount++;
            }

            result = Math.max(lcount + rcount, result);
        }
        System.out.println(result);
    }
}