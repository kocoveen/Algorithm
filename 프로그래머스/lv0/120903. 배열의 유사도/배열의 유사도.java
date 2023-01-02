class Solution {
    
    public int solution(String[] s1, String[] s2) {
        
        int answer = 0;
        
        for (String i : s1){
            for (String j : s2){
                if (i.equals(j)){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}