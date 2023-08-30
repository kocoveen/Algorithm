import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
        }
        
        Stack<Integer> S = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            while (!S.isEmpty() && numbers[S.peek()] < numbers[i]) {
                answer[S.pop()] = numbers[i];
            }
            S.push(i);        
        }
        
        return answer;
    }
    
//     for ind, num in enumerate(numbers):
//         while stack and numbers[stack[-1]] < num:
//             answer[stack.pop()] = num
//         stack.append(ind)
//     return answer
}