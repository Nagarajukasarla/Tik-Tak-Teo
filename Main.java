import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // try {
        //     new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        // } catch (IOException | InterruptedException e) {
        //     e.printStackTrace();
        // }
        GameEngine loadGame = new GameEngine();
        loadGame.start();
    }
}