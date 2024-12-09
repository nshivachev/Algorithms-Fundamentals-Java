package fundamentals.recursionAndBacktrackingLab;

public class QueensPuzzle {
    private static char[][] board = {
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'}
    };

    public static void main(String[] args) {
        putQueens(0);
    }

    private static void putQueens(int row) {
        if(row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    setQueen(row, col);
                    putQueens(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == '*') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == '*') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == '*') {
                return false;
            }
        }

        return true;
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static void setQueen(int row, int col) {
        board[row][col] = '*';
    }

    private static void printSolution() {
        for (char[] rows : board) {
            for(char col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
