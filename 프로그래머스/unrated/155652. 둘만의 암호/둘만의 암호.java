class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] str = s.toCharArray();
        
        for (int i = 0; i < str.length; i++) {
            int k = index;
            while(k > 0) {
                int j = (str[i] - 96) % 26 + 97;
                str[i] = (char) j;
                
                if (skip.indexOf(str[i]) != -1)
                    k++;
                k--;
            }
        }
        
        answer = String.valueOf(str);
        return answer;
    }
}