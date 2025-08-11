import java.util.Arrays;
import java.util.function.BiFunction;

public class Main {

    static int N, M, K, C = 1_000_000_007;
    static long[] nums;
    static StringBuilder sb = new StringBuilder();

    static class SegmentTree {
        long[] tree;
        int treeSize;

        SegmentTree(long[] arr) {
            int h = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
            treeSize = 1 << (h + 1);
            tree = new long[treeSize];
            build(arr, 0, 0, N-1);
        }

        private void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = (tree[2 * node + 1] % C * tree[2 * node + 2] % C) % C;
        }

        public long query(int l, int r) {
            return query(0, 0, N-1, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 1;
            if (l <= start && end <= r) return tree[node];
            int mid = start + (end - start) / 2;
            return (
                query(2 * node + 1, start, mid, l, r) % C *
                query(2 * node + 2, mid + 1, end, l, r) % C
            ) % C;
        }

        public void update(int idx, long val) {
            update(0, 0, N-1, idx, val);
        }

        private void update(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) update(2 * node + 1, start, mid, idx, val);
            else update(2 * node + 2, mid + 1, end, idx, val);
            tree[node] = (tree[2 * node + 1] % C * tree[2 * node + 2] % C) % C;
        }
    }

    public static void main(String[] args) throws Exception {
        N = readInt();
        M = readInt();
        K = readInt();
        nums = new long[N];
        for (int i = 0; i < N; i++) nums[i] = readInt();

        SegmentTree st = new SegmentTree(nums);

        for (int i = 0; i < M + K; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            if (a == 1) st.update(b-1, c);
            else sb.append(st.query(b-1, c-1)).append("\n");
        }
        System.out.print(sb);
    }

    static int readInt() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}