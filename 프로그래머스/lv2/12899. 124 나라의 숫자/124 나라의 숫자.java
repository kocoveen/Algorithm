class Solution {
     public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int t = 3; // target
        int idx = 2;
        while(n>t){
            t += Math.pow(3, idx);
            idx++;
        }

        int start = ((int)(t-Math.pow(3, idx-1))+1); // 자리수 시작 위치
        int m = n-start;
        int pow = idx-2;

        for(int i=0; i<idx-1; i++){
            int div = (int)(m/Math.pow(3, pow));

            if(div == 2) sb.append(4);
            else if(div == 1) sb.append(2);
            else sb.append(1);

            m %= Math.pow(3, pow);
            pow--;
        }

        return sb.toString();
    }
}