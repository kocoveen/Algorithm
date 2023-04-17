import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][][] board = new char[2][8][8];
        char[][] boardMN = new char[M][N];

        for (int k = 0; k < board.length; k++)
            for (int i = 0; i < board[k].length; i++)
                for (int j = 0; j < board[k][i].length; j++)
                    if ((i + j + k) % 2 == 0)
                        board[k][i][j] = 'B';
                    else
                        board[k][i][j] = 'W';

        String s;
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            for (int j = 0; j < N; j++) {
                boardMN[i][j] = s.charAt(j);
            }
        }

        int min = M*N;
        for (int k = 0; k < 2; k++) {

            for (int y = 0; y <= N - 8; y++) {
                for (int x = 0; x <= M - 8; x++) {

                    int cnt = 0;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (board[k][i][j] != boardMN[i+x][j+y])
                                cnt++;
                        }
                    }
                    if (min > cnt)
                        min = cnt;
                }
            }
        }
        bw.write(min + "");

        bw.flush();
        br.close();
        bw.close();
    }
}