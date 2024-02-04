import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long l = 0;
        while (l * l + l <= 2 * s) l++;
        System.out.println(l - 1);
    }
}