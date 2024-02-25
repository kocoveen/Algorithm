public class Main {

    static int n, s, cnt;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read(); s = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();

        subsequenceSum(0, 0);
        if (s == 0) cnt--;
        System.out.println(cnt);
    }

    private static void subsequenceSum(int depth, int sum) {
        if (depth == n) {
            if (sum == s) cnt++;
            return;
        }

        subsequenceSum(depth + 1, arr[depth] + sum);
        subsequenceSum(depth + 1, sum);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}