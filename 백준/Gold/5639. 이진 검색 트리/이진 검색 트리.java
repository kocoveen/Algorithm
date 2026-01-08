
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    static class Node {
        private int value;
        private Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (this.value > value) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String value;
        while ((value = br.readLine()) != null) {
            root.insert(Integer.parseInt(value));
        }
        postorder(root);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }
}