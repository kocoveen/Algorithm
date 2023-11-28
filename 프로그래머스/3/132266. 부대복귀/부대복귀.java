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
        
        int[] dist = dijkstra(sources, n, destination);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dist[sources[i]] != INF ? dist[sources[i]] : -1;
        }
        
        return answer;
    }
    
    public int[] dijkstra(int[] sources, int n, int d) {
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
    
    public class Node {
        int idx;
        int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}