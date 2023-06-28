import java.util.*;

class Solution {
    
    static String[] typeArray = {"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};
    static Map<String, Integer> typeTable = new HashMap<>();
    static Map<String, Integer> signTable = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {

        for (int i = 0; i < typeArray.length; i++) {
            typeTable.put(typeArray[i], i / 2);
            signTable.put(typeArray[i], i);
        }
    
        int[] scores = new int[4];
        
        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            int typeCode = codeGenerator(type);
            scores[typeCode] += scoreGenerator(type, choices[i]);
        }
        
        String answer = makePersonality(scores);
        
        return answer;
    }
    
    private int codeGenerator(String type) {
        return typeTable.get(type);
    }
    
    private int scoreGenerator(String type, int score) {
        int tmp = signTable.get(type);
        if (tmp % 2 == 0) return score - 4;
        return -1 * (score - 4);
    }
    
    private String makePersonality(int[] scores) {
        String answer = "";
        for (int i = 0; i < scores.length; i++) {
            int target = i * 2;
            if (scores[i] > 0) target++;
            answer += typeArray[target].substring(0, 1);
        }
        return answer;
    }
}

