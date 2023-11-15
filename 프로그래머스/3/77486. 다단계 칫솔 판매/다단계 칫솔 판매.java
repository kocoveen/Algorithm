import java.util.*;

class Solution {

    Map<String, Member> members = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        members.put("-", new Member("-"));
        for (int i = 0; i < enroll.length; i++) {
            Member member = new Member(enroll[i]);
            member.setRecommender(members.get(referral[i]));
            members.put(enroll[i], member);
        }

        for (int i = 0; i < seller.length; i++) {
             members.get(seller[i]).setTotalProfit(amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = members.get(enroll[i]).getTotalProfit();
        }
        return answer;
    }

    public static class Member {
        public String name;
        public Member recommender;
        int totalProfit;

        public Member(String name) {
            this.name = name;
        }

        public void setRecommender(Member recommender) {
            this.recommender = recommender;
        }

        public int distribute(int profit) {
            if (this.recommender == null) {
                return 0;
            }

            int distribution = profit / 10; // 배분할 이익
            int left = profit - distribution; // 남은 이익

            this.recommender.setTotalProfit(distribution);
            return left;
        }

        public int getTotalProfit() {
            return totalProfit;
        }

        public void setTotalProfit(int profit) {
            this.totalProfit += distribute(profit);
        }
    }
}