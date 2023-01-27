class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        for (int i = 0; i < num; i++) {
            if (num % 2 != 0){
                int j = (total / num) - (num/2) + i;
                answer[i] = j;
            } else {
                int j = (total / num) - ((num-1)/2) + i;
                answer[i] = j;
            }
        }
        return answer;
    }
}