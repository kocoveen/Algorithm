import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for (int i = 0; sb.length() < 100 * t; i++){
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        
        for (int i = 0; sb2.length() < t; i++){
            if (i % m == p - 1) {
                sb2.append(sb.charAt(i));
            }
        }
        
        return sb2.toString();
    }
}