import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportedCountMap = new HashMap<>();
        for(String s : id_list) {
            reportMap.put(s, new HashSet<String>());
            reportedCountMap.put(s, 0);
        }
        
        String[] l;
        for(String s : report) {
            l = s.split(" ");
            if (reportMap.get(l[0]).contains(l[1])) continue;
            reportMap.get(l[0]).add(l[1]);
            reportedCountMap.put(l[1], reportedCountMap.get(l[1]) + 1);
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < answer.length; i++) {
            for(String s : reportMap.get(id_list[i])) {
                if (reportedCountMap.get(s) >= k)
                    answer[i]++;
            }
        }
        
        return answer;
    }
}