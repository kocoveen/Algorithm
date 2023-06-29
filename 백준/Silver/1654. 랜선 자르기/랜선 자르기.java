import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = br.readLine().split(" ");

        int k = Integer.parseInt(l[0]);
        int n = Integer.parseInt(l[1]);

        int[] arr = new int[k]; int max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch(arr, max, n));

    }

    private static long binarySearch(int[] arr, long max, int target) {
        long left = 0, right = max + 1, mid = (left + right) / 2;
        long key = cnt(arr, mid);
        while (left < right) {
            if (key >= target) left = mid + 1;
            else if (target > key) right = mid;
            mid = (left + right) / 2;
            key = cnt(arr, mid);
        }
        return mid - 1;
    }

    private static long cnt(int[] arr, long val) {
        int sum = 0;
        for (int j : arr)
            sum += j / val;
        return sum;
    }
}