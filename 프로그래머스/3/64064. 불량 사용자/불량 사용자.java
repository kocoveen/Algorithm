import java.util.*;
import java.util.regex.*;

class Solution {
    Set<Set<String>> S = new HashSet<>();
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        visited = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, new HashSet<>());
        
        answer = S.size();
        return answer;
    }
    
    private void dfs(String[] user_id, String[] banned_id, int depth, Set<String> set) {
        int answer = 0;
        if (depth == banned_id.length) {
            S.add(new HashSet<>(set));
            return;
        }
        
        String regex = banned_id[depth].replaceAll("\\*", "\\.");
        
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i] || !Pattern.matches(regex, user_id[i])) continue;
            visited[i] = true;
            set.add(user_id[i]);
            dfs(user_id, banned_id, depth + 1, set);
            set.remove(user_id[i]);
            visited[i] = false;
        }
    }
}