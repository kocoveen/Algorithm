import java.util.*;

public class Main {
    static int K, M;
    static boolean[] isNotPrime;
    static List<Integer> primeList = new ArrayList<>();
    static boolean[] canSum;    // 조건 1 만족 여부
    static boolean[] canMul;    // 조건 2 만족 여부 (두 소수의 곱)
    static Set<Integer> generatedNums = new HashSet<>();
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        M = sc.nextInt();

        int limit = (int) Math.pow(10, K);
        
        // 1. 에라토스테네스의 체
        isNotPrime = new boolean[limit];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < limit; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
                for (long j = (long) i * i; j < limit; j += i) {
                    isNotPrime[(int) j] = true;
                }
            }
        }

        // 2. 조건 1 전처리: 서로 다른 두 소수의 합
        canSum = new boolean[limit];
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i + 1; j < primeList.size(); j++) {
                int sum = primeList.get(i) + primeList.get(j);
                if (sum < limit) canSum[sum] = true;
            }
        }

        // 3. 조건 2 전처리: 두 소수의 곱 (같은 소수 가능)
        canMul = new boolean[limit];
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i; j < primeList.size(); j++) {
                long mul = (long) primeList.get(i) * primeList.get(j);
                if (mul < limit) canMul[(int) mul] = true;
            }
        }

        // 4. K자리의 서로 다른 숫자로 이루어진 수 생성 및 검사
        generateNumbers(0, 0);

        int answer = 0;
        for (int n : generatedNums) {
            if (canSum[n]) {
                int temp = n;
                while (temp % M == 0) temp /= M;
                if (canMul[temp]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void generateNumbers(int depth, int num) {
        if (depth == K) {
            generatedNums.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 && i == 0) continue; // 첫 자리는 0 불가
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(depth + 1, num * 10 + i);
                visited[i] = false;
            }
        }
    }
}