import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int d = Integer.parseInt(l[1]);
        int k = Integer.parseInt(l[2]);
        int c = Integer.parseInt(l[3]);
        int[] S = new int[n];
        int[] B = new int[d + 1];
        for (int i = 0; i < n; i++) S[i] = Integer.parseInt(br.readLine());

        int max = 0;
        int diffCount = 0;
        int en = -1;
        for (int st = 0; st < n; st++) {
            while (en - st + 1 < k) {
                if (B[S[(en + 1) % n]] == 0) diffCount++;
                B[S[(en + 1) % n]]++;
                en++;
            }

            int tmp = 0;
            if (B[c] == 0) tmp++;
            max = Math.max(max, diffCount + tmp);

            B[S[st]]--;
            if (B[S[st]] == 0) diffCount--;
        }
        System.out.println(max);
    }
}