import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 퀵정렬 자바 버전
 * pivot = arr[(L + R) / 2];
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1);
        System.out.println(arr[k - 1]);
    }

    private static void quickSort(int[] arr, int l, int r) {
        int p = partition(arr, l, r);
        if (l < p - 1)
            quickSort(arr, l, p - 1);
        if (p < r)
            quickSort(arr, p, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[(l + r) / 2];
        while (l <= r) {
            while (arr[l] < pivot) l++;
            while (arr[r] > pivot) r--;
            if (l <= r) {
                swap (arr, l, r);
                l++;
                r--;
            }
        }
        return l;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}