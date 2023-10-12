import java.util.*;

class Solution {
    
    Map<Integer, Node> nodeMap = new HashMap<>();
    TreeMap<Integer, Set<Integer>> distMap = new TreeMap<>(Collections.reverseOrder());
    
    public int solution(int n, int[][] edges) {
        int answer = 0;
        //--- init ---
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            if (i == 1) {
                node.setDist(0);
                nodeMap.put(i, node);
            }
            nodeMap.put(i, node);
        }
        
        for (int[] edge : edges) {
            nodeMap.get(edge[0]).link(nodeMap.get(edge[1]));
        }
        //-----------
        
        Queue<Node> Q = new LinkedList<>();
        Q.add(nodeMap.get(1));
        nodeMap.get(1).visit();
        
        while (!Q.isEmpty()) {
            Node cur = Q.remove();
            for (Node node : cur.linkingNodes) {
                if (node.isVisited()) continue;
                node.setDist(cur.getDist() + 1);
                node.visit();
                Q.add(node);
                distMap.computeIfAbsent(node.getDist(),
                                        key -> new HashSet<>()).add(node.getNum());
            }
        }
        
        int value = distMap.firstEntry().getValue().size();
        
        return value;
    }
    
    static class Node {
        int num;
        int distFromOne = Integer.MAX_VALUE;
        boolean visited = false;
        
        Set<Node> linkingNodes = new HashSet<>();
        
        public Node(int num) {
            this.num = num;
        }
        
        public int getNum() {
            return this.num;
        }
        
        public int getDist() {
            return this.distFromOne;
        }
        
        public void setDist(int dist) {
            this.distFromOne = dist;
        }

        public void setMinDist(int dist) {
            this.distFromOne = Math.min(this.distFromOne, dist);
        }
        
        public void link(Node node) {
            linkingNodes.add(node);
            node.linkingNodes.add(this);
        }
        
        public Set<Node> getLinkingNodes() {
            return this.linkingNodes;
        }
        
        public void visit() {
            this.visited = true;
        }
        
        public boolean isVisited() {
            return this.visited;
        }
    }
}