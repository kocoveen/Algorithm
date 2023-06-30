import java.io.*;
import java.util.Arrays;

import static java.lang.Math.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(l[i]);

        Arrays.sort(arr);

        long cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = arr[i] + arr[j];
                cnt += diff(arr, j + 1, arr.length - 1, -target);
            }
        }
        System.out.println(cnt);
    }

    private static int diff(int[] arr, int st, int en, int target) {
        return upperBound(arr, st, en, target) - lowerBound(arr, st, en, target) + 1;
    }

    private static int lowerBound(int[] arr, int st, int en, int target) {
        int l = st, r = en + 1, m = (l + r) / 2;
        while (l < r) {
            if (arr[m] < target) l = m + 1;
            else if (arr[m] >= target) r = m;
            m = (l + r) / 2;
        }
        return m;
    }

    private static int upperBound(int[] arr, int st, int en, int target) {
        int l = st, r = en + 1, m = (l + r) / 2;
        while (l < r) {
            if (arr[m] <= target) l = m + 1;
            else if (arr[m] > target) r = m;
            m = (l + r) / 2;
        }
        return m - 1;
    }
}