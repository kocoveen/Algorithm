import java.util.*;

public class Main {

    static int t;
    static int r, c, d;
    static int mnR, mnC, mxR, mxC;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            r = 500; c = 500; d = 0;
            mnR = 500; mnC = 500; mxR = 500; mxC = 500;
            System.out.println(getMinRectangle(sc.next().toCharArray()));
        }
    }

    private static int getMinRectangle(char[] cmds) {
        for (char cmd : cmds) {
            switch (cmd) {
                case 'F' : {
                    r += dr[d];
                    c += dc[d];
                    break;
                }
                case 'B' : {
                    r -= dr[d];
                    c -= dc[d];
                    break;
                }
                case 'L' : {
                    d = (d + 1) % 4;
                    break;
                }
                case 'R' : {
                    d = (d + 3) % 4;
                    break;
                }
            }
            mnR = Math.min(mnR, r);
            mnC = Math.min(mnC, c);
            mxR = Math.max(mxR, r);
            mxC = Math.max(mxC, c);
        }
        return (mxR - mnR) * (mxC - mnC);
    }
}