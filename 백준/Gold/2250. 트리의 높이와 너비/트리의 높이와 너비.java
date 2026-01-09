import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    static class Node {
        int x, y;
        int left, right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] nodes;
    static Set<Integer> children = new HashSet<>();
    static TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
    static int N, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        nodes = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            int node = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            children.add(left);
            children.add(right);

            nodes[node] = new Node(left, right);
        }

        // 순회로 각 노드의 x y값 구해 map에 y값을 키로 x값을 밸류로 하는 set에 넣기
        x = 0;

        int root = getRoot();
        preorder(root, 0);

        int maxWidth = 0, heightByMaxWidth = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            // IO.println(entry);
            int left = entry.getValue().first();
            int right = entry.getValue().last();
            int height = entry.getKey();
            int width = right-left;

            if (maxWidth < width) {
                maxWidth = width;
                heightByMaxWidth = height;
            }
        }
        System.out.println("%d %d".formatted(heightByMaxWidth + 1, maxWidth + 1));
    }

    private static void preorder(int node, int y) {
        if (node == -1) { return; }
        preorder(nodes[node].left, y + 1);
        map.computeIfAbsent(y, k -> new TreeSet<>()).add(x++);
        preorder(nodes[node].right, y + 1);
    }

    private static int getRoot() {
        for (int i = 1; i <= N; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}