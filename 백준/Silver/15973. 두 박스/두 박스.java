public class Main {

    static class Line {
        int s, e;
    }

    public static void main(String[] args) throws Exception {
        Line x1 = new Line(); Line y1 = new Line();
        Line x2 = new Line(); Line y2 = new Line();
        x1.s = read(); y1.s = read(); x1.e = read(); y1.e = read();
        x2.s = read(); y2.s = read(); x2.e = read(); y2.e = read();

        int ix = intersect(x1, x2);
        int iy = intersect(y1, y2);
        if (ix == 0 || iy == 0) System.out.println("NULL");
        else if (ix == 1 && iy == 1) System.out.println("POINT");
        else if (ix == 1 || iy == 1) System.out.println("LINE");
        else System.out.println("FACE");
    }

    static int intersect(Line l1, Line l2) {
        if (l1.s > l2.s) {
            Line tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        if (l1.e < l2.s) return 0; //안겹침
        else if (l1.e == l2.s) return 1; // 한점
        else return 2; // 겹침
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}