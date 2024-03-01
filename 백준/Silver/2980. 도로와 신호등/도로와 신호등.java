public class Main {

    static int n, l, cur, t;
    static int[][] info;
    static boolean[] road;

    public static void main(String[] args) throws Exception {
        n = read(); l = read();
        info = new int[n][3];
        for (int i = 0; i < n; i++) {
            info[i][0] = read(); // 신호등 위치
            info[i][1] = read(); // R 지속시간
            info[i][2] = info[i][1] + read(); // 전체 지속시간
        }
        road = new boolean[l + 1];

        while (cur < l) {
            t++;
            lightChange(cur);
            if (!road[cur]) cur++;
        }
        System.out.println(t + 1);
    }

    private static void lightChange(int loc) {
        for (int[] trafficLight : info) {
            if (trafficLight[0] < loc) continue;
            road[trafficLight[0]] = t % trafficLight[2] < trafficLight[1];
        }
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}