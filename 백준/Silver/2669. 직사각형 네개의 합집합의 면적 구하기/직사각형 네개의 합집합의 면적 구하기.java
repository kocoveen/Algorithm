import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[101][101];

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());

            fillMap(lbx, lby, rtx, rty);
        }

        int answer = 0;
        for (int[] Is : map) {
            for (int I : Is) {
                answer += I;
            }
        }
        System.out.println(answer);
    }

    private static void fillMap(int lbx, int lby, int rtx, int rty) {
        for (int i = lby; i < rty; i++) {
            for (int j = lbx; j < rtx; j++) {
                map[i][j] = 1;
            }
        }
    }
}