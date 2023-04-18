import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(A, key) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int binarySearch(int[] A, int key) {
        int low = 0, high = A.length-1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] == key)
                return 1;
            else if (A[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }
}