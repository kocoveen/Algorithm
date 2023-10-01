import java.util.*;

class Solution {
    /**
     * minerals
     * - diamond = 0
     * - iron = 1
     * - stone = 2
     */
    int[][] rounds;
    int[][] fatigue = {{1, 1, 1},
            {5, 1, 1},
            {25, 5, 1}};

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickCount = countPicks(picks);

        int roundSize = Math.min(pickCount, minerals.length / 5 + 1);
        rounds = new int[roundSize][3];

        for (int i = 0; i < roundSize; i++) {
            for (int j = 0; j < 5 && i * 5 + j < minerals.length; j++) {
                switch (minerals[i * 5 + j]) {
                    case "diamond": rounds[i][0]++; break;
                    case "iron": rounds[i][1]++; break;
                    case "stone": rounds[i][2]++; break;
                }
            }
        }

        Arrays.sort(rounds, (int[] r1, int[] r2) -> {
            if (r1[0] != r2[0]) {
                return r2[0] - r1[0];

            } else if (r1[1] != r2[1]) {
                return r2[1] - r1[1];

            } else {
                return r2[2] - r1[2];
            }
        });

        int round = 0;
        for (int i = 0; i < 3; i++) {
            while (picks[i] != 0 && round < rounds.length) {
                answer += rounds[round][0] * fatigue[i][0];
                answer += rounds[round][1] * fatigue[i][1];
                answer += rounds[round][2] * fatigue[i][2];
                picks[i]--; round++;
            }
        }

        return answer;
    }

    private int countPicks(int[] picks) {
        int count = 0;
        for (int i : picks) {
            count += i;
        }
        return count;
    }
}