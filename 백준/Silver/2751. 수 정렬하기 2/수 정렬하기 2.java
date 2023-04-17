import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        mergeSort(A);

        for (int i : A) {
            bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int[] sorted;
    private static void mergeSort(int[] A) {
        sorted = new int[A.length];
        mergeSort(A, 0, A.length - 1);
    }

    private static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }
    private static void merge(int[] A, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if(A[i] < A[j])
                sorted[k++] = A[i++];
            else
                sorted[k++] = A[j++];
        }

        if (j <= right)
            for (int l = j; l <= right; l++)
                sorted[k++] = A[l];
        else
            for (int l = i; l <= mid; l++)
                sorted[k++] = A[l];


        for (int l = left; l <= right; l++)
            A[l] = sorted[l];
    }

}