public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = read();
            tmp[i] = 100_001;
        }

        int size = 0;
        for (int i = 0; i < N; i++) {
            int idx = lowerBound(tmp, arr[i]);
            tmp[idx] = arr[i];
            if (size <= idx) size++;
        }
        System.out.println(N - size);
    }

    private static int lowerBound(int[] A, int value) {
        int low = 0, high = A.length, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value <= A[mid]) { high = mid; }
            else { low = mid + 1; }
        }
        return low;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) { n = (n << 3) + (n << 1) + (c & 15); }
        return n;
    }
}