import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n, sum;
    static List<Integer> negZero = new ArrayList<>();
    static List<Integer> posBiggerThanOne = new ArrayList<>();
    static List<Integer> ones = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        n = read();
        for (int i = 0; i < n; i++) {
            int value = read();
            if (value <= 0) {
                negZero.add(value);
            } else if (value != 1){
                posBiggerThanOne.add(value);
            } else {
                ones.add(value);
            }
        }

        Collections.sort(negZero, (i1, i2) -> i1 - i2);
        Collections.sort(posBiggerThanOne, (i1, i2) -> i2 - i1);

        while (negZero.size() > 1) {
            sum += negZero.remove(0) * negZero.remove(0);
        }
        if (!negZero.isEmpty()) {
            sum += negZero.get(0);
        }

        while (posBiggerThanOne.size() > 1) {
            sum += posBiggerThanOne.remove(0) * posBiggerThanOne.remove(0);
        }
        if (!posBiggerThanOne.isEmpty()) {
            sum += posBiggerThanOne.get(0);
        }

        sum += ones.size();
        System.out.println(sum);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}