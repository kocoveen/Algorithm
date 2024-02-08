public class Main {

    static int[] arr = new int[2001];
    static int C = 1000;
    static int n;

    public static void main(String[] args) throws Exception {
        n = read();
        while (n-- > 0) arr[read() + C]++;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) if (arr[i] > 0) sb.append(i - C).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}