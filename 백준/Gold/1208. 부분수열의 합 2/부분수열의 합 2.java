public class Main {

    static int n, s;
    static int C = 80_000_001, OS = C / 2;
    static long cnt;
    static int[] arr;
    static int[] subsequenceSumCount = new int[C];

    public static void main(String[] args) throws Exception {
        n = read(); s = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();

        rightPart(n / 2, 0);
        leftPart(0, 0);

        System.out.println(s == 0 ? cnt - 1 : cnt);
    }

    private static void rightPart(int mid, int sum){
        if (mid == n){
            subsequenceSumCount[sum + OS]++;
            return;
        }
        rightPart(mid + 1, sum + arr[mid]);
        rightPart(mid + 1, sum);
    }

    private static void leftPart(int st, int sum){
        if (st == n / 2) {
            cnt += subsequenceSumCount[s - sum + OS];
            return;
        }

        leftPart(st + 1, sum + arr[st]);
        leftPart(st + 1, sum);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}