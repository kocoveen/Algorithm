import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }
        Arrays.sort(A);

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            cnt += binarySearch(A, br.readLine());
        }

        bw.write(cnt + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int binarySearch(String[] A, String key) {
        int low = 0, high = A.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid].equals(key))
                return 1;
            else if (A[mid].compareTo(key) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }
}