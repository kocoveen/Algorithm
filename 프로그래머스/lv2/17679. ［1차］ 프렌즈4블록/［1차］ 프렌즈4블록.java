import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static int count;
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] cBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cBoard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            int prev = count;
            cBoard = findSameTwoByTwo(m, n, cBoard);
            int next = count;
            if (prev == next) {
                break;
            }
        }
        return count;
    }

    private static void printBoard(char[][] chars) {
        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.printf("%c ", c);
            }
            System.out.println();
        }
    }

    private char[][] findSameTwoByTwo(int m, int n, char[][] cBoard) {
        char[][] markedBlock = markSameBlock(m, n, cBoard);
        return getBlocks(m, n, cBoard, markedBlock);
    }

    private char[][] getBlocks(int m, int n, char[][] cBoard, char[][] markedBlock) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (markedBlock[i][j] == '*') {
                    cBoard[i][j] = '*';
                    count++;
                }
            }
        }


        return fallDown(m, n, cBoard);
    }

    private char[][] markSameBlock(int m, int n, char[][] cBoard) {
        char[][] tmp = new char[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (isSame(cBoard, i, j)) {
                    tmp[i][j] = '*';
                    tmp[i][j + 1] = '*';
                    tmp[i + 1][j] = '*';
                    tmp[i + 1][j + 1] = '*';
                }
            }
        }
        return tmp;
    }

    private char[][] fallDown(int m, int n, char[][] cBoard) {
        Deque<Character> D = new ArrayDeque<>();

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (cBoard[i][j] == '*') {
                    D.addFirst('*');
                } else {
                    D.addLast(cBoard[i][j]);
                }
            }

            for (int i = 0; i < m; i++) {
                cBoard[i][j] = D.removeFirst();
            }
        }
        return cBoard;
    }

    private boolean isSame(char[][] cBoard, int i, int j) {
        if (cBoard[i][j] == '*') {
            return false;
        }

        for (int k = i; k < i + 2; k++) {
            for (int l = j; l < j + 2; l++) {
                if (cBoard[i][j] != cBoard[k][l]) {
                    return false;
                }
            }
        }
        return true;
    }
}
