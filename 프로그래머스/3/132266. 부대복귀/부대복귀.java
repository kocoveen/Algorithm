import java.util.*;

class Solution {
    
    public static final int INF = 100001;
    
    public ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(new Node(road[1], 1));
            graph.get(road[1]).add(new Node(road[0], 1));
        }
        
        int[] dist = bfs(n, destination);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dist[sources[i]] != INF ? dist[sources[i]] : -1;
        }
        
        return answer;
    }
    
    //다익스트라 방식 (힙 사용)
    public int[] dijkstra(int n, int d) {
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        dist[d] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        
        pq.offer(new Node(d, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.idx] < cur.cost) {
                continue;
            }
            
            for (Node nxt : graph.get(cur.idx)) {
                if (dist[nxt.idx] > cur.cost + nxt.cost) {
                    dist[nxt.idx] = cur.cost + nxt.cost;
                    pq.offer(new Node(nxt.idx, dist[nxt.idx]));
                }
            }
        }
        return dist;
    }
    
    //BFS 방식
    public int[] bfs(int n, int d) {
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        dist[d] = 0;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(d, 0));
        visit[d] = true;
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            for (Node nxt : graph.get(cur.idx)) {
                if (visit[nxt.idx]) continue;
                visit[nxt.idx] = true;
                q.offer(new Node(nxt.idx, cur.cost + 1));
                dist[nxt.idx] = cur.cost + 1;
            }
        }
        return dist;
    }
    
    public class Node {
        int idx;
        int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}