/*

TC --> O(1)
SC --> O(1) since we have ROW and COL of size 9,9
 */

class Solution {

    int ROW;
    int COL;

    public boolean isValidSudoku(char[][] board) {

        ROW = board.length;
        COL = board[0].length;

        //check condition for rows
        for (int i = 0; i < ROW; i++) {
            if (!checkRow(i, board)) {
                return false;
            }
        }

        //check condition for cols
        for (int j = 0; j < COL; j++) {
            if (!checkCol(j, board)) {
                return false;
            }
        }

        //check for box
        /*
        (0,0), (0,3), (0,6)
        (3,0), (3,3), (3,6)
        (6,0), (6,3), (6,6)
         */
        for (int k = 0; k <= 6; k += 3) {
            for (int l = 0; l <= 6; l += 3) {
                if (!checkBox(k, l, board)) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean checkRow(int r, char[][] board) {
        HashSet<Character> ls = new HashSet<>();
        for (int j = 0; j < COL; j++) {
            char c = board[r][j];
            if (Character.isDigit(c)) {

                if (ls.contains(board[r][j])) {
                    return false;
                }
                ls.add(board[r][j]);

            }

        }//for
        return true;

    }//method

    public boolean checkCol(int c, char[][] board) {

        HashSet<Character> ls = new HashSet<>();
        for (int i = 0; i < ROW; i++) {
            char ch = board[i][c];
            if (Character.isDigit(ch)) {

                if (ls.contains(board[i][c])) {
                    return false;
                }
                ls.add(board[i][c]);

            }//if

        }//for
        return true;

    }

    public boolean checkBox(int r, int c, char[][] board) {
        HashSet<Character> ls = new HashSet<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                char ch = board[i][j];

                if (Character.isDigit(ch)) {

                    if (ls.contains(board[i][j])) {
                        return false;
                    }
                    ls.add(board[i][j]);

                }//if

            }//if
        }

        return true;

    }
}
