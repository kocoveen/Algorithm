import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] terr;
    static int[] T;
    static int[] instB;
    static int R;
    static int C;
    static int B;
    static int sum;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        terr = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++)
                terr[i][j] = Integer.parseInt(st.nextToken());
        }

        findMinMax(terr);
        T = new int[max - min + 1];
        instB = new int[max - min + 1];

        sum = relaTerrAndSum(terr);
        instant(instB);

        for (int floor = 0; floor < T.length; floor++) {
            if (B + instB[floor] >= 0)
                T[floor] = timeCount(terr, floor);
            else
                T[floor] = Integer.MAX_VALUE;
        }

        int minTime = Integer.MAX_VALUE;
        int floor = 0;
        for (int i = 0; i < T.length; i++) {
            if (minTime >= T[i]) {
                minTime = T[i];
                floor = i;
            }
        }

        sb.append(minTime).append(" ").append(floor + min);
        bw.write(sb + "");
        bw.flush();
    }

    private static int timeCount(int[][] terr, int floor) {
        int time = 0;
        for (int[] line : terr) {
            for (int i : line) {
                int k = floor - i;
                if (k >= 0)
                    time += k;
                else
                    time += ((-k) * 2);
            }
        }
        return time;
    }

    private static void instant(int[] instB) {
        for (int i = 0; i < instB.length; i++)
            instB[i] = sum - i * (R * C);
    }

    private static int relaTerrAndSum(int[][] terr) {
        int sum = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                terr[i][j] = terr[i][j] - min;
                sum += terr[i][j];
            }
        return sum;
    }


    private static void findMinMax(int[][] terr) {
        for (int[] line : terr) {
            for (int i : line) {
                if (min > i)
                    min = i;
                if (max < i)
                    max = i;
            }
        }
    }
}