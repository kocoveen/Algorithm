import java.io.*;

public class Main {
    static String[] l;

    static int N, W, L, T;

    static int[] trucks;
    static int[] bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        W = Integer.parseInt(l[1]);
        L = Integer.parseInt(l[2]);

        l = br.readLine().split(" ");
        trucks = new int[N];
        bridge = new int[W];
        for (int i = 0; i < N; i++) trucks[i] = Integer.parseInt(l[i]);

        T++;
        move();
        bridge[0] = trucks[0];
        int i = 1;
        while (i < N || !clearBridge()) {
            T++;
            move();
            if (i >= N || isOverWeight(trucks[i])) continue;
            bridge[0] = trucks[i++];
        }
        System.out.println(T);
    }


    private static void move() {
        for (int i = W - 1; i > 0; i--) bridge[i] = bridge[i - 1];
        bridge[0] = 0;
    }

    private static boolean clearBridge() {
        for (int i = 0; i < W; i++) if (bridge[i] != 0) return false;
        return true;
    }

    private static boolean isOverWeight(int truck) {
        int sum = 0;
        for (int i = 0; i < W; i++) sum += bridge[i];
        return sum + truck > L;
    }

}