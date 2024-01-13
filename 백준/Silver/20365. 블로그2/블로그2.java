import java.io.*;

public class Main {

    static int mn = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] problem = br.readLine().toCharArray();

        mn = Math.min(mn, getCount(problem, 'R'));
        mn = Math.min(mn, getCount(problem, 'B'));
        System.out.println(mn);
    }

    private static int getCount(char[] problem, char cur) {
        int count = 1;
        int l = 0, r = problem.length - 1;
        while (l < r) {
            while (l < problem.length && cur == problem[l]) l++;
            while (0 <= r && cur == problem[r]) r--;
            if (r < l) break;
            count++;
            if (cur == 'R') cur = 'B';
            else cur = 'R';
        }
        return count;
    }
}