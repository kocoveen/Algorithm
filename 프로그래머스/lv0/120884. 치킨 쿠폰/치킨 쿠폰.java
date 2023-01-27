class Solution {
    public int solution(int chicken) {
        int answer = chicken/9;
        if(chicken>1&&chicken%9==0){
            answer--;
        }


        return answer;
    }
}