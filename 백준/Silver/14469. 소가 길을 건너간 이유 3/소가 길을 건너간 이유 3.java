import java.io.*;
import java.util.Arrays;

public class Main {

    static Integer[][] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        times = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(st[0]);
            times[i][1] = Integer.parseInt(st[1]);
        }
        Arrays.sort(times, (t1, t2) -> t1[0] - t2[0]);

        int time = 0; // 현재시각
        for (int i = 0; i < n; i++) {
            if (time < times[i][0]) {
                time = times[i][0];
            }
            time += times[i][1];
        }
        System.out.println(time);
    }

}