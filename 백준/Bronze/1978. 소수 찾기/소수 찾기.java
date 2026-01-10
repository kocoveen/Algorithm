public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = read();
            if (num < 2) continue;
            
            boolean isPrime = true;
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count++;
        }
        System.out.println(count);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
