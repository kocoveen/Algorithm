public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        if (n <= 99) {
            System.out.println(n);
            System.exit(0);
        }
        int count = 99;
        for (int i = 100; i <= n; i++) {
            String k = Integer.toString(i);
            if (isCorrect(k)) {
                count++;
            }
        }
        System.out.println(count);

    }

    private static boolean isCorrect(String k) {
        for (int j = 0; j < k.length() - 2; j++) {
            if (k.charAt(j + 2) - k.charAt(j + 1) != k.charAt(j + 1) - k.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;

    }
}