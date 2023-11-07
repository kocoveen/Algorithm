import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] split = br.readLine().split(" ");
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int r1 = Integer.parseInt(split[2]);
            int x2 = Integer.parseInt(split[3]);
            int y2 = Integer.parseInt(split[4]);
            int r2 = Integer.parseInt(split[5]);

            int r_sum_2 = (r1 + r2) * (r1 + r2);
            int r_diff_2 = (r1 - r2) * (r1 - r2);
            int d_2 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

            // 두 점에서 만날 때 -> |r1 + r2| > d > |r1 - r2|
            // 한 점에서 만날 때 -> |r1 + r2| = d OR |r1 - r2| = d (d != 0)
            // 만나지 않을 때 -> |r1 + r2| < d OR d < |r1 - r2|
            // 무수히 많은 점에서 만날 때 -> d = 0 AND |r1 - r2| == 0

            if (r_sum_2 > d_2 && d_2 > r_diff_2) {
                System.out.println(2);
            } else if (d_2 != 0 && (r_sum_2 == d_2 || d_2 == r_diff_2)) {
                System.out.println(1);
            } else if (r_sum_2 < d_2 || d_2 < r_diff_2) {
                System.out.println(0);
            } else if (d_2 == 0 && r_diff_2 == 0) {
                System.out.println(-1);
            }
        }
    }
}