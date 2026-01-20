import java.util.*;

public class Main {

    static class Info {
        int o, d, c;
        Info(int o, int d, int c) {
            this.o = o;
            this.d = d;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int C = scanner.nextInt();
        int M = scanner.nextInt();

        Info[] boxes = new Info[M];

        for (int i = 0; i < M; i++) {
            boxes[i] = new Info(
                scanner.nextInt()-1,
                scanner.nextInt()-1,
                scanner.nextInt()
            );
        }

        // 도착지 기준으로 정렬
        Arrays.sort(boxes, (i1, i2) -> i1.d - i2.d);

        int[] capacity = new int[N];
        for (int i = 0; i < N; i++) {
            capacity[i] = C;
        }
        int totalDelivered = 0;

        for (Info i : boxes) {
            // 출발지부터 도착지 직전까지의 구간 중 최소 잔여 용량 확인
            var minSpace = C;
            for (int k = i.o; k < i.d; k++) {
                if (minSpace > capacity[k]) {
                    minSpace = capacity[k];
                }        
            }
                
            // 이번에 실을 수 있는 최대 박스 계산
            int amountToLoad = Math.min(i.c, minSpace);
        
            // 구간 용량 업데이트 및 결과 합산
            for (int k = i.o; k < i.d; k++) {
                capacity[k] -= amountToLoad;
            }
            totalDelivered += amountToLoad;
        }

        System.out.println(totalDelivered);
    }
}