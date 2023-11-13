import java.io.*;
import java.util.Arrays;

public class Main {

    static String[] st;
    static int[] geminis = new int[10];
    static int[] gullivers = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 제미니스의 각 이닝 점수 상황
        st = br.readLine().split(" ");
        for (int i = 1; i <= 9; i++) {
            geminis[i] = geminis[i - 1] + Integer.parseInt(st[i - 1]);
        }

        // 걸리버스의 각 이닝 점수 상황
        st = br.readLine().split(" ");
        for (int i = 1; i <= 9; i++) {
            gullivers[i] = gullivers[i - 1] + Integer.parseInt(st[i - 1]);
        }

//        print(geminis);
//        print(gullivers);

        if (isComeBackLose()) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
    }

//    private static void print(int[] team) {
//        for (int i = 1; i <= 9; i++) {
//            System.out.printf("%d ", team[i]);
//        }
//        System.out.println();
//    }

    private static boolean isComeBackLose() {
        // 9회말 후, 제미니스가 이기거나 비긴 경우
        if (geminis[9] >= gullivers[9]) {
            return false;
        }

        // 9회말 후, 제미니스가 졌을 때
        for (int i = 9; i >= 1; i--) {
            // 제미니스(초공)의 현재 이닝의 점수가 걸리버스(후공)의 이전 이닝의 점수보다 큰 경우
            // -> 제미니스가 이기다가 졌으니 역전패
            if (geminis[i] > gullivers[i - 1]) {
                return true;
            }
        }

        // -> 원래 지고 있었음
        return false;
    }
}