import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int num) {
            if (num < this.num) {
                if (left == null) {
                    left = new Node(num);
                } else {
                    left.insert(num);
                }
            } else {
                if (right == null) {
                    right = new Node(num);
                } else {
                    right.insert(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while ((input = br.readLine()) != null) {
            root.insert(Integer.parseInt(input));
        }
        
        
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}