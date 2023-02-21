class Solution {
    public long solution(long price, long money, long count) {        
        long total = count * (count + 1) * price / 2;
        return total - money > 0 ? total - money : 0;
    }
}