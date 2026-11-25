import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] dice = new long[6];

        for (int i = 0; i < 6; i++) {
            dice[i] = sc.nextLong();
        }

        // n이 1일때
        if (n == 1) {
            int idx = -1;
            int mx = 0;
            for (int i = 0; i < 6; i++) {
                if (mx < dice[i]) {
                    mx = (int) dice[i];
                    idx = i;
                }
            }

            int sum = 0;
            for (int i = 0; i < 6; i++) {
                if (i == idx) continue;
                sum += dice[i];
            }
            System.out.println(sum);
            return;
        }

        // 1. 3면이 보이는 경우의 최솟값 (마주 보는 면 중 작은 값들의 합)
        // 4개
        long a = Math.min(dice[0], dice[5])
               + Math.min(dice[1], dice[4])
               + Math.min(dice[2], dice[3]);

        // 2. 2면이 보이는 경우의 최솟값 (마주 보지 않는 두 면의 합 중 최소)
        // (2 * n - 3) * 4 개
        long b = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue; // 마주 보는 면 제외
                b = Math.min(b, dice[i] + dice[j]);
            }
        }

        // 3. 1면만 보이는 경우는 가장 최솟값 (주사위 면의 최솟값)
        // (n - 2) * (n - 2) + (n - 2) * (n - 1) * 4 개
        long c = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (c > dice[i]) {
                c = dice[i];
            }
        }

        long answer = a * 4 + (b * (2 * n - 3) * 4) + (c * ((n - 2) * (n - 2) + (n - 2) * (n - 1) * 4));
        System.out.println(answer);
    }
}