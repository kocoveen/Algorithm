import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String[] split;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            split = br.readLine().split(" ");
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]);
            int y2 = Integer.parseInt(split[3]);

            int n = Integer.parseInt(br.readLine());
            List<Circle> circles = new ArrayList<>();
            while (n-- > 0) {
                split = br.readLine().split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                int r = Integer.parseInt(split[2]);
                circles.add(new Circle(x, y, r));
            }

            int answer = 0;
            for (Circle circle : circles) {
                if ((circle.isInCircle(x1, y1) && !circle.isInCircle(x2, y2)) ||
                    (!circle.isInCircle(x1, y1) && circle.isInCircle(x2, y2))) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static class Circle {
        int x0;
        int y0;
        int r;

        public Circle (int x0, int y0, int r) {
            this.x0 = x0;
            this.y0 = y0;
            this.r = r;
        }

        public boolean isInCircle(int x, int y) {
            return (x0 - x) * (x0 - x) + (y0 - y) * (y0 - y) < r * r;
        }
    }
}