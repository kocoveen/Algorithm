import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 4; i++) {
            int Ax1 = read();
            int Ay1 = read();
            int Ax2 = read();
            int Ay2 = read();
            int Bx1 = read();
            int By1 = read();
            int Bx2 = read();
            int By2 = read();

            if (Ax2 < Bx1 || Ay2 < By1 || Bx2 < Ax1 || By2 < Ay1) {
                System.out.println("d");
            } else if ((Ax2 == Bx1 && Ay2 == By1) || (Ax2 == Bx1 && Ay1 == By2) || (Ax1 == Bx2 && Ay1 == By2) || (Ax1 == Bx2 && Ay2 == By1)) {
                System.out.println("c");
            } else if (Ax2 == Bx1 || Ay2 == By1 || Bx2 == Ax1 || By2 == Ay1) {
                System.out.println("b");
            } else {
                System.out.println("a");
            }
        }
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}