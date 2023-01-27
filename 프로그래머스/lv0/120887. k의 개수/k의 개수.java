class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int a = i; a <= j; a++){
            if(String.valueOf(a).contains(String.valueOf(k))) {
                answer += String.valueOf(a).length() - String.valueOf(a).replace(String.valueOf(k), "").length();
            }
        }
        return answer;
    }
}