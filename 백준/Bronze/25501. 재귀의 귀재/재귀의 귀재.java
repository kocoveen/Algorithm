import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            isPalindrome(S, 0);
        }
    }

    private static int isPalindrome(String S, int count) {
        return recursion(S, 0, S.length()-1, count);
    }

    private static int recursion(String S, int l, int r, int count) {
        count++;
        if (l >= r) {
            System.out.printf("%d %d\n", 1, count);
            return 1;
        }
        if (!S.substring(l, l+1).equals(S.substring(r, r+1))) {
            System.out.printf("%d %d\n", 0, count);
            return 0;
        }
        return recursion(S, l+1, r-1, count);
    }
}