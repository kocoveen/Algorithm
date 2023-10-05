import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (String operation : operations) {
            String[] instruction = operation.split(" ");
            String command = instruction[0];
            Integer argument = Integer.parseInt(instruction[1]);
            
            switch (command) {
                case "I": {
                    maxHeap.add(argument);
                    minHeap.add(argument);
                    break;
                }
                case "D": {
                    if (maxHeap.size() == 0 || minHeap.size() == 0) {
                        continue;
                    }
                    if (argument == 1) {
                        Integer max = maxHeap.remove();
                        minHeap.remove(max);
                    } else {
                        Integer min = minHeap.remove();
                        maxHeap.remove(min);
                    }
                    break;
                }
            }
        }
        
        if (maxHeap.size() == 0 || minHeap.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxHeap.remove();
            answer[1] = minHeap.remove();
        }
        
        return answer;
    }
}