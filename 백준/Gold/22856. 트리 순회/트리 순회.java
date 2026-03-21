import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Node[] nodes;

    static class Node {
        int left = -1;
        int right = -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        nodes = new Node[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            
            nodes[parent].left = left;
            nodes[parent].right = right;
        }

        int lastNode = 1;
        while (nodes[lastNode].right != -1) {
            lastNode = nodes[lastNode].right;
        }

        int edgeToLast = 0;
        int curr = 1;
        while (curr != lastNode) {
            curr = nodes[curr].right;
            edgeToLast++;
        }

        System.out.println(2 * (N-1) - edgeToLast);
    }
}