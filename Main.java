import java.util.Arrays;
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
    }

    public void userInputForPlayerLogin() {
        System.out.println("Player-1 Make your choice :\n");
        System.out.println("+--------+");
        System.out.println("| 1. O   |");
        System.out.println("| 2. X   |");
        System.out.println("+--------+\n");

        Scanner scan = new Scanner(System.in);
        int playerSymbol = scan.nextShort();
        // TODO --> validate input
        p1 = new Player(playerSymbol == 1 ? "O" : "X");
        p2 = new Player(p1.symbol.equals("O") ? "X" : "O");
        scan.close();
    }

    public void play() {
        showBoard();
        System.out.println();
        System.out.println("When plotting use the above box positions\n");

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

    public boolean checkDiagonal(int start1, int start2, int end1, int end2) {
        if (board[start1][start2].equals(board[start1 + 1][start2 + 1])
                && board[start1][start2].equals(board[end1][end2])) {
            return true;
        }
        return false;
    }

    public void checkStatus(int position) {
        switch (position) {
            case 1:
                // taken booleans just to remove errors for commit need modification below here
                boolean res1 = checkVertical(0, 0, 2, 0);
                boolean res2 = checkDiagonal(0, 0, 2, 2);
                boolean res3 = checkHorizontal(0, 0, 0, 3);
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

        }
    }

    public void readPosition(int player) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Player-" + player + " turn !!\n");
        System.out.println("Enter you box number: ");
        short boxPosition = scan.nextShort();
        // TODO --> validate input
        switch (boxPosition) {
            case 1:
                this.board[0][0] = this.board[0][0] == null || this.board[0][0].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[0][0];
                checkStatus(boxPosition);
                break;
            case 2:
                this.board[0][1] = this.board[0][1] == null || this.board[0][1].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[0][1];

                break;
            case 3:
                this.board[0][2] = this.board[0][2] == null || this.board[0][2].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[0][2];

                break;
            case 4:
                this.board[1][0] = this.board[1][0] == null || this.board[1][0].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[1][0];

                break;
            case 5:
                this.board[1][1] = this.board[1][1] == null || this.board[1][1].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[1][1];

                break;
            case 6:
                this.board[1][2] = this.board[1][2] == null || this.board[1][2].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[1][2];

                break;
            case 7:
                this.board[2][0] = this.board[2][0] == null || this.board[2][0].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[2][0];

                break;
            case 8:
                this.board[2][1] = this.board[2][1] == null || this.board[2][1].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[2][1];

                break;
            case 9:
                this.board[2][2] = this.board[2][2] == null || this.board[2][2].isEmpty()
                        ? (player == 1 ? p1.symbol : p2.symbol)
                        : this.board[2][2];

        }

    }
}

public class Main {
    public static void main(String[] args) {
        TikTak game = new TikTak();
        Arrays.asList(game.board).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}