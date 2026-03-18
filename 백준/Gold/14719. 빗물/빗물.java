import java.util.*;

public class Main {

    static int H, W, maxH, maxHI;
    static int[] blocks;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();

        blocks = new int[W];

        for (int i = 0; i < W; i++) {
            blocks[i] = sc.nextInt();
            if (maxH <= blocks[i]) {
                maxH = blocks[i];
                maxHI = i;
            }
        }

        int max = blocks[0];
        int capacity = 0;
        for (int i = 1; i < maxHI; i++) {
            if (max < blocks[i]) {
                max = blocks[i];
            } else {
                capacity += max - blocks[i];
            }
        }

        max = blocks[W-1];
        for (int i = W-1; i >= maxHI; i--) {
            if (max < blocks[i]) {
                max = blocks[i];
            } else {
                capacity += max - blocks[i];
            }
        }

        System.out.println(capacity);
    }
}