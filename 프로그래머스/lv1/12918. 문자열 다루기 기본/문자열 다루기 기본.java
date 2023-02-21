class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] bits = s.toCharArray();
        
        if(bits.length != 4 && bits.length != 6) return false;
        
        for (char bit : bits) {
            if(bit < 48 || bit > 57) {
                return false;
            }
        }
        
        return true;
        
    }
}