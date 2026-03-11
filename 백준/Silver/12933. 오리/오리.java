import java.util.Scanner;

public class Main {

    static String str;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        System.out.print(quack(str));
    }

    private static int quack(String str) {
        int[] quack = new int[5];
        String s = "quack";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'q') {
                if (quack[4] > 0) quack[4]--;
                quack[0]++;
            } else {
                int j = s.indexOf(c);
                if (quack[j-1] == 0) return -1;
                quack[j-1]--;
                quack[j]++;
            }
        }

        if (quack[0] > 0 || quack[1] > 0 || quack[2] > 0 || quack[3] > 0) return -1;
        return quack[4];
    }
}