
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static class Node {
        private final String value;
        Node left, right;

        public Node(String value) {
            this.value = value;
        }
    }

    static Map<String, Node> nodes = new HashMap<>();
    static String[] line;

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
    
        line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);

        for (int i = 0; i < N; i++) {
            String value = String.valueOf((char) (i + 'A'));
            nodes.put(value, new Node(value));
        }

        for (int i = 0; i < N; i++) {
            line = reader.readLine().split(" ");
            Node node = nodes.get(line[0]);

            if (!line[1].equals(".")) node.left = nodes.get(line[1]);
            if (!line[2].equals(".")) node.right = nodes.get(line[2]);
        }

        preorder(nodes.get("A"));
        System.out.println();
        inorder(nodes.get("A"));
        System.out.println();
        postorder(nodes.get("A"));
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }


    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}