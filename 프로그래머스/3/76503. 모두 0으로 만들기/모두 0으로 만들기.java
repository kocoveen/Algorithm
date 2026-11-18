import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int len = a.length;
        long[] longA = new long[len];
        long sum = 0;
        
        for (int i = 0; i < len; i++) {
            longA[i] = a[i];
            sum += a[i];
        }
        if (sum != 0) return -1;

        List<Integer>[] graph = new ArrayList[len];
        int[] indegree = new int[len]; // 각 노드에 연결된 간선 수
        for (int i = 0; i < len; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[len];

        // 간선 수가 1이면 리프노드
        for (int i = 0; i < len; i++) {
            if (indegree[i] == 1) q.offer(i);
        }

        long answer = 0;
        while (!q.isEmpty()) {
            int child = q.poll();
            visited[child] = true; 
            
            for (int parent : graph[child]) {
                if (visited[parent]) continue;

                longA[parent] += longA[child]; // 부모에 자신의 가중치를 넘김
                answer += Math.abs(longA[child]); // 넘긴 횟수 추가
                longA[child] = 0;

                indegree[parent]--; // 간선 수 줄이기
                
                // 부모도 남은 간선이 1개가 되면 새로운 리프 노드가 되어 큐에 들어감
                if (indegree[parent] == 1) {
                    q.offer(parent);
                }
            }
        }

        return answer;
    }
}