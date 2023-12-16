import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int X, Y, D, T;
    static double Z, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Z = Math.sqrt((X * X) + (Y * Y));

        if (D / T < 1) { //점프가 의미 없다면
            answer = Z;

        } else { //점프가 의미 있다면
            int q = (int) Z / D; //도착지점 전까지 몇 번 점프하는가?
            double r = Z % D; //점프를 다 하고 남는 거리

            if (r == 0) { //점프로만 도착 가능한 경우
                answer = q * T;

            } else if (q == 0) { //(r != 0) 한 점프가 도착지점을 넘는 경우
                double a1 = 2 * T < Math.ceil(Z) ? 2 * T : Math.ceil(Z); // 우회하는 점프
                double a2 = T + (D - Z);
                double a3 = (double) r;

                answer = Math.min(a1, Math.min(a2, a3));

            } else { //(r != 0 && q >= 1) 한 점프가 도착지점을 못 넘는 경우
                double a1 = (q + 1) * T; // 우회하는 점프
                double a2 = q * T + r; // 남은 거리 1짜리로 걷기
                double a3 = (q + 1) * T + ((q + 1) * D - Z); // 도착지점 넘기고 넘긴 거리 걷기

                answer = Math.min(a1, Math.min(a2, a3));

            }
        }
        System.out.println(answer);
    }
}