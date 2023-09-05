import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String bNum = Long.toBinaryString(numbers[i]);
            int idx = bNum.length() - 1;
            
            if (bNum.charAt(idx) == '0') {
                answer[i] = numbers[i] + 1;
                continue;
            }
            
            while (idx >= 0 && bNum.charAt(idx) == '1') {
                idx--;
            }
            
            if (idx == -1) {
                bNum = "0" + bNum;
                idx++;
            }
            
            char[] b = bNum.toCharArray();
            b[idx] = '1';
            b[idx + 1] = '0';
            
            answer[i] = Long.parseLong(String.valueOf(b), 2);          
        }
        return answer;
    }
}