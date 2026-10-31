import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        
        for (String infoString : info) {
            String[] split = infoString.split(" ");
            makeAllCombinations(split, "", 0);
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int k = 0;
        for (String query : queries) {
            String[] queryString = query.split(" and | ");
            String queryKey = queryString[0] + queryString[1] + queryString[2] + queryString[3];
            int targetScore = Integer.parseInt(queryString[4]);
            
            if (map.containsKey(queryKey)) {
                List<Integer> scoreList = map.get(queryKey);
                
                int count = lowerBound(scoreList, targetScore);
                answer[k] = scoreList.size() - count;
            }
            k++;
        }
        
        return answer;
    }
    
    private void makeAllCombinations(String[] str, String curr, int d) {
        if (d == 4) {
            int score = Integer.parseInt(str[4]);
            map.computeIfAbsent(curr, k -> new ArrayList<>()).add(score);
            return;
        }
        makeAllCombinations(str, curr + str[d], d+1);
        makeAllCombinations(str, curr + "-", d+1);
    }
    
    private int lowerBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}

