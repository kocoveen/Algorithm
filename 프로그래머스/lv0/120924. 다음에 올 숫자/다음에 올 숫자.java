class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int l = common.length-1;
        
        if ( common[l] - common[l-1] == common[l-1] - common[l-2] ) {
            answer = common[0] + (l+1) * (common[l] - common[l-1]);
        } else {
            answer = common[l] * (common[l] / common[l-1]);
        }
        
        return answer;
    }
}