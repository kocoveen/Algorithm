import java.util.*;

public class Main {

    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();
        int oldLen = s.length();
        int newLen = s.replaceAll("LL", "L").length();
        System.out.println(oldLen != newLen ? newLen + 1 : oldLen);

    }
}