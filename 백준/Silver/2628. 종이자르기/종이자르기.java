import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        Queue<Rectangle> rectangles = new ArrayDeque<>();
        rectangles.add(new Rectangle(0, 0, h, w));

        int c = sc.nextInt();
        while (c-- > 0) {
            int cmd = sc.nextInt();
            int pos = sc.nextInt();

            int size = rectangles.size();
            for (int i = 0; i < size; i++) {
                Rectangle r = rectangles.poll();
                rectangles.addAll(r.cut(cmd, pos));
            }
        }

        List<Rectangle> result = new ArrayList<>(rectangles);
        result.sort((r1, r2) -> r2.getArea() - r1.getArea());

        System.out.println(result.get(0).getArea());
    }

    static class Rectangle {
        int sh, sw;
        int eh, ew;

        Rectangle(int sh, int sw, int eh, int ew) {
            this.sh = sh;
            this.sw = sw;
            this.eh = eh;
            this.ew = ew;
        }

        Collection<Rectangle> cut(int cmd, int pos) {
            if (cmd == 0) {
                if (pos <= sh || pos >= eh) return List.of(this);
                return List.of(new Rectangle(sh, sw, pos, ew), new Rectangle(pos, sw, eh, ew));
            } else {
                if (pos <= sw || pos >= ew) return List.of(this);
                return List.of(new Rectangle(sh, pos, eh, ew), new Rectangle(sh, sw, eh, pos));
            }
        }

        int getArea() {
            return (eh - sh) * (ew - sw);
        }
    }
}