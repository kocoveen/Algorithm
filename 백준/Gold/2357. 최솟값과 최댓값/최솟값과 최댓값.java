import java.util.function.BiFunction;

public class Main {

    static int n, m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = readInt(); m = readInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = readInt();

        SegmentTree minTree = new SegmentTree(nums, Math::min, Integer.MAX_VALUE);
        SegmentTree maxTree = new SegmentTree(nums, Math::max, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            int a = readInt(); int b = readInt();
            sb.append(minTree.query(a - 1, b - 1)).append(" ")
                .append(maxTree.query(a - 1, b - 1)).append("\n");
        }
        System.out.print(sb);
    }

    static class SegmentTree {
        private int[] tree;
        private int size;
        private BiFunction<Integer, Integer, Integer> op;
        private int identity;

        public SegmentTree(int[] arr, BiFunction<Integer, Integer, Integer> op, int identity) {
            this.op = op;
            this.size = arr.length;
            this.identity = identity;

            int height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
            tree = new int[1 << (height + 1)];
            build(arr, 0, 0, size - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = op.apply(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public int query(int l, int r) {
            return query(0, 0, size - 1, l, r);
        }

        private int query(int node, int start, int end, int l, int r) {
            if (l > end || r < start) return identity;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return op.apply(query(2 * node + 1, start, mid, l, r), query(2 * node + 2, mid + 1, end, l, r));
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