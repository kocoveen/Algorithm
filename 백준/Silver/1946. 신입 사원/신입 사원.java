import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] applicants = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, (a1, a2) -> {
                return a1[0] - a2[0];
            });

            int count = n;
            int score0 = applicants[0][0];
            int score1 = applicants[0][1];
            for (int i = 1; i < n; i++) {
                //현재 지원자의 (서류, 면접) 순위가 최고 (서류, 면접) 순위보다 낮다면
                if (score0 <= applicants[i][0] && score1 <= applicants[i][1]) {
                    count--;
                } else { //그렇지 않다면, 최고 순위 갱신
                    score0 = Math.min(score0, applicants[i][0]);
                    score1 = Math.min(score1, applicants[i][1]);
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isBetter(int[][] applicants, int i, int j) {
        return applicants[i][0] > applicants[j][0] && applicants[i][1] > applicants[j][1];
    }
}