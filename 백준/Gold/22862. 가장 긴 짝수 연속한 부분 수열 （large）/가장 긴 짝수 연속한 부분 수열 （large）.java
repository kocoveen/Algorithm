import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int k = Integer.parseInt(l[1]);
        l = br.readLine().split(" ");
        int[] S = new int[n];
        for (int i = 0; i < n; i++) S[i] = Integer.parseInt(l[i]);

        int max = 0;
        int oddC = 0;
        int en = -1;
        for (int st = 0; st < n; st++) {

            while (en < n - 1) {
                int tmp = S[en + 1] % 2 == 1 ? 1 : 0;
                if (oddC + tmp > k) break;
                oddC += tmp;
                en++;
            }
            max = Math.max(max, en - st + 1 - oddC);

            if (S[st] % 2 == 1) oddC--;
        }
        System.out.println(max);
    }
}