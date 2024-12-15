import java.util.*;

class Solution {

    static Set<String> gemSet;
    static Map<String, Integer> gemCountMap;

    static int mnVal = Integer.MAX_VALUE;
    static int mnL, mnR;

    public int[] solution(String[] gems) {
        gemSet = new HashSet<>();
        gemCountMap = new HashMap<>();

        gemSet.addAll(Arrays.asList(gems));

        int l = 0, r = 0;
        while (l <= r && l < gems.length) {
            if (r == gems.length) {
                if (gemCountMap.size() == gemSet.size() && mnVal > (r - l)) {
                    mnL = l;
                    mnR = r;
                    mnVal = mnR - mnL;
                }

                gemCountMap.put(gems[l], gemCountMap.get(gems[l]) - 1);
                if (gemCountMap.get(gems[l]) == 0) {
                    gemCountMap.remove(gems[l]);
                }
                l++;
            } else {
                if (gemCountMap.size() != gemSet.size()) {
                    gemCountMap.put(gems[r], gemCountMap.getOrDefault(gems[r], 0) + 1);
                    r++;

                } else {
                    if (gemCountMap.size() == gemSet.size() && mnVal > (r - l)) {
                        mnL = l;
                        mnR = r;
                        mnVal = mnR - mnL;
                    }

                    gemCountMap.put(gems[l], gemCountMap.get(gems[l]) - 1);
                    if (gemCountMap.get(gems[l]) == 0) {
                        gemCountMap.remove(gems[l]);
                    }

                    l++;
                }
            }
        }
        System.out.println(mnL + " " + mnR);
        return new int[]{mnL+1, mnR};
    }
}