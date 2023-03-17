import java.util.*;

class Solution {
    public List solution(int[] answers) {
        List<Integer> score = new ArrayList<>();
        score.add(0);
        score.add(0);
        score.add(0);
        
        int[][] list = {{1, 2, 3, 4, 5},
                        {2, 1, 2, 3, 2, 4, 2, 5},
                        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (answers[i] == list[j][i%list[j].length]) {
                    score.set(j, score.get(j) + 1);
                }
            }
        }
        
        int max = Collections.max(score);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.size(); i++) {
            if (score.get(i) == max) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}