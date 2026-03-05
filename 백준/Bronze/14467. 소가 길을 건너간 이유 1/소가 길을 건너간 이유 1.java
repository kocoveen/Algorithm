import java.util.Arrays;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        N = read();

        int[] cows = new int[11];
        Arrays.fill(cows, -1);

        int count = 0;
        while (N-- > 0) {
            int cow = read();
            int road = read();
            
            if (cows[cow] != road) {
                if (cows[cow] > -1) {
                    count++;
                }
                cows[cow] = road;
            }
        }

        System.out.print(count);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}