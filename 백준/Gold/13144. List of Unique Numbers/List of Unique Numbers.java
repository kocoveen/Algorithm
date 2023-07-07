import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        l = br.readLine().split(" ");
        int[] A = new int[n];
        boolean[] C = new boolean[100_001];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(l[i]);

        long cnt = 0;
        C[A[0]] = true;
        int en = 0;
        for (int st = 0; st < n; st++) {
            while (en < n - 1 && !C[A[en + 1]]) {
                en++;
                C[A[en]] = true;
            }
            cnt += (en - st + 1);
            C[A[st]] = false;
        }
        System.out.println(cnt);
    }
}