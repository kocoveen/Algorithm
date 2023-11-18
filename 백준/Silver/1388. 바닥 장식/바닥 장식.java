import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static String[] st;
    static char[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '-') {
                    dq.push(j);
                } else {
                    if (!dq.isEmpty()) {
                        dq.clear();
                        answer++;
                    }
                }
            }
            if (!dq.isEmpty()) {
                answer++;
            }
        }

        for (int j = 0; j < m; j++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '|') {
                    dq.push(i);
                } else {
                    if (!dq.isEmpty()) {
                        dq.clear();
                        answer++;
                    }
                }
            }
            if (!dq.isEmpty()) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}