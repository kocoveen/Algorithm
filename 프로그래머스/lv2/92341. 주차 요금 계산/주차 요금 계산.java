import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        TreeMap<Integer, Integer> timeAccuMap = new TreeMap<>();
        
        for (String record : records) {
            String[] l = record.split(" ");
            int carNum = Integer.parseInt(l[1]);
            int time = convert(l[0]);
            if (l[2].equals("IN")) {
                time *= -1;
            }
            timeAccuMap.put(carNum, time + timeAccuMap.getOrDefault(carNum, 0));
        }
        
        int[] answer = new int[timeAccuMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> en : timeAccuMap.entrySet()) {   
            if (en.getValue() <= 0) {
                timeAccuMap.put(en.getKey(), en.getValue() + convert("23:59"));
            }
            
            answer[i++] = caculateFees(fees, timeAccuMap.get(en.getKey()));
        }
        
        return answer;
    }
    
    private int convert(String time) {
        String[] hm = time.split(":");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        return h * 60 + m;
    }
    
    private int caculateFees(int[] fees, int accuTime) { 
        int basicCharge = fees[1];
        int surcharge = accuTime <= fees[0] ? 0 : (int) Math.ceil((double) (accuTime - fees[0]) / fees[2]) * fees[3];
        return basicCharge + surcharge;
    }
}