public class Main {

    static int n, m, k;
    static long[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = readInt(); m = readInt(); k = readInt();
        nums = new long[n+1];
        for (int i = 1; i <= n; i++) nums[i] = readLong();

        SegmentTree st = new SegmentTree(nums);
        for (int i = 0; i < m + k; i++) {
            int a = readInt();
            int b = readInt();
            if (a == 1) {
                long c = readLong();
                st.update(b, c);
            } else {
                int c = readInt();
                sb.append(st.query(b, c)).append('\n');
            }
        }
        System.out.print(sb);
    }

    static class SegmentTree {
        private long[] tree;
        private int size;

        public SegmentTree(long[] arr) {
            size = n;
            int h = (int) Math.ceil(Math.log(size) / Math.log(2));
            tree = new long[1 << (h + 1)];
            build(arr, 1, 1, size);
        }

        private void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(arr, 2 * node, start, mid);
            build(arr,  2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        public long query(int l, int r) {
            return query(1, 1, size, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (l > end || r < start) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = start + (end - start) / 2;
            return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
        }

        public void update(int idx, long val) {
            update(1, 1, size, idx, val);
        }

        private void update(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) update(2 * node, start, mid, idx, val);
            else update(2 * node + 1, mid + 1, end, idx, val);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    static int readInt() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

    static long readLong() throws Exception {
        long c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}