import java.util.*;

public class Main {
    static Map<String, Node> nodes = new HashMap<>();
    static class Node {
        String name;
        Node l;
        Node r;

        public Node(String name) {
            this.name = name;
        }

        public void setL(Node node) {
            this.l = node;
        }

        public void setR(Node node) {
            this.r = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = String.valueOf((char) (i + 'A'));
            nodes.put(name, new Node(name));
        }

        while (n-- > 0) {
            String i = sc.next();
            String l = sc.next();
            String r = sc.next();

            Node p = nodes.get(i);
            if (!l.equals(".")) {
                p.setL(nodes.get(l));
            }
            if (!r.equals(".")) {
                p.setR(nodes.get(r));
            }
        }

        preorder(nodes.get("A")); System.out.println();
        inorder(nodes.get("A")); System.out.println();
        postorder(nodes.get("A")); System.out.println();
    }

    private static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.name);
        preorder(root.l);
        preorder(root.r);
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.l);
        System.out.print(root.name);
        inorder(root.r);
    }

    private static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.l);
        postorder(root.r);
        System.out.print(root.name);
    }
}