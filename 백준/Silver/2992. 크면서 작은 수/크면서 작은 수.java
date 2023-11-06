import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String n;
    static int min = 1000000;
    static char[] arr, tmpArr;
    static boolean[] visit;
    static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        number = Integer.parseInt(n);
        arr = new char[n.length()];
        tmpArr = new char[n.length()];
        visit = new boolean[arr.length];

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i);
        }

        backTracking(0);
        if (min >= 1000000) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }

    private static void backTracking(int depth) {
        if (depth == arr.length) {
            int tmp = Integer.parseInt(String.valueOf(tmpArr));
            if (number < tmp) {
                min = Math.min(min, tmp);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            tmpArr[depth] = arr[i];
            backTracking(depth + 1);
            visit[i] = false;
        }
    }
}