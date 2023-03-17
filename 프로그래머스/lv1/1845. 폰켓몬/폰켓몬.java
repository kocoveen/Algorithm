import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        
        int answer = nums.length / 2;
        int[] dist = Arrays.stream(nums).distinct().toArray();
        
        if(dist.length < nums.length / 2)
            answer = dist.length;
        
        return answer;
    }
}