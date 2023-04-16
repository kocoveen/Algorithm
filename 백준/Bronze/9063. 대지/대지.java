import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int minX = sc.nextInt(), minY = sc.nextInt(), maxX = minX, maxY = minY;

        for (int i = 0; i < N-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (minX > x) minX = x;
            if (minY > y) minY = y;
            if (maxX < x) maxX = x;
            if (maxY < y) maxY = y;
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}