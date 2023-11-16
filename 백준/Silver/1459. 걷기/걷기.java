import java.io.*;

public class Main {

    static String[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = br.readLine().split(" ");
        // (0, 0) 부터 (x, y) 까지
        long x = Long.parseLong(st[0]); // 도착 x 좌표
        long y = Long.parseLong(st[1]); // 도착 y 좌표
        long w = Long.parseLong(st[2]); // 직선으로 한 블록을 가는 데 걸리는 시간
        long s = Long.parseLong(st[3]); // 대각선으로 가는 데 걸리는 시간

        if (2 * w > s) {
            long tmp1 = Math.min(x, y) * s;
            long tmp2 = Math.abs(y - x);
            long tmp3 = tmp2 % 2 == 1 ? w : 0;

            if (2 * w > 2 * s) {
                System.out.println(tmp1 + tmp2 / 2 * (s * 2) + tmp3);
            } else {
                System.out.println(tmp1 + tmp2 * w);
            }
        } else {
            System.out.println((x + y) * w);
        }

    }
}