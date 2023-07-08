import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int k = Integer.parseInt(l[1]);

        l = br.readLine().split(" ");
        int[] A = new int[n];
        int[] C = new int[100_001];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(l[i]);

        int max = 0;
        int en = -1;
        for (int st = 0; st < n; st++) {
            while (en < n - 1 && C[A[en + 1]] + 1 <= k) {
                C[A[en + 1]]++;
                en++;
            }
            max = Math.max(max, en - st + 1);
            C[A[st]]--;
        }
        System.out.println(max);
    }
}