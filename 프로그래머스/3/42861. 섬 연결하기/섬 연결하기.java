import java.util.*;

class Solution {
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        int[] parent = makeParentInit(n);
        
        return kruskal(costs, parent);
    }
    
    private int kruskal(int[][] costs, int[] parent) {
        int sum = 0;        
        for (int i = 0; i < costs.length; i++) {
            int root1 = find(parent, costs[i][0]);
            int root2 = find(parent, costs[i][1]);

            if (root1 != root2) {
                union(parent, root1, root2);
                sum += costs[i][2];
            }
        }
        return sum;
    }
    
    private int find(int[] parent, int index) {
        if (parent[index] < 0) {
            return index;
        }
        
        while(parent[index] != -1) {
            index = parent[index];
        }
        return index;
        // return find(parent, parent[index]);
    }
    
    private void union(int[] parent, int root1, int root2) {
        // int r1 = find(parent, root1);
        // int r2 = find(parent, root2);
        
        // if (r1 != r2) {
            parent[root2] = root1;
        // }
    }
    
    private int[] makeParentInit(int n) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        return parent;
    }
}