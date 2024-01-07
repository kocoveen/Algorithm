public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        while (t-- > 0) {
            int num = read(); //분자
            int denom = read(); //분모
            int[] origin = new int[]{num, denom};
            while (!isUnitFraction(origin)) {
                int[] unitFraction = getUnitFraction(origin);
                origin = diffFraction(origin, unitFraction);
            }
            System.out.println(origin[1]);
        }
    }

    private static int[] getUnitFraction(int[] origin) {
        int num = origin[0];
        int denom = origin[1];
        while (denom % num != 0) {
            denom++;
        }
        return new int[]{1, denom / num};
    }

    private static int[] diffFraction(int[] origin, int[] unitFraction) {
        int num = origin[0] * unitFraction[1] - origin[1];
        int denom = origin[1] * unitFraction[1];
        int gcd = gcd(num, denom); //최소공배수
        return new int[]{num / gcd, denom / gcd};
    }

    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    private static boolean isUnitFraction(int[] fraction) {
        return fraction[0] == 1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}