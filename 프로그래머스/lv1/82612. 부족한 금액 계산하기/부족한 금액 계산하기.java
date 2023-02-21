class Solution {
    public long solution(int price, int money, int count) {        
        long total = (long) count * ( (long) count + 1) *  (long) price / 2;
        System.out.println(total);
        System.out.println(money);
        return total - money > 0 ? total - money : 0;
    }
}