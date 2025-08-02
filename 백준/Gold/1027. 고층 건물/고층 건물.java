import java.util.Scanner;

public class Main {

    static int n;
    static int[] buildings;
    static int[] counts;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        String[] tmp = sc.nextLine().split(" ");
        buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(tmp[i]);
        }

        counts = new int[n];

        for (int i = 0; i < n; i++) {
            double maxSlope = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);
                
                // 지금까지 가장 큰 기울기보다 크면, 건물이 보임.
                if (slope > maxSlope) {
                    maxSlope = slope;
                    counts[i]++; counts[j]++; // building[i]가 보이면, building[j]도 보임.
                }
            }
        }

        for (int count : counts) {
            result = Math.max(result, count);
        }
        System.out.println(result);
    }
}