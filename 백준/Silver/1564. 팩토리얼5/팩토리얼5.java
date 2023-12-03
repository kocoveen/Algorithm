import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
            while (ans % 10 == 0) {
                ans /= 10;
            }
            ans %= 1000000_000000L;
        }
        String str = String.valueOf(ans);
        System.out.print(str.substring(str.length() - 5));
    }
}