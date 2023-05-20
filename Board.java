public class Board {
    String[][] board;

    Board() {
        board = new String[3][3];
    }

    public void updatedBoard(String[][] changedBoard) {
        System.out.println("+--------+--------+-------+");
        System.out.println("|        |        |       |");
        System.out.println("|   " + (changedBoard[0][0] != null ? changedBoard[0][0] : " ") + "    |   "
                + (changedBoard[0][1] != null ? changedBoard[0][1] : " ") + "    |   " + (changedBoard[0][2] != null ? changedBoard[0][2] : " ")
                + "   |");
        System.out.println("|        |        |       |");
        System.out.println("+--------+--------+-------+");
        System.out.println("|        |        |       |");
        System.out.println("|   " + (changedBoard[1][0] != null ? changedBoard[1][0] : " ") + "    |   "
                + (changedBoard[1][1] != null ? changedBoard[1][1] : " ") + "    |   " + (changedBoard[1][2] != null ? changedBoard[1][2] : " ")
                + "   |");
        System.out.println("|        |        |       |");
        System.out.println("|--------+--------+-------|");
        System.out.println("|        |        |       |");
        System.out.println("|   " + (changedBoard[2][0] != null ? changedBoard[2][0] : " ") + "    |   "
                + (changedBoard[2][1] != null ? changedBoard[2][1] : " ") + "    |   " + (changedBoard[2][2] != null ? changedBoard[2][2] : " ")
                + "   |");
        System.out.println("|        |        |       |");
        System.out.println("+--------+--------+-------+");

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
        System.out.print("\nFollow Up: ");
        System.out.println("When plotting use the above box positions\n");
        System.out.println("************************");
    }
}
