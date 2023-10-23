import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][2];

        while (n-- > 0) {
            String[] split = br.readLine().split(" ");
            int p = split[0].charAt(0) - 'A';

            if (split[1].equals(".")) {
                graph[p][0] = -1;
            } else {
                graph[p][0] = split[1].charAt(0) - 'A';
            }

            if (split[2].equals(".")) {
                graph[p][1] = -1;
            } else {
                graph[p][1] = split[2].charAt(0) - 'A';
            }

        }

        preorder(0); sb.append("\n");
        inorder(0); sb.append("\n");
        postorder(0); sb.append("\n");
        System.out.print(sb);
    }

    private static void preorder(int root) {
        if (root == -1) {
            return;
        }
        sb.append((char) (root + 'A'));
        preorder(graph[root][0]);
        preorder(graph[root][1]);
    }

    private static void inorder(int root) {
        if (root == -1) {
            return;
        }
        inorder(graph[root][0]);
        sb.append((char) (root + 'A'));
        inorder(graph[root][1]);
    }

    private static void postorder(int root) {
        if (root == -1) {
            return;
        }
        postorder(graph[root][0]);
        postorder(graph[root][1]);
        sb.append((char) (root + 'A'));
    }
}