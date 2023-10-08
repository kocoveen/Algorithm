import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) {
            return 0;
        }
        
        answer = func(begin, target, wordSet, 0);
        
        return answer;
    }
    
    private int func(String begin, String target, Set<String> wordSet, int depth) {
        int min = Integer.MAX_VALUE;
        
        if (begin.equals(target)) {
            return depth;
        }
        
        if (wordSet.isEmpty()) {
            return 0;
        }
        
        for (String word : wordSet) {
            if (!isDiffOneChar(begin, word)) {
                continue;
            }
            Set<String> newWordSet = new HashSet<>(wordSet);
            newWordSet.remove(word);
            min = Math.min(min, func(word, target, newWordSet, depth + 1));
        }
        return min;
    }
    
    private boolean isDiffOneChar(String begin, String word) {
        int count = 0;
        if (begin.equals(word)) {
            return false;
        }
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                count++;
            }
        }

        // count가 0인 경우는 없음
        if (count != 1) {
            return false;
        }
        return true;
    }
}