class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        String A2 = "";
        A2 = A + A;
        
        for (int i = A2.length(); i > A.length(); i--) {
            if (A2.substring(i-A.length(), i).contains(B)) {
                return A2.length()-i;
            }
        }
        
        return answer;
    }
}