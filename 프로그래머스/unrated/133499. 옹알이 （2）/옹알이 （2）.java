class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] pron = {"aya", "ye", "woo", "ma"};

        Loop1:
        for (String b : babbling) {
            Loop2:
            for(String p : pron) {
                if(b.contains(p.repeat(2))) {
                    continue Loop1;
                }
            }
            
            String[] asd = b.split("aya|ye|woo|ma");
            if(asd.length == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}