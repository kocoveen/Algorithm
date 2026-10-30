import java.util.*;

class Solution {
    int[][] tree;
    List<int[]> typeActions = new ArrayList<>();
    int[] types;
    int max = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
        // 1. 노드 번호를 0-indexed로 보정
        infection = infection - 1;
        
        tree = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int t = edge[2];
            tree[u][v] = t;
            tree[v][u] = t;
        }

        // 2. 백트래킹으로 길이 k의 모든 타입 조합(중복 순열) 생성
        types = new int[k];
        generateActions(0, k);

        // 3. 각 액션 순서 시나리오마다 시뮬레이션 수행
        for (int[] actions : typeActions) {
            boolean[] visited = new boolean[n];
            List<Integer> infectedNodes = new ArrayList<>();
            
            // 최초 감염자 설정
            visited[infection] = true;
            infectedNodes.add(infection);

            // 각 시간(스텝)마다 선택된 타입의 간선을 타고 확산 (Wave 방식)
            for (int step = 0; step < k; step++) {
                int currentType = actions[step];
                Queue<Integer> q = new ArrayDeque<>(infectedNodes);

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int next = 0; next < n; next++) {
                        // 현재 스텝의 타입과 일치하는 간선이고, 아직 방문하지 않았다면 확산
                        if (tree[curr][next] == currentType && !visited[next]) {
                            visited[next] = true;
                            infectedNodes.add(next);
                            q.add(next); // 새로 감염된 노드에서 연속 확산 가능
                        }
                    }
                }
            }

            // 이번 시나리오에서 감염된 총 노드 수 계산 (시작 노드 포함)
            max = Math.max(max, infectedNodes.size());
        }

        return max;
    }

    // 올바른 백트래킹 구현 (0부터 k-1까지 안전하게 채움)
    private void generateActions(int depth, int k) {
        if (depth == k) {
            typeActions.add(types.clone());
            return;
        }

        for (int i = 1; i <= 3; i++) {
            types[depth] = i;
            generateActions(depth + 1, k);
        }
    }
}
