import java.util.Scanner;

public class Main {

    static int N;
    static int[] stockPrices = new int[14];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < 14; i++) {
            stockPrices[i] = sc.nextInt();
        }

        int j = bnp(N);
        int s = timing(N);

        if (j > s) {
            System.out.println("BNP");
        } else if (s > j) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int bnp(int n) {
        int stock = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            if (n >= stockPrices[i]) {
                int buyStock = (n / stockPrices[i]);
                stock += buyStock;
                n -= buyStock * stockPrices[i];
            }
        }
        return n + stock * stockPrices[13];
    }

    private static int timing(int n) {
        int stock = 0;
        int uptrend = 0, downtrend = 0;

        int previousPrice = stockPrices[0];
        for (int i = 0; i < stockPrices.length; i++) {
            if (previousPrice > stockPrices[i]) {
                uptrend = 0;
                downtrend++;
            } else if (previousPrice < stockPrices[i]) {
                downtrend = 0;
                uptrend++;
            } else {
                downtrend = 0;
                uptrend = 0;
            }

            // 3일 연속 하락이면, 전량 매수
            // 3일 연속 상승이면, 전량 매도
            if (downtrend >= 3) {
                if (n >= stockPrices[i]) {
                    // 매수
                    int buyStock = (n / stockPrices[i]); // 전량 살 수 있는 주식 수
                    stock += buyStock;  // 주식 개수 더하기
                    n -= buyStock * stockPrices[i]; // 가격만큼 n 빼기
                }
            } else if (uptrend >= 3) {
                // 매도
                n += stock * stockPrices[i]; // 가진 주식 전부 매도
                stock = 0; // 주식량 0
            }

            previousPrice = stockPrices[i]; // 이전값 갱신
        }
        return n + stock * stockPrices[13];
    }
}