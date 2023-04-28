import java.util.Scanner;

class Player {
    public String symbol;
    public boolean won;
    Player (String symbol) {
        this.symbol = symbol;
    }
}

class TikTak {
    Player p1;
    Player p2;

    String[][] table = { null };

    public void userInputForPlayerLogin() {
        System.out.println("Player-1 Make your choice :\n");
        System.out.println("+--------+");
        System.out.println("| 1. O   |");
        System.out.println("| 2. X   |");
        System.out.println("+--------+\n");

        Scanner scan = new Scanner(System.in);
        int playerSymbol = scan.nextShort();
        p1 = new Player(playerSymbol == 1 ? "O" : "X");
        p2 = new Player(p1.symbol.equals("O") ? "X" : "O");
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}