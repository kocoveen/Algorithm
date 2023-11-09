import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] S;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        S = new int[L + 2];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= L; i++) {
            S[i] = Integer.parseInt(split[i - 1]);
        }
        int n = Integer.parseInt(br.readLine());

        S[0] = 0;
        S[S.length - 1] = 1001;
        Arrays.sort(S);

        for (int k = 0; k < S.length; k++) {
            if (S[k] < n && n < S[k + 1]) {
                int st = S[k] + 1;
                int en = S[k + 1] - 1;

                for (int i = st; i <= n; i++) {
                    for (int j = n; j <= en; j++) {
                        if (i == j) continue;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
