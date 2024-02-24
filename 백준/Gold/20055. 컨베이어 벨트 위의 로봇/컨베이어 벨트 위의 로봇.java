public class Main {

    static int n, n2, k, level, zeroCount, st, en;
    static int[] conveyor;
    static boolean[] robot;

    public static void main(String[] args) throws Exception {
        n = read(); k = read();
        n2 = 2 * n;
        conveyor = new int[n << 1];
        robot = new boolean[n];
        for (int i = 0; i < n << 1; i++) {
            conveyor[i] = read();
        }
        level = 0;
        zeroCount = k;
        st = 0;
        en = n - 1;

        while (zeroCount > 0) {
            moveConveyor();
            moveRobots();
            putRobot();
            level++;
        }
        System.out.println(level);
    }

    private static void putRobot() {
        if (conveyor[st] == 0 || robot[0]) return;
        robot[0] = true;

        conveyor[st]--;
        if (conveyor[st] == 0) zeroCount--;
    }

    private static void moveConveyor() {
        en = ((en - 1) + n2) % n2;
        st = ((st - 1) + n2) % n2;

        for (int ri = n - 2; ri >= 0; ri--) {
            boolean tmp = robot[ri + 1];
            robot[ri + 1] = robot[ri];
            robot[ri] =  tmp;
        }
        if (robot[n - 1]) robot[n - 1] = false;
    }

    private static void moveRobots() {
        for (int ri = n - 2; ri >= 0; ri--) {
            if (!robot[ri]) continue;
            int ci = (st + ri + n2) % n2;
            int ci_f = (ci + 1) % n2; //ci 앞에 있는 인덱스
            int ri_f = ri + 1;
            if (robot[ri_f] || conveyor[ci_f] == 0) continue;

            boolean tmp = robot[ri_f];
            robot[ri_f] = robot[ri];
            robot[ri] =  tmp;

            conveyor[ci_f]--;
            if (conveyor[ci_f] == 0) zeroCount--;
        }
        if (robot[n - 1]) robot[n - 1] = false;
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}