import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        for (int t = 1; ; t++) {
            Set<Integer> nodes = new HashSet<>();
            Set<Integer> inDegreeNodes = new HashSet<>();
            int edges = 0;
            boolean isTree = true;

            while (true) {
                int u = read();
                int v = read();

                if (u == -1 && v == -1) return;
                if (u == 0 && v == 0) break;

                nodes.add(u);
                nodes.add(v);
                edges++;
                
                // 들어오는 간선이 이미 있다면 (진입차수 > 1) 트리가 아님
                if (!inDegreeNodes.add(v)) isTree = false;
            }

            // 빈 트리는 트리임
            if (nodes.isEmpty()) {
                System.out.println("Case " + t + " is a tree.");
                continue;
            }

            // 루트가 정확히 1개여야 함 (전체 노드 수 - 들어오는 간선이 있는 노드 수)
            int rootCount = 0;
            for (int node : nodes) {
                if (!inDegreeNodes.contains(node)) rootCount++;
            }

            // 트리 조건: 루트 1개 AND 진입차수 조건 통과 AND 노드수 = 간선수 + 1
            if (isTree && rootCount == 1 && nodes.size() == edges + 1) {
                System.out.println("Case " + t + " is a tree.");
            } else {
                System.out.println("Case " + t + " is not a tree.");
            }
        }
    }

    private static int read() throws Exception {
        int c, n = 0, b = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') { b = -1; c = System.in.read(); }
        for (; c > 32; c = System.in.read()) n = (n << 3) + (n << 1) + (c & 15);
        return n * b;
    }
}