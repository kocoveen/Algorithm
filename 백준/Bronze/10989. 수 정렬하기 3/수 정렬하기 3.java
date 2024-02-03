public class Main {

    static int n, mx;
    static int[] cnt = new int[10_000_001];

    public static void main(String[] args) throws Exception {
        n = read();
        for (int i = 0; i < n; i++) {
            int k = read();
            cnt[k]++;
            mx = Math.max(mx, k);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= mx; i++) {
            while (cnt[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}