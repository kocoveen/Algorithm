import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> mens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mens.add(i + 1);
        }

        long fac = factorial(mens.size());
        int turn = 0;
        while (!mens.isEmpty()) {
            fac /= mens.size();
            long idx = (k - 1) / fac;
            answer[turn++] = mens.remove((int) idx);
            k = (k - 1) % fac + 1;
        }

        return answer;
    }

    private long factorial(int f) {
        long t = 1;
        for (int i = 2; i <= f; i++) {
            t *= i;
        }
        return t;
    }
}