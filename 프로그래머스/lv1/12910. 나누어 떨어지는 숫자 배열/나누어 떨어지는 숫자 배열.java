import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        answer = Arrays.stream(arr)
            .filter(s -> s % divisor == 0)
            .sorted().toArray();
        
        if (answer.length == 0) {
            int[] a = {-1};
            return a;
        }
        
        return answer;
    }
}