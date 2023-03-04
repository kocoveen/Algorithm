import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        Stack<String> foods = new Stack<>();
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 1; j <= food[i] / 2; j++) {
                String dish = String.valueOf(i);
                foods.push(dish);
                answer += foods.peek();
            }
        }
        
        foods.push(String.valueOf(0));
        
        while(!foods.isEmpty()) {
            answer += foods.pop();
        }
        
        return answer;
    }
}