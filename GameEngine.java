import java.util.ArrayList;

public class GameEngine {
    Player p1;
    Player p2;
    Boolean currentChoice = true; // True means player one
    Boolean isGameOn = true;
    int choice = 0;

    public boolean checkVertical(int start1, int start2, int end1, int end2, String[][] board) {
        if (board[start1][start2] != null && board[start1][start2].equals(board[start1 + 1][start2])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public boolean checkHorizontal(int start1, int start2, int end1, int end2, String[][] board) {
        if (board[start1][start2] != null && board[start1][start2].equals(board[start1][start2 + 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonal1(int start1, int start2, int end1, int end2, String[][] board) {
        if (board[start1][start2] != null && board[start1][start2].equals(board[start1 + 1][start2 + 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonal2(int start1, int start2, int end1, int end2, String[][] board) {
        if (board[start1][start2] != null && board[start1][start2].equals(board[start1 + 1][start2 - 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public boolean checkWinningStatus(int position, Player player, String[][] board) {
        boolean isWon = false;
        switch (position) {
            case 1:
                // taken booleans just to remove errors for commit need modification below here
                if (checkVertical(0, 0, 2, 0, board)
                        || checkDiagonal1(0, 0, 2, 2, board)
                        || checkHorizontal(0, 0, 0, 2, board)) {
                    isWon = true;
                }
                break;
            case 2:
                if (checkVertical(0, 1, 2, 1, board)
                        || checkHorizontal(0, 0, 0, 2, board)) {
                    isWon = true;
                }
                break;
            case 3:
                if (checkVertical(0, 2, 2, 2, board)
                        || checkDiagonal2(0, 2, 2, 0, board)
                        || checkHorizontal(0, 0, 0, 2, board)) {
                    isWon = true;
                }
                break;
            case 4:
                if (checkVertical(0, 0, 2, 0,board)
                        || checkHorizontal(1, 0, 1, 2,board)) {
                    isWon = true;
                }
                break;
            case 5:
                if (checkVertical(0, 1, 2, 1,board)
                        || checkDiagonal1(0, 0, 2, 2,board)
                        || checkDiagonal2(0, 2, 2, 0,board)
                        || checkHorizontal(1, 0, 1, 2,board)) {
                    isWon = true;
                }
                break;
            case 6:
                if (checkVertical(0, 2, 2, 2, board)
                        || checkHorizontal(1, 0, 1, 2, board)) {
                    isWon = true;
                }
                break;
            case 7:
                if (checkVertical(0, 0, 2, 0, board)
                        || checkDiagonal2(0, 2, 2, 0, board)
                        || checkHorizontal(2, 0, 2, 2, board)) {
                    isWon = true;
                }
                break;
            case 8:
                if (checkVertical(0, 1, 2, 1, board)
                        || checkHorizontal(2, 0, 2, 2, board)) {
                    isWon = true;
                }
                break;
            case 9:
                if (checkVertical(0, 2, 2, 2, board)
                        || checkDiagonal1(0, 0, 2, 2, board)
                        || checkHorizontal(2, 0, 2, 2, board)) {
                    isWon = true;
                }
                break;
        }
        if (isWon) {
            player.won = true;
            isGameOn = false;
        }
        if (choice == 9) {
            isGameOn = false;
        }
        return isGameOn;
    }

    public void setPosition(String[][] board, Player player) {
        int boxPosition = player.positions.peek();
        switch (boxPosition) {
            case 1:
                board[0][0] = board[0][0] == null || board[0][0].isEmpty()
                        ? player.symbol
                        : board[0][0];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 2:
                board[0][1] = board[0][1] == null || board[0][1].isEmpty()
                        ? player.symbol
                        : board[0][1];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 3:
                board[0][2] = board[0][2] == null || board[0][2].isEmpty()
                        ? player.symbol
                        : board[0][2];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 4:
                board[1][0] = board[1][0] == null || board[1][0].isEmpty()
                        ? player.symbol
                        : board[1][0];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 5:
                board[1][1] = board[1][1] == null || board[1][1].isEmpty()
                        ? player.symbol
                        : board[1][1];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 6:
                board[1][2] = board[1][2] == null || board[1][2].isEmpty()
                        ? player.symbol
                        : board[1][2];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 7:
                board[2][0] = board[2][0] == null || board[2][0].isEmpty()
                        ? player.symbol
                        : board[2][0];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 8:
                board[2][1] = board[2][1] == null || board[2][1].isEmpty()
                        ? player.symbol
                        : board[2][1];
                checkWinningStatus(boxPosition, player, board);
                break;
            case 9:
                board[2][2] = board[2][2] == null || board[2][2].isEmpty()
                        ? player.symbol
                        : board[2][2];
                checkWinningStatus(boxPosition, player, board);
        }
        choice++;
    }

    public void start() {
        Board board = new Board();
        board.showBoard();
        String[][] myBoard = board.board;
        Read read = new Read();
        ArrayList<Player> players = read.playerLogin();
        this.p1 = players.get(0);
        this.p2 = players.get(1);
        System.out.println("Game started!\n");
        while (isGameOn) {
            setPosition(myBoard, read.readPosition(this.currentChoice, players));
            System.out.println();
            board.updatedBoard(myBoard);
            this.currentChoice = !(this.currentChoice);
        }
        if (p1.won) {
            System.out.println("Player 1 has won the match");
            System.out.println("Player 2 better luck next time");
            return;
        }
        if (p2.won) {
            System.out.println("Player 2 has won the match");
            System.out.println("Player 1 better luck next time");
            return;
        }
    }
}
