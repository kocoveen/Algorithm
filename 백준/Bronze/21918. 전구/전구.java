public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        N = read(); M = read();

        int[] bulbs = new int[N];
        for (int i = 0; i < N; i++) {
            bulbs[i] = read();
        }

        while (M-- > 0) {
            int a = read();
            switch (a) {
                case 1: {
                    int i = read();
                    int x = read();

                    bulbs[i-1] = x;
                    break;
                }

                case 2: {
                    int l = read();
                    int r = read();

                    // l 번째 부터 r 번째 까지 상태 변경
                    for (int i = l-1; i < r; i++) {
                        bulbs[i] = bulbs[i] == 1 ? 0 : 1;
                    }
                    break;
                }

                case 3: {
                    int l = read();
                    int r = read();
                    
                    for (int i = l-1; i < r; i++) {
                        bulbs[i] = 0;
                    }
                    break;
                }

                case 4: {
                    int l = read();
                    int r = read();
                    
                    for (int i = l-1; i < r; i++) {
                        bulbs[i] = 1;
                    }
                    break;
                }
            }
        }

        for (int i : bulbs) {
            System.out.print(i + " ");
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}