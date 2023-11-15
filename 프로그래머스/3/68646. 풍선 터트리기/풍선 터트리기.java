import java.util.*;

class Solution {

    public int solution(int[] a) {
        int answer = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        // int[][] dp=new int[a.length][2];
        for(int i=0;i<a.length;i++){
            min1=Math.min(min1,a[i]);
            min2=Math.min(min2,a[a.length-1-i]);
            hs.add(min1);
            hs.add(min2);
            // dp[i][0]=min1;
            // dp[a.length-1-i][1]=min2;

        }
        // for(int i=0;i<dp.length;i++){
        //     System.out.println(dp[i][0]+" "+dp[i][1]);
        // }
        return hs.size();
    }
}