import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        
        solve(n, 0);
        
        System.out.println(min + " " + max);
    }

    private static void solve(String n, int count) {
        int currentOdd = countOdd(n);
        int totalOdd = count + currentOdd;

        if (n.length() == 1) {
            min = Math.min(min, totalOdd);
            max = Math.max(max, totalOdd);
            return;
        } else if (n.length() == 2) {
            int sum = (n.charAt(0) - '0') + (n.charAt(1) - '0');
            solve(String.valueOf(sum), totalOdd);
        } else {
            for (int i = 1; i < n.length() - 1; i++) {
                for (int j = i + 1; j < n.length(); j++) {
                    String s1 = n.substring(0, i);
                    String s2 = n.substring(i, j);
                    String s3 = n.substring(j);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    solve(String.valueOf(sum), totalOdd);
                }
            }
        }
    }

    private static int countOdd(String n) {
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if ((n.charAt(i) - '0') % 2 != 0) cnt++;
        }
        return cnt;
    }
}