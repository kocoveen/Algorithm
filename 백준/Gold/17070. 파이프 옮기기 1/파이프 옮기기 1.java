import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1
public class Main {
    private static int n;
    private static int[][] map;

    private static int solution(){
        int answer = 0;

        int[][][] dp = new int[n+1][n+1][3];
        dp[1][2][0] = 1;

        for(int r=1; r<=n; r++){
            for(int c=1; c<=n; c++){
                if(r==1 && c==2){
                    continue;
                }
                // 가로
                dp[r][c][0] = (map[r][c] != 1) ? dp[r][c-1][0] + dp[r][c-1][2] : 0;
                // 세로
                dp[r][c][1] = (map[r][c] != 1) ? dp[r-1][c][1] + dp[r-1][c][2] : 0;
                // 대각선
                dp[r][c][2] = (map[r][c] != 1 && map[r][c-1] == 0 && map[r-1][c] == 0) ?
                        dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2] : 0;
            }
        }

        answer = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        return answer;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}