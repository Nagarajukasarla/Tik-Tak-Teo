import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Player {
    public String symbol;
    public boolean won;

    Player(String symbol) {
        this.symbol = symbol;
    }
}

class TikTak {
    Player p1;
    Player p2;
    String[][] board;
    boolean currentChoice;
    Boolean draw = false;

    TikTak() {
        board = new String[3][3];
    }

    public void showBoard() {
        System.out.println("+--------+--------+-------+");
        System.out.println("|        |        |       |");
        System.out.println("|   1    |   2    |   3   |");
        System.out.println("|        |        |       |");
        System.out.println("|--------+--------+-------|");
        System.out.println("|        |        |       |");
        System.out.println("|   4    |   5    |   6   |");
        System.out.println("|        |        |       |");
        System.out.println("|--------+--------+-------|");
        System.out.println("|        |        |       |");
        System.out.println("|   7    |   8    |   9   |");
        System.out.println("|        |        |       |");
        System.out.println("+--------+--------+-------+");
        System.out.println("\n");
        System.out.println("When plotting use the above box positions\n");
    }

    public void userInputForPlayerLogin() {
        System.out.println("Player-1 Make your choice :\n");
        System.out.println("+--------+");
        System.out.println("| 1. O   |");
        System.out.println("| 2. X   |");
        System.out.println("+--------+\n");

        System.out.print ("Enter your choice: ");
        Scanner scan = new Scanner(System.in);
        int playerSymbol = Integer.valueOf(scan.nextLine());
        // TODO --> validate input
        p1 = new Player(playerSymbol == 1 ? "O" : "X");
        p2 = new Player(p1.symbol.equals("O") ? "X" : "O");
        scan.close();
    }

    public boolean checkVertical(int start1, int start2, int end1, int end2) {
        if (board[start1][start2].equals(board[start1 + 1][start2])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public boolean checkHorizontal(int start1, int start2, int end1, int end2) {
        if (board[start1][start2].equals(board[start1][start2 + 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonal1 (int start1, int start2, int end1, int end2) {
        if (board[start1][start2].equals(board[start1 + 1][start2 + 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }
    public boolean checkDiagonal2 (int start1, int start2, int end1, int end2) {
        if (board[start1][start2].equals(board[start1 + 1][start2 - 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public void checkWinningStatus(int position, int player) {
        boolean isWon = false;
        switch (position) {
            case 1:
                // taken booleans just to remove errors for commit need modification below here
                if (checkVertical(0, 0, 2, 0) || checkDiagonal1(0, 0, 2, 2) || checkHorizontal(0, 0, 0, 2)) {
                    isWon = true;
                }
                break;
            case 2:
                if (checkVertical(0, 1, 2, 1) || checkHorizontal(0, 0, 0, 2)) {
                    isWon = true;
                }
                break;
            case 3:
                if (checkVertical(0, 2, 2, 2) || checkDiagonal2(0, 2, 2, 0) || checkHorizontal(0, 0, 0, 2)) {
                    isWon = true;
                }
                break;
            case 4:
                if (checkVertical(0, 0, 2, 0) || checkHorizontal(1, 0, 1, 2)) {
                    isWon = true;
                }
                break;
            case 5:
                if (checkVertical(0, 1, 2, 1) || checkDiagonal1(0, 0, 2, 2) || checkDiagonal2(0, 2, 2, 0) || checkHorizontal(1, 0, 1, 2)) {
                    isWon = true;
                }
                break;
            case 6:
                if (checkVertical(0, 2, 2, 2) || checkHorizontal(1, 0, 1, 2)) {
                    isWon = true;
                }
                break;
            case 7:
                if (checkVertical(0, 0, 2, 0) || checkDiagonal2(0, 2, 2, 0) || checkHorizontal(2, 0, 2, 2)) {

                }
                break;
            case 8:
                if (checkVertical(0, 1, 2, 1) || checkHorizontal(2, 0, 2, 2)) {

                }
                break;
            case 9:
                if (checkVertical(0, 2, 2, 2) || checkDiagonal1(0, 0, 2, 2) || checkHorizontal(2, 0, 2, 2)) {
                    isWon = true;
                }
                break;
        }
        if (isWon) {
            this.p1.won = player == 1 ? isWon : this.p1.won;
            this.p2.won = player == 2 ? isWon : this.p2.won;
        }
    }

    public void readPosition(boolean currentChoice) {
        int player = currentChoice ? 1 : 2;
        Scanner readInput = new Scanner(System.in);
        System.out.println("Player-" + player + " turn !!\n");
        System.out.print ("Enter you box number: ");
        int boxPosition = -1;
        try {
            boxPosition = Integer.parseInt(readInput.nextLine());
        }
        catch (NoSuchElementException e) {
            readInput.nextLine();
            readPosition(currentChoice);
            return;
        }
        switch (boxPosition) {
            case 1:
                this.board[0][0] = this.board[0][0] == null || this.board[0][0].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[0][0];
                checkWinningStatus(boxPosition, player);
                break;
            case 2:
                this.board[0][1] = this.board[0][1] == null || this.board[0][1].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[0][1];
                checkWinningStatus(boxPosition, player);
                break;
            case 3:
                this.board[0][2] = this.board[0][2] == null || this.board[0][2].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[0][2];
                checkWinningStatus(boxPosition, player);
                break;
            case 4:
                this.board[1][0] = this.board[1][0] == null || this.board[1][0].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[1][0];
                checkWinningStatus(boxPosition, player);
                break;
            case 5:
                this.board[1][1] = this.board[1][1] == null || this.board[1][1].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[1][1];
                checkWinningStatus(boxPosition, player);
                break;
            case 6:
                this.board[1][2] = this.board[1][2] == null || this.board[1][2].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[1][2];
                checkWinningStatus(boxPosition, player);
                break;
            case 7:
                this.board[2][0] = this.board[2][0] == null || this.board[2][0].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[2][0];
                checkWinningStatus(boxPosition, player);
                break;
            case 8:
                this.board[2][1] = this.board[2][1] == null || this.board[2][1].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[2][1];
                checkWinningStatus(boxPosition, player);
                break;
            case 9:
                this.board[2][2] = this.board[2][2] == null || this.board[2][2].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[2][2];
                checkWinningStatus(boxPosition, player);

        }
        
    }

    public void loadGame () {
        showBoard();
        userInputForPlayerLogin();
        play();
    }

    public void play() {
        this.currentChoice = true;
        while (!(this.p1.won) || !(this.p2.won) || !(this.draw)) {
            readPosition(this.currentChoice);
            this.currentChoice = !this.currentChoice;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TikTak game = new TikTak();
        game.loadGame();
    }
}