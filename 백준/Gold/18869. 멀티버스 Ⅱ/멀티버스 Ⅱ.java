import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int m = Integer.parseInt(l[0]);
        int n = Integer.parseInt(l[1]);

        int[][] universes = new int[m][n];
        int[] universe;
        int[] sorted;
        int[] distinct;
        int[] transformed;

        for (int number = 0; number < m; number++) {
            l = br.readLine().split(" ");
            universe = new int[n];
            sorted = new int[n];
            for (int i = 0; i < universe.length; i++)
                universe[i] = sorted[i] = Integer.parseInt(l[i]);

            Arrays.sort(sorted);

            distinct = new int[n]; int idx = 0;
            for (int i = 0; i < sorted.length; i++) {
                if (i == 0 || sorted[i - 1] != sorted[i])
                    distinct[idx++] = sorted[i];
            }

            transformed = new int[n];
            for (int i = 0; i < transformed.length; i++) {
                int index = binarySearch(distinct, universe[i], idx);
                transformed[i] = index;
            }
            universes[number] = transformed;
        }

        int cnt = 0;
        for (int i = 0; i < m - 1; i++)
            for (int j = i + 1; j < m; j++)
                if (isEqual(universes[i], universes[j])) cnt++;
        System.out.println(cnt);
    }

    private static boolean isEqual(int[] univ1, int[] univ2) {
        for (int i = 0; i < univ1.length; i++)
            if (univ1[i] != univ2[i]) return false;
        return true;
    }

    private static int binarySearch(int[] distinct, int target, int length) {
        int left = 0, right = length, mid;
        do {
            mid = (left + right) / 2;
            if (distinct[mid] == target) return mid;
            else if (distinct[mid] < target) left = mid + 1;
            else right = mid;
        } while (left < right);
        return -1;
    }
}