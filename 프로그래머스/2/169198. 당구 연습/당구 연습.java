class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int x1 = startX;  int y1 = startY;
            int x2 = balls[i][0]; int y2 = balls[i][1];
            
            int[] o = {
                (x1 + x2) * (x1 + x2) + (y1 - y2) * (y1 - y2),                 // 0: 왼쪽 벽 (x = 0)
                (x1 - x2) * (x1 - x2) + (y1 + y2) * (y1 + y2),                 // 1: 아래쪽 벽 (y = 0)
                (x1 + x2 - 2*m) * (x1 + x2 - 2*m) + (y1 - y2) * (y1 - y2),     // 2: 오른쪽 벽 (x = m)
                (x1 - x2) * (x1 - x2) + (y1 + y2 - 2*n) * (y1 + y2 - 2*n)      // 3: 위쪽 벽 (y = n)
            };
            
            if (x1 == x2) {
                if (y1 > y2) o[1] = Integer.MAX_VALUE; // (y = 0) 벽 불가
                else o[3] = Integer.MAX_VALUE;         // (y = n) 벽 불가
            }
            
            if (y1 == y2) {
                if (x1 > x2) o[0] = Integer.MAX_VALUE; // (x = 0) 벽 불가
                else o[2] = Integer.MAX_VALUE;         // (x = m) 벽 불가
            }
            
            int min = getMin(o);
            answer[i] = min;
        }
        
        return answer;
    }
    
    private int getMin(int... elems) {
        int min = Integer.MAX_VALUE;
        for (int elem : elems) {
            if (min > elem) {
                min =  elem;
            }
        }
        return min;
    }
}