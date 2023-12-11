import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        int[] boxes = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        int len = 1;
        for (int i = 1; i <= n; i++) {
            int index = lowerBound(dp, len, boxes[i]);
            if (index == len) {
                len++;
            }
            dp[index] = boxes[i];
        }

        System.out.println(len-1);
    }

    private static int lowerBound(int[] arr, int len, int target) {
        int l = 1, r = len, m;
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}