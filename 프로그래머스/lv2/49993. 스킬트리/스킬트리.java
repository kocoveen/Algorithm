import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skill_tree : skill_trees) {
            String filtered = skill_tree.replaceAll("[^" + skill + "]", "");
            
            boolean possible = true;
            for (int i = 0; i < filtered.length(); i++) {
                if (filtered.charAt(i) != skill.charAt(i)) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                answer++;
            }
        }
        
        return answer;
    }
}