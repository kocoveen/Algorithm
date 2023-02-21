import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if (arr.length == 1) {
            answer = new int[arr.length];
            answer[0] = -1;
            return answer;
            
        } else {
            List<Integer> intList = Arrays.stream(arr)
                .boxed().collect(Collectors.toList());
            
            int iMin = Arrays.stream(arr).min().getAsInt();
            
            for (int i=0; i<intList.size(); i++) {
                if (intList.get(i) == iMin)
                    intList.remove(i);
            }
            
            answer = new int[arr.length - 1];
            
            for (int i=0; i<intList.size(); i++) {
                answer[i] = intList.get(i);
            }
            
            return answer;
        }
        
    }
}