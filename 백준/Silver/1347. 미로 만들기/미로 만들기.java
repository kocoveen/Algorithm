import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int dir = 0; //0: 남쪽, 1: 동쪽, 2: 북쪽, 3: 서쪽
        int curR = 50;
        int curC = 50;

        char[][] map = new char[105][105];
        IntStream.range(0, map.length).forEach(i -> Arrays.fill(map[i], '#'));
        map[curR][curC] = '.';
        int[] info = {curR, curC, curR, curC}; // {minR, minC, maxR, maxC}

        for (int i = 0; i < n; i++) {
            switch (line.charAt(i)) {
                case 'L': { dir = (dir + 1) % 4; break; }
                case 'R': { dir = (dir + 3) % 4; break; }
                case 'F': { curR += dr[dir]; curC += dc[dir]; }
            }
            map[curR][curC] = '.';

            info[0] = Math.min(info[0], curR);
            info[1] = Math.min(info[1], curC);
            info[2] = Math.max(info[2], curR);
            info[3] = Math.max(info[3], curC);
        }

        IntStream.rangeClosed(info[0], info[2])
                .forEach(i -> {
                        IntStream.rangeClosed(info[1], info[3])
                                .forEach(j -> sb.append(map[i][j]));
                        sb.append('\n');
                    }
                );
        System.out.println(sb);
    }
}