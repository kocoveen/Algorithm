class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] S = new int[ingredient.length];
        int top = 0;
        for(int i : ingredient) {
            S[top++] = i;
            if (top < 4) continue;
            if (S[top - 1] == 1 && S[top - 2] == 3 && S[top - 3] == 2 && S[top - 4] == 1) {
                top -= 4;
                answer++;
            }
        }
        return answer;
    }
}