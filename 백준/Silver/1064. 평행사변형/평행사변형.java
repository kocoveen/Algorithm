import java.io.*;

import static java.lang.Math.*;

public class Main {

    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int x1 = Integer.parseInt(split[0]);
        int y1 = Integer.parseInt(split[1]);
        int x2 = Integer.parseInt(split[2]);
        int y2 = Integer.parseInt(split[3]);
        int x3 = Integer.parseInt(split[4]);
        int y3 = Integer.parseInt(split[5]);

        // 세 점으로 삼각형을 만든다면, 각 선분의 길이 계산하기
        double a = getDistance(x1, y1, x2, y2); // d1 <-> d2
        double b = getDistance(x2, y2, x3, y3); // d2 <-> d3
        double c = getDistance(x3, y3, x1, y1); // d3 <-> d1

        // 세 점 중 중복되지 않은 두 점을 두 번 골라 두 기울기가 같으면, 세 점은 일직선상에 있다.
        if (check(x1, y1, x2, y2, x3, y3)) {
            System.out.println(-1f);
        } else {
            double mx = max(a + b, max(b + c, c + a)) * 2;
            double mn = min(a + b, min(b + c, c + a)) * 2;
            System.out.print(mx - mn);
        }
    }

    private static boolean check(int x1, int y1, int x2, int y2, int x3, int y3) {
        double tan1, tan2;
        if (x1 == x2) {
            tan1 = INF;
        } else {
            tan1 = (double) (y1 - y2) / (x1 - x2);
        }

        if (x2 == x3) {
            tan2 = INF;
        } else {
            tan2 = (double) (y2 - y3) / (x2 - x3);
        }

        return tan1 == tan2;
    }

    static double getDistance(int x1, int y1, int x2, int y2) {
        return sqrt((pow((x2 - x1), 2) + pow((y2 - y1), 2)));
    }
}