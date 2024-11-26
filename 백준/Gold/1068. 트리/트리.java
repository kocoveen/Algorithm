import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static Set<Integer>[] tree;
    private static int[] parents;
    private static int N, D, R, C;

    public static void main(String[] args) throws IOException {
        N = read();
        parents = new int[N];
        for (int i = 0; i < N; i++) parents[i] = read();
        D = read();

        tree = new HashSet[N];
        for (int i = 0; i < N; i++) tree[i] = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (parents[i] < 0) R = i;
            else tree[parents[i]].add(i);
        }

        tree[D].clear();
        if (parents[D] >= 0) tree[parents[D]].remove(D);

        // BFS로 찾기
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(R);
        while (!deque.isEmpty()) {
            int i = deque.poll();
            if (i != D && tree[i].isEmpty()) C++;
            deque.addAll(tree[i]);
        }
        System.out.println(C);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}