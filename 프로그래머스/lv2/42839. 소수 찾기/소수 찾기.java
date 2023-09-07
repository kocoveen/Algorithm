import java.util.HashSet;
import java.util.Set;

class Solution {

    static Set<Integer> S = new HashSet<>();
    static String[] bits;
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        bits = numbers.split("");
        visited = new boolean[bits.length];
        func("");

        for (int elem : S) {
            if (isPrime(elem)) {
               answer++;
            }
        }
        return answer;
    }

    private void func(String number) {
        if (!number.isEmpty()) {
            S.add(Integer.parseInt(number));
        }

        for (int i = 0; i < bits.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            func(number + bits[i]);
            visited[i] = false;
        }
    }

    private boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
