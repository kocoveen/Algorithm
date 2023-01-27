class Solution {
    public int solution(int i, int j, int k) {
        String answer = "";
        
        for (int a = i; a <= j; a++) {
            answer += a + "";
        }
        
        return answer.length() - answer.replace(k + "", "").length();
    }
}