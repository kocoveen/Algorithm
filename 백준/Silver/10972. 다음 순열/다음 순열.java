import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (getNextPermutation(a)) {
            for (int i : a) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(-1);
        }

    }

    private static boolean getNextPermutation(int[] a) {
        // 1. A[i-1] < A[i]를 만족하는 가장 큰 i를 찾는다.
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i--;
        }

        // 첫 번째 순열일 경우
        if (i <= 0) {
            return false;
        }

        // 2. i-1 < j 이면서 A[i-1] < A[j]을 만족하는 가장 큰 j를 찾는다.
        int j = a.length-1;
        while (a[i-1] >= a[j]) {
            j--;
        }

        // 3. A[i-1]과 A[j]를 바꾼다.
        swap(a, i-1, j);

        // 4. A[i]부터 순열을 뒤집는다.
        j = a.length-1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}