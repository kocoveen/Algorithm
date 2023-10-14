import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] broken = new boolean[10];
        while (m-- > 0) {
            int i = sc.nextInt();
            broken[i] = true;
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = Integer.toString(i);
            int digit = str.length();

            boolean isBroken = false;
            for (int j = 0; j < digit; j++) {
                if (broken[str.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int pushCount = Math.abs(n - i) + digit;
                result = Math.min(pushCount, result);
            }
        }
        System.out.println(result);
    }
}