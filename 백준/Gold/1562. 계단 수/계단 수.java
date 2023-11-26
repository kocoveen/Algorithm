import java.io.*;

public class Main {

    static final int C = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[100][10][1<<10];

        for (int c = 1; c < 10; c++) {
            dp[0][c][1<<c] = 1;
        }

        // 구하고자 하는 수 = a
        // r = a의 자리수, c = a의 맨 왼쪽의 숫자
        // k = k를 이진수로 만들어 나온 비트들은 a에 비트의 각 자리의 숫자가 포함되어 있다는 것을 의미
        // bit = c를 포함한 k
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < 10; c++) {
                for (int k = 0; k < 1 << 10; k++) { // 11 0000 0000 -> (9, 8) 존재
                    int bit = k | (1 << c);
                    if (c == 0) {
                        dp[r][c][bit] = (dp[r][c][bit] % C + dp[r-1][c+1][k] % C) % C;
                    } else if (c < 9) {
                        dp[r][c][bit] = (dp[r][c][bit] % C + dp[r-1][c-1][k] % C + dp[r-1][c+1][k] % C) % C;
                    } else {
                        dp[r][c][bit] = (dp[r][c][bit] % C + dp[r-1][c-1][k] % C) % C;
                    }
                }
            }
        }

        int sum = 0;
        for (int c = 0; c <= 9; c++) {
            sum = (sum % C + dp[n - 1][c][1023] % C) % C;
        }
        System.out.println(sum);
    }
}