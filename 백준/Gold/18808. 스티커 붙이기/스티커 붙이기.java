import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m, k;
    static Integer r, c;

    static int[][] note = new int[42][42];
    static int[][] paper = new int[12][12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l = br.readLine().split(" ");

        n = Integer.parseInt(l[0]);
        m = Integer.parseInt(l[1]);
        k = Integer.parseInt(l[2]);

        while (k-- > 0) {
            l = br.readLine().split(" ");
            r = Integer.parseInt(l[0]);
            c = Integer.parseInt(l[1]);
            for (int i = 0; i < r; i++) {
                l = br.readLine().split(" ");
                for (int j = 0; j < c; j++)
                    paper[i][j] = Integer.parseInt(l[j]);
            }

            for (int rot = 0; rot < 4; rot++) {
                boolean is_paste = false;
                for (int x = 0; x <= n - r; x++) {
                    if (is_paste) break;
                    for (int y = 0; y <= m - c; y++) {
                        if (pastable(x, y)) {
                            is_paste = true;
                            break;
                        }
                    }
                }
                if (is_paste) break;
                rotate();
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                cnt += note[i][j];
        System.out.println(cnt);
    }

    static void rotate(){
        int[][] tmp = new int[12][12];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                tmp[i][j] = paper[i][j];


        for (int i = 0; i < c; i++)
            for (int j = 0; j < r; j++)
                paper[i][j] = tmp[r - 1 - j][i];

        int t = r;
        r = c;
        c = t;
    }

    static boolean pastable(int x, int y) {
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                if (note[x + i][y + j] == 1 && paper[i][j] == 1)
                    return false;


        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (paper[i][j] == 1)
                    note[x + i][y + j] = 1;
        return true;
    }
}