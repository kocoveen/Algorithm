class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int y = x;
        int sum = 0;
        while (x >= 1) {
            sum += x % 10;
            x /= 10;
        }
        if (y % sum == 0) answer = true;
        return answer;
    }
}