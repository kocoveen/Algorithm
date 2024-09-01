public class Main {
    static int N, total;
    static int[] sizes;
    static int T, P;
    
    public static void main(String[] args) throws Exception {
        N = read();
        sizes = new int[6];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = read();
        }
        
        T = read(); P = read();
        
        for (int size : sizes) {
            total += (size + T - 1) / T;
        }
        
        System.out.println(total);
        System.out.println(N / P + " " + N % P);
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}