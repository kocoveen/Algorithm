import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        targetCount = K;

        int[] A = new int[N];
        int[] temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        mergeSort(A, 0, A.length - 1, temp);
        System.out.println(-1);
    }
    private static int count = 0;
    private static int targetCount = 0;

    private static void mergeSort(int[] A, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid, temp);
            mergeSort(A, mid + 1, right, temp);
            merge(A, left, mid, right, temp);
        }
    }

    private static void merge(int[] A, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (A[i] < A[j])
                temp[k++] = A[i++];
            else
                temp[k++] = A[j++];
        }
        while (i <= mid)
            temp[k++] = A[i++];
        while (j <= right)
            temp[k++] = A[j++];

        for (int l = left; l <= right; l++) {
            A[l] = temp[l];
            if (++count == targetCount) {
                System.out.println(temp[l]);
                System.exit(0);
            }
        }
    }
}