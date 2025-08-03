public class Main {

    static int n, q;
    static long[] num;
    static int[][] turns;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        // 입력받기
        n = read();
        q = read();

        num = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = read();
        }

        turns = new int[q][4];
        for (int i = 0; i < q; i++) {
            turns[i][0] = read(); // x
            turns[i][1] = read(); // y
            turns[i][2] = read(); // a
            turns[i][3] = read(); // b
        }

        // 세그먼트 트리
        SegmentTree st = new SegmentTree(num);

        for (int i = 0; i < q; i++) {
            int l = Math.min(turns[i][0], turns[i][1]);
            int r = Math.max(turns[i][0], turns[i][1]);
            int a = turns[i][2];
            int b = turns[i][3];

            sb.append(st.query(l, r)).append('\n'); // 부분합 구하기
            st.update(a, b); // 갱신
        }
        System.out.print(sb.toString());
    }

    static class SegmentTree {
        long[] tree;
        int treeSize;

        SegmentTree(long[] arr) {
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
            build(arr, 1, 1, n);
        }

        private void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        public long query(int l, int r) {
            return query(1, 1, n, l, r);
        }

        private long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = start + (end - start) / 2;
            return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
        }

        public void update(int idx, long val) {
            update(1, 1, n, idx, val);
        }

        private void update(int node, int start, int end, int idx, long val) {
            if (start == end) tree[node] = val;
            else {
                int mid = start + (end - start) / 2;
                if (idx <= mid) update(2 * node, start, mid, idx, val);
                else update(2 * node + 1, mid + 1, end, idx, val);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}