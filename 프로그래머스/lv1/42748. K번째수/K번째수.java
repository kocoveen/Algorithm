import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list;
        
        for (int i = 0; i < commands.length; i++) {
            
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int index = commands[i][2] - 1;
            
            list = new ArrayList<>();
            
            for (int j = start; j <= end; j++) {
                list.add(Integer.valueOf(array[j]));
            }
            
            Collections.sort(list);
            
            int result = list.get(index);
            answer[i] = result;
            
        }         

        return answer;
    }
}