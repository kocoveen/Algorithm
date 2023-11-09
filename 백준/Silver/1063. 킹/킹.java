import java.io.*;
import java.util.Arrays;

public class Main {

    static int[][] board = new int[8][8];
    static int[][] dr = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int[] kingLoc = interpret(split[0]);
        int[] stoneLoc = interpret(split[1]);
        int n = Integer.parseInt(split[2]);

        while (n-- > 0) {
            int[] dir = command(br.readLine());

            int[] nxt = {kingLoc[0] + dir[0], kingLoc[1] + dir[1]};
            if (isOverBoundary(nxt)) continue;

            if (nxt[0] == stoneLoc[0] && nxt[1] == stoneLoc[1]) {
                int[] nxtStone = {stoneLoc[0] + dir[0], stoneLoc[1] + dir[1]};
                if (isOverBoundary(nxtStone)) continue;
                stoneLoc = nxtStone;
            }
            kingLoc = nxt;
        }

        System.out.println(interpret(kingLoc));
        System.out.println(interpret(stoneLoc));

    }

    private static boolean isOverBoundary(int[] loc) {
        return loc[0] < 0 || 8 <= loc[0] || loc[1] < 0 || 8 <= loc[1];
    }

    public static int[] command(String dir) {
        switch (dir) {
            case "R" : return dr[0];
            case "L" : return dr[1];
            case "B" : return dr[2];
            case "T" : return dr[3];
            case "RT" : return dr[4];
            case "LT" : return dr[5];
            case "RB" : return dr[6];
            case "LB" : return dr[7];
        }
        return null;
    }

    public static int[] interpret(String loc) {
        int r = 8 - (loc.charAt(1) - '0');
        int c = loc.charAt(0) - 'A';
        return new int[]{r, c};
    }

    public static String interpret(int[] loc) {
        return String.format("%s%s", (char) (loc[1] + 'A'), 8 - loc[0]);
    }
}
