import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int preNum = 10;
        
        for(int num : arr) {
            if(preNum != num)
                list.add(num);
            preNum = num;
        } 
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        
        
    
        return answer;
    }
}