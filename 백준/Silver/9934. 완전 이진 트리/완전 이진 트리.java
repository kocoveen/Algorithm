public class Main {
    
    static int[] nodes;
    static int index, size, K;

    public static void main(String[] args) throws Exception {
        K = read();

        size = 1 << K;
        nodes = new int[size + 1];

        preorder(0, 1);

        for (int i = 1; i < size; i++) {
            if (i != 1 && Integer.bitCount(i) == 1) {
                System.out.println();
            }
            System.out.print(nodes[i] + " ");
        }
    }

    static void preorder(int depth, int index) throws Exception {
        if (depth == K) {
            return;
        }

        preorder(depth + 1, index << 1);
        nodes[index] = read();
        preorder(depth + 1, (index << 1) + 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}