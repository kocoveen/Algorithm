public class Main {

    static boolean[] hasConstructor = new boolean[10001];

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            int c;
            if ((c = d(i)) < 0) continue;
            hasConstructor[c] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!hasConstructor[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        if (sum > 10000) {
            return -1;
        }

        return sum;
    }
}