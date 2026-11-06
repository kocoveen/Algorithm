class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            String current = s[i];
            StringBuilder stack = new StringBuilder();
            int count = 0; // 추출한 "110"의 개수
            
            for (int j = 0; j < current.length(); j++) {
                char c = current.charAt(j);
                stack.append(c);
                
                int len = stack.length();
                if (len >= 3 && 
                    stack.charAt(len - 3) == '1' && 
                    stack.charAt(len - 2) == '1' && 
                    stack.charAt(len - 1) == '0') {
                    
                    stack.delete(len - 3, len);
                    count++;
                }
            }
            
            int lastZeroIdx = stack.lastIndexOf("0");
            int insertIdx = (lastZeroIdx == -1) ? 0 : lastZeroIdx + 1;
            
            for (int j = 0; j < count; j++) {
                stack.insert(insertIdx, "110");
            }
            answer[i] = stack.toString();
        }
        
        return answer;
    }
}
