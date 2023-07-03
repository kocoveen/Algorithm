import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static long[] ans = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int c = Integer.parseInt(l[1]);
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int l = 1, r = A[n - 1] - A[0] + 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (canInstall(A, m) < c) r = m;
            else l = m + 1;
        }
        System.out.println(l - 1);
    }

    // 설치 할 두 집 사이의 거리가 m 일 때, 설치 할 공유기의 수를 구하는 함수
    private static int canInstall(int[] A, int m) {
        int cnt = 1;
        int lastLoc = A[0];

        for (int Loc : A) {
            if (Loc - lastLoc < m) continue;
            cnt++;
            lastLoc = Loc;
        }
        return cnt;
    }
}