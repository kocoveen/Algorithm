class Solution {    
    public String solution(String X, String Y) {
        int[][] numCount = new int[2][10];
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < Math.max(X.length(), Y.length()); i++) {
            if(i < X.length()) {
                numCount[0][X.charAt(i)-48]++;
            }
            
            if(i < Y.length()) {
                numCount[1][Y.charAt(i)-48]++;
            }
        }

        for (int i = 9; i >= 0; i--) {
            for(int j = 0; j < Math.min(numCount[0][i], numCount[1][i]); j++) {
                sb.append(String.valueOf(i));
            }
        }

        if(sb.length() == 0) return "-1";
        if(sb.charAt(0) == '0') return "0";        
        return sb.toString();
    }
}