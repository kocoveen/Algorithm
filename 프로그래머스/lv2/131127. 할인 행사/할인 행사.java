import java.util.*;

class Solution {
    static Map<String, Integer> discountMap = new HashMap<>();
    static int days;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int[] saleNumber = new int[number.length];
        
        // 원하는 일수
        for (int i = 0; i < number.length; i++) {
            days += number[i];
        }
        
        //init
        if (discount.length < days) return 0;
        for (int i = 0; i < discount.length - days + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < days; j++) {
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                }
            } else {
                discountMap.put(discount[days + i - 1], discountMap.getOrDefault(discount[days + i - 1], 0) + 1);
                discountMap.put(discount[i - 1], discountMap.getOrDefault(discount[i - 1], 0) - 1);
            }
            
            // for (Map.Entry<String, Integer> entry : discountMap.entrySet()) {
            //     System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
            // }
            // System.out.println();
            
            //검증
            boolean flag = true;
            for (int k = 0; k < want.length; k++) {
                if (discountMap.get(want[k]) == null || discountMap.get(want[k]) != number[k]) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) {
                continue;
            }
            answer++;
        }
        
        return answer;
    }
}