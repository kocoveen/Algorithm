import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] oldMat, newMat;
    static int R, C;
    static String[] tokens;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tokens = br.readLine().split(" ");
        R = Integer.parseInt(tokens[0]);
        C = Integer.parseInt(tokens[1]);

        oldMat = new int[R][C];
        newMat = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                oldMat[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                newMat[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = 0;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                if (oldMat[i][j] == newMat[i][j]) continue;

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        oldMat[i + r][j + c] = oldMat[i + r][j + c] == 1 ? 0 : 1;
                    }
                }
                answer++;

            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (oldMat[i][j] != newMat[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);

    }
}