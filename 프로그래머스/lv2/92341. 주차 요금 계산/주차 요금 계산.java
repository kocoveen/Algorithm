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
        
        for (Map.Entry<Integer, Integer> en : timeAccuMap.entrySet()) {   
            if (en.getValue() <= 0) {
                timeAccuMap.put(en.getKey(), en.getValue() + convert("23:59"));
            }
        }
        
        int j = 0;
        int[][] arr = new int[timeAccuMap.size()][2];
        for (Map.Entry<Integer, Integer> en : timeAccuMap.entrySet()) {            
            arr[j][0] = en.getKey();
            arr[j][1] = caculateFees(fees, en.getValue());
            j++;
        }
        
        Arrays.sort(arr, (a1, a2) -> {
            return a1[0] - a2[0];
        });
        
        int[] answer = new int[arr.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = arr[i][1];
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