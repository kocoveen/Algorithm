import java.util.*;

import static java.lang.Math.*;

public class Main {

    static int w, h, n;
    static int[][] info;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt(); h = sc.nextInt();
        n = sc.nextInt();
        info = new int[n + 1][2];
        for (int i = n; i >= 0; i--) {
            int dir = sc.nextInt(); // 1: 북, 2: 남, 3: 서, 4: 동
            int dist = sc.nextInt(); // 왼쪽 or 위쪽 경계로부터의 거리

            switch (dir) {
                case 1: {
                    info[i][0] = 0;
                    info[i][1] = dist;
                    break;
                }
                case 2: {
                    info[i][0] = h;
                    info[i][1] = dist;
                    break;
                }

                case 3: {
                    info[i][0] = dist;
                    info[i][1] = 0;
                    break;
                }

                case 4: {
                    info[i][0] = dist;
                    info[i][1] = w;
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += getMinDistance(i);
        }
        System.out.println(sum);
    }

    private static int getMinDistance(int t) {
        int manDist = abs(info[0][0] - info[t][0]) + abs(info[0][1] - info[t][1]);
        if (abs(info[0][0] - info[t][0]) == h) {
            manDist += 2 * min(min(info[0][1], info[t][1]), min(w - info[0][1], w - info[t][1]));
        } else if (abs(info[0][1] - info[t][1]) == w) {
            manDist += 2 * min(min(info[0][0], info[t][0]), min(h - info[0][0], h - info[t][0]));
        }
        return manDist;
    }
}