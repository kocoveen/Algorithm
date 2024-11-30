public class Main {

    static int r1, c1, r2, c2;
    static int maxLen;
    static int[][] printArray;

    public static void main(String[] args) throws Exception {
        r1 = read(); c1 = read(); r2 = read(); c2 = read();

        printArray = new int[r2 - r1 + 1][c2 - c1 + 1];
        for (int i = 0, r = r1; r <= r2; i++, r++) {
            for (int j = 0, c = c1; c <= c2; j++, c++) {
                printArray[i][j] = getEndPointValue(r, c);
                maxLen = Math.max(maxLen, String.valueOf(printArray[i][j]).length());
            }
        }

        String format = "%" + maxLen + "d ";
        for (int[] array : printArray) {
            for (int i : array) {
                System.out.printf(format, i);
            }
            System.out.println();
        }
    }

    static int getEndPointValue(int r, int c) {
        int maxEndPointIndex = Math.max(Math.abs(r), Math.abs(c)); // endPoint 인덱스(R, C);
        // 어떤 경우든, R >= r, C >= c, R = C
        int maxEndPointParam = 2 * maxEndPointIndex + 1; // endPoint 매개변수
        int maxEndPointValue = maxEndPointParam * maxEndPointParam; // endPoint 값

        if (r == maxEndPointIndex && c == maxEndPointIndex) return maxEndPointValue;
        
        int manhattanR = maxEndPointIndex - r; // mr, 맨해튼 거리 r 좌표 차이
        int manhattanC = maxEndPointIndex - c; // mc, 맨해튼 거리 c 좌표 차이
        int manhattanDistance = manhattanR + manhattanC; // 맨해튼 거리

        int perimeter = maxEndPointIndex * 8; // 둘레 길이
        
        // 맨해튼 거리가 같은 두 좌표는 mr과 mc의 크기 차이로 계산
        // mr < mc, endPointValue - 맨해튼 거리
        if (manhattanR < manhattanC) return maxEndPointValue - manhattanDistance;
        // mr >= mc, endPointValue - 둘레 길이 + 맨해튼 거리
        else return maxEndPointValue - perimeter + manhattanDistance;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}