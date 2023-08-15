import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        
        str1 = str1.replaceAll("[^A-Za-z]", ".");
        str2 = str2.replaceAll("[^A-Za-z]", ".");

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2).toLowerCase();
            if (!s.contains(".")) {
                str1Map.put(s, str1Map.getOrDefault(s, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2).toLowerCase();
            if (!s.contains(".")) {
                str2Map.put(s, str2Map.getOrDefault(s, 0) + 1);
            }
        }
        
        int intersection = intersect(str1Map, str2Map);
        int union = unite(str1Map, str2Map);
        
        if (union == 0) {
            answer = 65536;
        } else {
            answer = (double)  intersection / union * 65536;
        }
        
        return (int) answer;
    }
    
    private int intersect(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> m = new HashMap<>();
        
        for (String key : m1.keySet()) {
            if (m2.containsKey(key)) {
                m.put(key, Math.min(m1.get(key), m2.get(key)));
            }
        }
        
        int count = 0;
        for (String key : m.keySet()) {
            count += m.get(key);
        }
        
        return count;
    }
    
    private int unite(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> m = new HashMap<>();
        for (String s1 : m1.keySet()) {
            m.put(s1, Math.max(m1.getOrDefault(s1, Integer.MIN_VALUE), m2.getOrDefault(s1, Integer.MIN_VALUE)));
        }
                  
        for (String s2 : m2.keySet()) {
            m.put(s2, Math.max(m1.getOrDefault(s2, Integer.MIN_VALUE), m2.getOrDefault(s2, Integer.MIN_VALUE)));
        }
        
        int count = 0;
        for (String key : m.keySet()) {
            count += m.get(key);
        }
        
        return count;
    }
}