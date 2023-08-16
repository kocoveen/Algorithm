class Solution {
    static int count;
    static int[] staticNums;
    static int[] minus;
        
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        staticNums = numbers;
        minus = new int[numbers.length];
        
        for (int i = 0; i < minus.length; i++) {
            minus[i] = 1;
        }
        
        for (int depth = 0; depth < numbers.length; depth++) {
            func(0, depth, 0, target);
        }
        
        return count;
    }
    
    private void func(int st, int depth, int mCount, int target) {
        if (mCount == depth) {
            if (productSum(staticNums, minus) == target) {
                count++;
            }
            return;
        }
        
        for (int i = st; i < staticNums.length; i++) {
            if (minus[i] == -1) continue;
            minus[i] = -1;
            func(i + 1, depth, mCount + 1, target);
            minus[i] = 1;
        }
    }
    
    private int productSum(int[] numbers, int[] minus) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i] * minus[i];
        }
        return sum;
    }
    
//     for (int i : staticNums) {
//         System.out.println(i);
//     }
}