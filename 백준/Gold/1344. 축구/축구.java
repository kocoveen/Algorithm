import java.io.*;

/**
 * 적어도 한 팀이 골을 소수로 득점할 확률 = 1 - 두 팀 다 소수로 득점하지 못 할 확률
 *
 * 총 간격 18개 -> 간격 당 득점 최대 1 -> 한 팀이 얻을 점수 : 0 ~ 18
 * 소수로 득점할 확률 -> 2, 3, 5, 7, 11, 13, 17 -> 7개 / 19개
 *
 */
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] primes = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 간격에서 팀 득점 확률 {분자, 분모, 분모-분자 (기약분수일 때)}
        int[] pA = new int[]{Integer.parseInt(br.readLine()), 100, 0};
        int[] pB = new int[]{Integer.parseInt(br.readLine()), 100, 0};

        // 기약 분수 만들기
        int kA = gcd(pA[0], pA[1]);
        pA[0] /= kA;
        pA[1] /= kA;
        pA[2] = pA[1] - pA[0];

        int kB = gcd(pB[0], pB[1]);
        pB[0] /= kB;
        pB[1] /= kB;
        pB[2] = pB[1] - pB[0];

        double a = getProbability(pA);
        double b = getProbability(pB);

        System.out.println(a + b - (a * b));
    }

    private static double getProbability(int[] pArr) {
        double p = 0;
        for (int prime : primes) {
            p += Math.pow((double) pArr[0] / pArr[1], prime) *
                 Math.pow((double) pArr[2] / pArr[1], 18 - prime) *
                 combination(18, prime);
        }
        return p;
    }

    private static double combination(int n, int r) {
        int a = n - r;
        double result = 1;
        for (int i = 1; i <= Math.min(r, a); i++) {
            result *= (double) (n - i + 1) / i;
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}