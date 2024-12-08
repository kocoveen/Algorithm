public class Main {
    public static void main(String[] args) throws Exception {
        String L = String.valueOf(read()), R = String.valueOf(read());

        int count8 = 0;

        if (L.length() != R.length()) {
            System.out.println(count8);
            System.exit(0);
        }

        for (int i = 0; i < R.length(); i++) {
            if (L.charAt(i) == R.charAt(i)) { 
                if (L.charAt(i) == '8') { count8++; }
            }
            else break;
        }

        System.out.println(count8);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}