class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab : babbling) {
            String[] a = bab.split("(aya|ye|woo|ma)");
            if (a.length == 0) {
                answer += 1;
            }
        }
        
        return answer;
    }
}