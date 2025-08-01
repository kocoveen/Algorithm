import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static char[][] A;
    static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        // 입력 받기
        n = Integer.parseInt(NM[0]); m = Integer.parseInt(NM[1]);
        A = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = line.charAt(j);
            }
        }

        // 초기위치 (r0, c0), 변위 (dr, dc)
        for (int r0 = 0; r0 < n; r0++) {
            for (int c0 = 0; c0 < m; c0++) {

                for (int dr = -n + 1; dr < n; dr++) {
                    for (int dc = -m + 1; dc < m; dc++) {

                        int r = r0;
                        int c = c0;
                        int num = 0;
                        
                        // 바운더리를 넘어가기 전까지만 계산.
                        while (r < n && c < m && r >= 0 && c >= 0) {
                            num += A[r][c] - '0';
                            int sqrtInt = (int) Math.sqrt(num);
                            if ( sqrtInt * sqrtInt == num ) result = Math.max(result, num);

                            if (dr == 0 && dc == 0) break; // 0, 0 이면 10 곱하기 전 한번만 계산

                            num *= 10;
                            // 등차 더하기
                            r += dr;
                            c += dc;
                        }

                    }
                }
            }
        }
        System.out.println(result);
    }
}