class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        char[] str = s.toCharArray();
        
        for(int i = s.length() - 1; i >= 0; i--) {
            answer[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(str[i] == str[j]) {
                    answer[i] = i - j;
                    break;
                }
            }
            
            
        }        
        
        return answer;
    }
}