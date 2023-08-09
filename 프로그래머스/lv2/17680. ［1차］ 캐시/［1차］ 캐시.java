class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        String[] cache = new String[cacheSize];
        int[] times = new int[cacheSize];
        int time = 0;
        
        for (String city : cities) {
            String ignored_city = city.toLowerCase();

            int[] hitIndex = findCacheHitIndex(cache, ignored_city, times);
            
            if (hitIndex[0] == 1) {
                times[hitIndex[1]] = ++time;
                answer++;
            } else {
                if (hitIndex[1] != -1) {
                    cache[hitIndex[1]] = ignored_city;
                    times[hitIndex[1]] = ++time;
                }
                answer += 5;
            }
        }
        return answer;
    }
    
    private int[] findCacheHitIndex(String[] cache, String city, int[] times) {
        if (cache.length == 0) {
            return new int[]{0, -1};
        }
        int min = 0;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == null) {
                return new int[]{0, i};
            }
            
            if (times[min] >= times[i]) {
                min = i;    
            }
            
            
            if (cache[i].equals(city)) {
                return new int[]{1, i};
            }
        }
        return new int[]{0, min};
    }
    
    private void insert(String[] cache, int index, String city) {
        if (cache.length == 0) {
            return;
        }
        cache[index] = city;
    }    

}