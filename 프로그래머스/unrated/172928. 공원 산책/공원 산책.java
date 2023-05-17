class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] board = new char[park.length][park[0].length()];
        int R = park.length;
        int C = park[0].length();

        int nx = 0, ny = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                board[i][j] = park[i].charAt(j);
                if (park[i].charAt(j) == 'S') {
                    nx = i;
                    ny = j;
                }
            }

        for (String route : routes) {
            String cmd = route.substring(0, 1);
            int go = Integer.parseInt(route.substring(2));

            int dx = nx, dy = ny;
            switch (cmd) {
                case "S" -> dx = dx + go;
                case "E" -> dy = dy + go;
                case "N" -> dx = dx - go;
                case "W" -> dy = dy - go;
            }
            if (dx < 0 || dx >= R || dy < 0 || dy >= C) continue;
            if (func(cmd, dx, dy, nx, ny, board)) continue;
            nx = dx;
            ny = dy;
        }

        return new int[] {nx, ny};
    }
    
    private boolean func(String cmd, int dx, int dy, int nx, int ny, char[][] board) {
        int start, end;
        switch (cmd) {
            case "S" -> {
                start = nx;
                end = dx;
                for (int i = start; i <= end; i++)
                    if (board[i][ny] == 'X') return true;
            }
            case "E" -> {
                start = ny;
                end = dy;
                for (int i = start; i <= end; i++)
                    if (board[nx][i] == 'X') return true;
            }
            case "N" -> {
                start = nx;
                end = dx;
                for (int i = start; i >= end; i--)
                    if (board[i][ny] == 'X') return true;
            }
            case "W" -> {
                start = ny;
                end = dy;
                for (int i = start; i >= end; i--)
                    if (board[nx][i] == 'X') return true;
            }
        }
        return false;
    }
}