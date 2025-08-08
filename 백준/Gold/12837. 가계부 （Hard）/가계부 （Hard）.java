public class Main {

    static int N, Q;
    static int[] txs;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = readInt(); Q = readInt();
        txs = new int[N + 1];

        SegmentTree st = new SegmentTree(txs);
        while (Q-- > 0) {
            int m = readInt();
            if (m == 1) {
                int p = readInt();
                int x = readInt();
                st.update(p, x);
            } else {
                int p = readInt();
                int q = readInt();
                sb.append(st.query(p, q)).append('\n');
            }
        }
        System.out.print(sb);
    }

    static class SegmentTree {
        long[] tree;
        int size;

        SegmentTree(int[] arr) {
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            size = 1 << (h + 1) + 1;
            tree = new long[size];
        }

        public long query(int l, int r) {
            return query(1, 1, N, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (l > end || r < start) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = start + (end - start) / 2;
            return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
        }

        public void update(int idx, long val) {
            update(1, 1, N, idx, val);
        }

        private void update(int node, int start, int end, int idx, long val) {
            if (start == end) tree[node] += val;
            else {
                int mid = start + (end - start) / 2;
                if (idx <= mid) update(2 * node, start, mid, idx, val);
                else update(2 * node + 1, mid + 1, end, idx, val);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }
    }

    static int readInt() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;

    }
}