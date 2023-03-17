class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    System.out.println(sum);
                    if (isPrime(sum) == true)
                        answer++;
                }
            }
        }

        return answer;
    }
    
    public static boolean isPrime(int num) {
        boolean p = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                p = false;
        }
        return p;
    }
}