class Solution {
    public int[] solution(int[] numlist, int n) {
      
        for (int i = 0; i < numlist.length; i++) {
            for (int j = 0; j < numlist.length-i-1; j++) {
                if (Math.abs(n-numlist[j]) > Math.abs(n-numlist[j+1])) {
                    numlist[j] = numlist[j] + numlist[j+1];
                    numlist[j+1] = numlist[j] - numlist[j+1];
                    numlist[j] = numlist[j] - numlist[j+1];
                }
                
                if (Math.abs(n-numlist[j]) == Math.abs(n-numlist[j+1]) && numlist[j] < numlist[j+1]) {
                    numlist[j] = numlist[j] + numlist[j+1];
                    numlist[j+1] = numlist[j] - numlist[j+1];
                    numlist[j] = numlist[j] - numlist[j+1];
                }
            }
        }
        
        return numlist;
    }
}