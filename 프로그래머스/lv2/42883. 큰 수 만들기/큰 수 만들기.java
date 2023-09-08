import java.util.Stack;

class Solution {

    public String solution(String number, int k) {
        String[] digits = new String[number.length() - k];
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (!S.isEmpty() && S.peek() < number.charAt(i) - '0' && k > 0) {
                k--;
                S.pop();
            }
            S.push(number.charAt(i) - '0');
        }

        if (k != 0) {
            for (int i = 0; i < k; i++) {
                S.pop();
            }
        }

        int j = 0;
        for (Integer i : S) {
            digits[j++] = String.valueOf(i);
        }
        return String.join("", digits);
    }
}