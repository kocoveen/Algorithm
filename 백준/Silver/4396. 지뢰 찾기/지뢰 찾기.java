import java.util.Scanner;

public class Main {

    static int N;
    static char[][] mineMap;
    static char[][] openMap;
    static char[][] map;

    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        mineMap = new char[N][N];
        openMap = new char[N][N];
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                mineMap[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                openMap[i][j] = s.charAt(j);
            }
        }

        // 근처 지뢰개수 찾기
        boolean isFail = false;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 열린 칸
                if (openMap[r][c] == 'x') {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (mineMap[nr][nc] == '*') count++;
                    }
                    map[r][c] = (char) (count + '0');

                    // 열린 칸 중 지뢰가 있으면, 실패
                    if (isFail) continue;
                    if (mineMap[r][c] == '*') {
                        isFail = true;
                    }   
                } else {
                    map[r][c] = '.';
                }
            }
        }
        
        // 실패했다면, 지뢰로 변경
        if (isFail) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (mineMap[r][c] == '*') {
                        map[r][c] = '*';
                    }
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}