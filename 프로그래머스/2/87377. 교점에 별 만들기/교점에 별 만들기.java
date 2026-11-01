import java.util.*;

class Solution {
    
    long xmin = Long.MAX_VALUE;
    long ymin = Long.MAX_VALUE;
    long xmax = Long.MIN_VALUE;
    long ymax = Long.MIN_VALUE;
    
    Set<Point> intersections = new HashSet<>();
    
    public String[] solution(int[][] line) {
        
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = 1; j < line.length; j++) {
                long a1 = line[i][0];
                long b1 = line[i][1];
                long c1 = line[i][2];
                long a2 = line[j][0];
                long b2 = line[j][1];
                long c2 = line[j][2];
                
                long xnum = b1*c2 - b2*c1;
                long ynum = c1*a2 - c2*a1;
                long denom = a1*b2 - a2*b1;
                
                if (isDivisible(xnum, denom) 
                    && isDivisible(ynum, denom)) {
                    
                    long x = xnum / denom;
                    long y = ynum / denom;
                    
                    intersections.add(new Point(x, y));
                    
                    xmin = Math.min(x, xmin);
                    ymin = Math.min(y, ymin);
                    xmax = Math.max(x, xmax);
                    ymax = Math.max(y, ymax);
                }
            }
        }
        
        int r = (int) (ymax - ymin + 1);
        int c = (int) (xmax - xmin + 1);
        char[][] coodinate = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                coodinate[i][j] = '.';
            }
        }
        
        for (Point p : intersections) {
            int ny = (int) (ymax - p.y());
            int nx = (int) (p.x() - xmin);
            coodinate[ny][nx] = '*';
        }
        
        String[] answer = new String[r];
        for (int i = 0; i < r; i++) {
            answer[i] = new String(coodinate[i]);
        }
        
        return answer;
    }
    
    private boolean isDivisible(long a, long b) {
        return b != 0 && a % b == 0;
    }
}

record Point(long x, long y) {}