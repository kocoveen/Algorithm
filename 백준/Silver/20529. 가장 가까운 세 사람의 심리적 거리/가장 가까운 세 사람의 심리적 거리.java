import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] mbtis = {
            "ISTJ", "ISFJ", "INFJ", "INTJ",
            "ISTP", "ISFP", "INFP", "INTP",
            "ESTP", "ESFP", "ENFP", "ENTP",
            "ESTJ", "ESFJ", "ENFJ", "ENTJ"
    };
    static Map<String, Integer> map = new HashMap<>();
    static int[][] distTable = new int[16][16];
    static int mn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] split = br.readLine().split(" ");
            if (n > 33) {
                bw.write("0\n");
                continue;
            }
            mn = 13;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int dist = 0;
                        int a = map.get(split[i]);
                        int b = map.get(split[j]);
                        int c = map.get(split[k]);
                        dist += distTable[a][b];
                        dist += distTable[b][c];
                        dist += distTable[c][a];
                        mn = Math.min(mn, dist);
                    }
                }
            }
            bw.write(mn + "\n");
        }
        bw.flush();
    }

    private static void init() {
        for (int i = 0; i < 16; i++) {
            map.put(mbtis[i], i);
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                distTable[i][j] = getDist(i, j);
            }
        }
    }

    private static int getDist(int i, int j) {
        int dist = 0;
        for (int k = 0; k < 4; k++) {
            if (mbtis[i].charAt(k) != mbtis[j].charAt(k)) {
                dist++;
            }
        }
        return dist;
    }
}