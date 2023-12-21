import java.util.Arrays;

class Solution {

    int[][] result;
    int idx;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }
        Arrays.sort(nodes, (n1, n2) -> {
            if (n1.y != n2.y) return n2.y - n1.y;
            return n1.x - n2.x;
        });

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            root.insertNode(nodes[i]);
        }

        result = new int[2][nodes.length];
        idx = 0;
        root.preorder();
        idx = 0;
        root.postorder();

        return result;
    }

    public class Node {
        int n, x, y;
        Node l, r;

        public Node(int n, int x, int y, Node l, Node r) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.l = l;
            this.r = r;
        }

        public void insertNode(Node child) {
            if (this.x > child.x) {
                if (this.l == null) l = child;
                else l.insertNode(child);
            } else {
                if (this.r == null) r = child;
                else r.insertNode(child);
            }
        }

        public void preorder() {
            result[0][idx++] = n;
            if (l != null) l.preorder();
            if (r != null) r.preorder();
        }

        public void postorder() {
            if (l != null) l.postorder();
            if (r != null) r.postorder();
            result[1][idx++] = n;
        }
    }
}