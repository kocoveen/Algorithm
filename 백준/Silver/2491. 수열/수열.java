import java.util.*;

public class Main {

    static int n;
    static int[] s;
    static int m_i_s = 0, iCnt = 0, iMax = 0;
    static int m_d_s = 100_001, dCnt = 0, dMax = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        for (int i : s) {
            if (m_i_s <= i) {
                iCnt++;
                iMax = Math.max(iMax, iCnt);
            } else {
                iCnt = 1;
            }
            m_i_s = i;

            if (m_d_s >= i) {
                dCnt++;
                dMax = Math.max(dMax, dCnt);
            } else {
                dCnt = 1;
            }
            m_d_s = i;
        }

        System.out.println(Math.max(iMax, dMax));
    }
}