class Solution {

    int len;
    String start;
    boolean[] isCorrect;

    public int solution(String name) {
        int answer = 0;

        len = name.length();
        start = "A".repeat(len);
        isCorrect = new boolean[len];

        int incorrectCount = len;

        for (int i = 0; i < len; i++) {
            if (start.charAt(i) == name.charAt(i)) {
                isCorrect[i] = true;
                incorrectCount--;
            } else {
                int diff1 = name.charAt(i) - start.charAt(i) + 26;
                int diff2 = start.charAt(i) - name.charAt(i) + 26;
                answer += Math.min(diff1 % 26, diff2 % 26);
            }
        }

        answer += dfs(0, incorrectCount, 0);

        return answer;
    }

    private int dfs(int cur, int incorrectCount, int dist) {
        if (incorrectCount == 0) {
            return dist;
        }

        int left = cur, right = cur;
        int leftDist = 0, rightDist = 0;
        int l, r;

        while (isCorrect[left]) {
            left = (left - 1 + len) % len;
            leftDist++;
        }
        isCorrect[left] = true;
        l = dfs(left, incorrectCount - 1, dist + leftDist);
        isCorrect[left] = false;

        while (isCorrect[right]) {
            right = (right + 1 + len) % len;
            rightDist++;
        }
        isCorrect[right] = true;
        r = dfs(right, incorrectCount - 1, dist + rightDist);
        isCorrect[right] = false;

        return Math.min(l, r);
    }
}