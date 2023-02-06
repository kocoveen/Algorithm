import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] arr = String.valueOf(n).split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        String answ = "";
        
        for(String s : arr)
           answ += s;
        
        answer = Long.parseLong(answ);
        
        return answer;
    }
}