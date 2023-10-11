import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();   
    
    int mn = Integer.MAX_VALUE;
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        for (String gem : gems) {
            set.add(gem);
        }
        
        int[] end = new int[gems.length];
        
        int l = 0, r = 0;
        while (l <= r) {
            if (map.size() != set.size()) {
                if (r == gems.length) {
                    break;
                }
                map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
                r++;
            } else {
                if (l == gems.length) {
                    break;
                }
                end[l] = r;
                map.put(gems[l], map.getOrDefault(gems[l], 0) - 1);
                if (map.get(gems[l]) == 0) {
                    map.remove(gems[l]);
                }
                l++;
            }
        }
        
        if (r == gems.length && map.size() == set.size()) {
            end[l] = r;
        }
        
        for (int i = 0; i < end.length; i++) {
            if (end[i] == 0) continue;
            if (mn > end[i] - i) {
                mn = end[i] - i;
                answer[0] = i + 1;
                answer[1] = end[i];
            }
        }
        
        // for(int e : end) {
        //     System.out.print(e + " ");   
        // }
        
        
        return answer;
    }
}