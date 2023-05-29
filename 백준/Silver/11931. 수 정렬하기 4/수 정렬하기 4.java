import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static StringBuilder sb = new StringBuilder();

    static int[] C;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        C = new int[N];

        for (int i = 0; i < N; i++) C[i] = Integer.parseInt(br.readLine());

        merge_sort(C);

        Arrays.stream(C).forEach(i -> sb.append(i).append('\n'));
        System.out.print(sb);
    }

    private static void merge_sort(int[] arr) {
        sorted = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1);
        sorted = null;
    }

    private static void merge_sort(int[] arr, int st, int en) {
        if (st == en) return;
        int mid = (st + en) / 2;
        merge_sort(arr, st, mid);
        merge_sort(arr, mid + 1, en);
        merge(arr, st, mid, en);
    }

    private static void merge(int[] arr, int st, int mid, int en) {
        int l = st;
        int r = mid + 1;
        int idx = st;

        while (l <= mid && r <= en) {
            if (arr[l] > arr[r]) sorted[idx++] = arr[l++];
            else if (arr[l] < arr[r]) sorted[idx++] = arr[r++];
            else {
                sorted[idx++] = arr[l++];
                sorted[idx++] = arr[r++];
            }
        }

        while (l <= mid) sorted[idx++] = arr[l++];
        while (r <= en) sorted[idx++] = arr[r++];

        if (en + 1 - st >= 0) System.arraycopy(sorted, st, C, st, en + 1 - st);
    }
}