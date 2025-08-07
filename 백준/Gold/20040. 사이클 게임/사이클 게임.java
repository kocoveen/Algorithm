public class Main {

    static int n, m;
    public static void main(String[] args) throws Exception {
        n = readInt(); m = readInt();

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            if (!uf.isConnected(a, b))  {
                uf.union(a, b);
                continue;
            }
            System.out.println(i+1);
            return;
        }
        System.out.println(0);
    }

    static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            parent[px] = py;
        }
    }

    static int readInt() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}