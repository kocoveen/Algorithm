import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (String s1, String s2) -> {
            int k1 = Integer.parseInt(s1 + s2);
            int k2 = Integer.parseInt(s2 + s1);
            
            return Integer.compare(k2, k1);
        });
        
        if (arr[0].equals("0")) {
            return "0";
        }
        return String.join("", arr);
    }
}