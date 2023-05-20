import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Read {
    
    public ArrayList<Player> playerLogin () {
        System.out.println("Player-1 Make your choice :\n");
        System.out.println("+--------+");
        System.out.println("| 1. O   |");
        System.out.println("| 2. X   |");
        System.out.println("+--------+\n");
        System.out.print("Enter your choice: ");

        int playerSymbol = readInput();
        Player p1 = new Player(playerSymbol == 1 ? "O" : "X");
        Player p2 = new Player(p1.symbol.equals("O") ? "X" : "O");
        return new ArrayList<>(Arrays.asList(p1, p2));
    }

    public int readInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        try {
            String input = br.readLine();
            num = Integer.parseInt(input);
        } 
        catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        } 
        catch (NumberFormatException e) {
            System.err.println("Invalid input format: " + e.getMessage());
        }
        return num;
    }

    public Player readPosition(boolean currentChoice, ArrayList<Player> players) {
        Player currentPlayer = currentChoice ? players.get(0) : players.get(1);
        int player = currentChoice ? 1 : 2; 
        System.out.println("Player-" + player + " turn !!\n");
        System.out.print("Enter you box number: ");
        currentPlayer.positions.add(readInput());
        return currentPlayer;
    }

}
