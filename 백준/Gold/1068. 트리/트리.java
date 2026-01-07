import java.util.ArrayList;
import java.util.List;

public class Main {
    
    static List<List<Integer>> graph;
    static int deleted;

    public static void main(String[] args) throws Exception {
        int N = read();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        int root = 0;
        for (int i = 0; i < N; i++) {
            int node = read();
            if (node == -1) {
                root = i;
            } else {
                graph.get(node).add(i);
            }
        }
        deleted = read();
        li: 
        for (List<Integer> list : graph) {
            for (int elem : list) {
                if (elem == deleted) {
                    list.remove(Integer.valueOf(deleted));
                    break li;
                } 
            }
        }

        System.out.println(traversal(root));
    }

    static int traversal(int node) {
        if (node == deleted) { 
            return 0;
        }

        if (graph.get(node).isEmpty()) {
            return 1;
        }

        int sum = 0;
        for (int elem : graph.get(node)) {
            sum += traversal(elem);
        }
        return sum;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n+1 : n;
    }
}