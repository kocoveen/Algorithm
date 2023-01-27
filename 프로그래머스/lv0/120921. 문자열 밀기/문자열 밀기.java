class Solution {
    public int solution(String A, String B) {
        String T = B.repeat(2);
        return T.indexOf(A);
    }
}