import java.util.Stack;

public class Player {
    public String symbol;
    public boolean won;
    Stack<Integer> positions = new Stack<>();

    Player(String symbol) {
        this.symbol = symbol;
    }
    
}