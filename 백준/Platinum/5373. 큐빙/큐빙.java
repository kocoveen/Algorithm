import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    // 0:U(w), 1:D(y), 2:F(r), 3:B(o), 4:L(g), 5:R(b)
    // D면의 0행은 F면과 닿아있음.
    // F, B, L, R면의 0행은 U와 닿아있음.
    static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
    static final char[] COLORS = {'w', 'y', 'r', 'o', 'g', 'b'};
    static char[][][] cube = new char[6][3][3];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            initCube();
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                String cmd = sc.next(); // 루프 안으로 이동
                char face = cmd.charAt(0);
                char dir = cmd.charAt(1);
                int count = (dir == '+') ? 1 : 3; // -1로 회전한 것과 3번 회전한 건 같

                for (int c = 0; c < count; c++) {
                    rotate(face);
                }
            }

            // 윗면(U) 출력
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    sb.append(cube[U][r][c]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    static void initCube() {
        for (int f = 0; f < 6; f++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    cube[f][r][c] = COLORS[f];
                }
            }
        }
    }

    // 해당 면 자체(3x3)를 시계 방향으로 90도 회전
    static void rotateFace(int f) {
        char[][] temp = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                temp[c][2 - r] = cube[f][r][c]; // r' = c, c' = r
            }
        }
        cube[f] = temp;
    }

    // 각 면을 정면에서 봤을 때 시계 방향 회전
    // 
    static void rotate(char face) {
        char[] temp = new char[3];

        switch (face) {
            case 'U':
                rotateFace(U);
                for (int i = 0; i < 3; i++) temp[i] = cube[F][0][i];
                for (int i = 0; i < 3; i++) cube[F][0][i] = cube[R][0][i];
                for (int i = 0; i < 3; i++) cube[R][0][i] = cube[B][0][i];
                for (int i = 0; i < 3; i++) cube[B][0][i] = cube[L][0][i];
                for (int i = 0; i < 3; i++) cube[L][0][i] = temp[i];
                break;

            case 'D':
                rotateFace(D);
                for (int i = 0; i < 3; i++) temp[i] = cube[F][2][i];
                for (int i = 0; i < 3; i++) cube[F][2][i] = cube[L][2][i];
                for (int i = 0; i < 3; i++) cube[L][2][i] = cube[B][2][i];
                for (int i = 0; i < 3; i++) cube[B][2][i] = cube[R][2][i];
                for (int i = 0; i < 3; i++) cube[R][2][i] = temp[i];
                break;

            case 'F':
                rotateFace(F);
                for (int i = 0; i < 3; i++) temp[i] = cube[U][2][i];
                for (int i = 0; i < 3; i++) cube[U][2][i] = cube[L][2 - i][2];
                for (int i = 0; i < 3; i++) cube[L][2 - i][2] = cube[D][0][2 - i];
                for (int i = 0; i < 3; i++) cube[D][0][2 - i] = cube[R][i][0];
                for (int i = 0; i < 3; i++) cube[R][i][0] = temp[i];
                break;

            case 'B':
                rotateFace(B);
                for (int i = 0; i < 3; i++) temp[i] = cube[U][0][i];
                for (int i = 0; i < 3; i++) cube[U][0][i] = cube[R][i][2];
                for (int i = 0; i < 3; i++) cube[R][i][2] = cube[D][2][2 - i];
                for (int i = 0; i < 3; i++) cube[D][2][2 - i] = cube[L][2 - i][0];
                for (int i = 0; i < 3; i++) cube[L][2 - i][0] = temp[i];
                break;

            case 'L':
                rotateFace(L);
                for (int i = 0; i < 3; i++) temp[i] = cube[U][i][0];
                for (int i = 0; i < 3; i++) cube[U][i][0] = cube[B][2 - i][2];
                for (int i = 0; i < 3; i++) cube[B][2 - i][2] = cube[D][i][0];
                for (int i = 0; i < 3; i++) cube[D][i][0] = cube[F][i][0];
                for (int i = 0; i < 3; i++) cube[F][i][0] = temp[i];
                break;

            case 'R':
                rotateFace(R);
                for (int i = 0; i < 3; i++) temp[i] = cube[U][i][2];
                for (int i = 0; i < 3; i++) cube[U][i][2] = cube[F][i][2];
                for (int i = 0; i < 3; i++) cube[F][i][2] = cube[D][i][2];
                for (int i = 0; i < 3; i++) cube[D][i][2] = cube[B][2 - i][0];
                for (int i = 0; i < 3; i++) cube[B][2 - i][0] = temp[i];
                break;
        }
    }
}