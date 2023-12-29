public class Main {

    static int n, max, max_idx = -1, len = 1;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        max = n;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            if (n == arr[i]) {
                max_idx = i;
            }
        }
        
        for (int i = max_idx; i >= 0; i--) {
            if (arr[i] == max - 1) {
                max--;
                len++;
            }
        }
        System.out.println(n - len);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}