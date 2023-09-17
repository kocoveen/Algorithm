import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] board = new int[rows][columns];
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = count++;
            }
        }

        int[] mins = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            mins[i] = (clockwise(board, queries[i]));
        }

        return mins;
    }

    private int clockwise(int[][] board, int[] query) {
        int min = Integer.MAX_VALUE;
        Deque<Integer> D = new ArrayDeque<>();

        int minR = query[0] - 1;
        int minC = query[1] - 1;
        int maxR = query[2] - 1;
        int maxC = query[3] - 1;

        for (int i = minC; i < maxC; i++) { // to right
            D.add(board[minR][i]);
        }

        for (int i = minR; i < maxR; i++) { // to down
            D.add(board[i][maxC]);
        }

        for (int i = maxC; i > minC; i--) { // to left
            D.add(board[maxR][i]);
        }

        for (int i = maxR; i > minR; i--) { // to up
            D.add(board[i][minC]);
        }

        D.addFirst(D.removeLast());
        for (Integer i : D) {
            min = Math.min(min, i);
        }

        for (int i = minC; i < maxC; i++) { // to right
            board[minR][i] = D.removeFirst();
        }

        for (int i = minR; i < maxR; i++) { // to down
            board[i][maxC] = D.removeFirst();
        }

        for (int i = maxC; i > minC; i--) { // to left
            board[maxR][i] = D.removeFirst();
        }

        for (int i = maxR; i > minR; i--) { // to up
            board[i][minC] = D.removeFirst();
        }

        return min;
    }
}