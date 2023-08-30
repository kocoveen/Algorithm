import java.util.*;
class Solution {
    boolean[][] visited = new boolean[11][11];
    Map<Character, Integer> map = new HashMap<>();
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, -1, 0, 1};
    
    public int solution(String dirs) {
        int answer = 0;
        
        map.put('R', 0); map.put('U', 1); map.put('L', 2); map.put('D', 3);
        
        List<Pair> dots = new ArrayList<>();
        Set<Set<Pair>> S = new HashSet<>();
        dots.add(new Pair(5, 5));
        
        for (int i = 0; i < dirs.length(); i++) {
            Pair prevP = dots.get(dots.size() - 1);
            
            int dIndex = map.get(dirs.charAt(i));
            int nr = prevP.r + dr[dIndex];
            int nc = prevP.c + dc[dIndex];
            
            if (isNotBoundary(nr, nc)) continue;
            
            Pair curP = new Pair(prevP.r + dr[dIndex], prevP.c + dc[dIndex]);
            
            Set newSet = new HashSet<>();
            newSet.add(prevP);
            newSet.add(curP);
            S.add(newSet);
            dots.add(new Pair(prevP.r + dr[dIndex], prevP.c + dc[dIndex]));
        }
        
//         for (Pair p : dots) {
//             System.out.printf("(%d, %d) -> ", p.r, p.c);
//         }
//         System.out.printf("\n");
        
//         for (Map.Entry<Pair, Set<Pair>> en : routes.entrySet()) {
//             System.out.printf("(%d, %d) -> {", en.getKey().r, en.getKey().c);
//             for (Pair end : en.getValue()) {
//                 System.out.printf("(%d, %d)", end.r, end.c);  
//             }
//             System.out.printf("}\n");
//         }
        
        return S.size();
    }
    
    private static boolean isNotBoundary(int nr, int nc) {
        return nr < 0 || nc < 0 || nr > 10 || nc > 10; 
    }
    
    private static class Pair {
        int r;
        int c;
        
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    } 
}