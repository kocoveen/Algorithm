import java.io.*;

public class Main {

    static byte l = 2;
    static byte r = 32;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        byte[] gears = new byte[t];
        for (int i = 0; i < t; i++) {
            gears[i] = (byte) Integer.parseInt(br.readLine(), 2);
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]) - 1;
            int r = Integer.parseInt(line[1]);
            rotation(gears, num, r);
        }

//        N -> 0; S -> 1;
        int count = 0;
        for (byte gear : gears) {
            byte twelve = (byte) (gear & Byte.MIN_VALUE);
            if (twelve == Byte.MIN_VALUE) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void rotation(byte[] gears, int num, int r) {
        int[] isRot = new int[gears.length];
        isRot[num] = r;
        checkLeft(isRot, gears, num);
        checkRight(isRot, gears, num);

        for (int i = 0; i < gears.length; i++) {
            byte b = gears[i];
            int rot = isRot[i];
            gears[i] = (byte) ((b & 0xFF) >>> ((8+rot) % 8) | b << ((8-rot) % 8)); //진짜 회전
        }
    }

    //왼쪽 체크
    static void checkLeft(int[] isRot, byte[] gears, int num) {
        if (num <= 0) return;

        if (((gears[num - 1] & r) >>> 4) != (gears[num] & l)) {
            isRot[num - 1] = ~isRot[num] + 1;
            checkLeft(isRot, gears, num - 1);
        }
    }

    //오른쪽 체크
    static void checkRight(int[] isRot, byte[] gears, int num) {
        if (gears.length - 1 <= num) return;

        if (((gears[num] & r) >>> 4) != (gears[num + 1] & l) ) {
            isRot[num + 1] = ~isRot[num] + 1;
            checkRight(isRot, gears, num + 1);
        }
    }

}