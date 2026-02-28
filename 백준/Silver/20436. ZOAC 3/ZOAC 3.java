import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static char l, r;
    static char[] string;
    static Map<Character, int[]> map = new HashMap<>();

    static {
        map.put('q', new int[]{0, 0, 0}); // ㅂ
        map.put('w', new int[]{0, 1, 0}); // ㅈ
        map.put('e', new int[]{0, 2, 0}); // ㄷ
        map.put('r', new int[]{0, 3, 0}); // ㄱ
        map.put('t', new int[]{0, 4, 0}); // ㅅ
        map.put('y', new int[]{0, 5, 1}); // ㅛ
        map.put('u', new int[]{0, 6, 1}); // ㅕ
        map.put('i', new int[]{0, 7, 1}); // ㅑ
        map.put('o', new int[]{0, 8, 1}); // ㅐ
        map.put('p', new int[]{0, 9, 1}); // ㅔ
        map.put('a', new int[]{1, 0, 0}); // ㅁ
        map.put('s', new int[]{1, 1, 0}); // ㄴ
        map.put('d', new int[]{1, 2, 0}); // ㅇ
        map.put('f', new int[]{1, 3, 0}); // ㄹ
        map.put('g', new int[]{1, 4, 0}); // ㅎ
        map.put('h', new int[]{1, 5, 1}); // ㅗ
        map.put('j', new int[]{1, 6, 1}); // ㅓ
        map.put('k', new int[]{1, 7, 1}); // ㅏ
        map.put('l', new int[]{1, 8, 1}); // ㅣ
        map.put('z', new int[]{2, 0, 0}); // ㅋ
        map.put('x', new int[]{2, 1, 0}); // ㅌ
        map.put('c', new int[]{2, 2, 0}); // ㅊ
        map.put('v', new int[]{2, 3, 0}); // ㅍ
        map.put('b', new int[]{2, 4, 1}); // ㅠ
        map.put('n', new int[]{2, 5, 1}); // ㅜ
        map.put('m', new int[]{2, 6, 1}); // ㅡ
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] p1 = map.get(sc.next().charAt(0));
        int[] p2 = map.get(sc.next().charAt(0));

        string = sc.next().toCharArray();

        int time = 0;
        for (char c : string) {
            int[] p = map.get(c);
            if (p[2] == 0) {
                time += Math.abs(p1[0] - p[0]) + Math.abs(p1[1] - p[1]);
                p1 = p;
            } else {
                time += Math.abs(p2[0] - p[0]) + Math.abs(p2[1] - p[1]);
                p2 = p;
            }
            time++;
        }

        System.out.println(time);
    }
}