import controller.TicTacToeController;
import player.ComputerPlayer;
import player.HeuristicPlayer;
import player.VerySimplePlayer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToeController controller = new TicTacToeController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wähle Computergegner:");
        System.out.println("1 = Zufällig | 2 = Heuristik");
        int wahl = scanner.nextInt();
        ComputerPlayer computer = (wahl == 2) ? new HeuristicPlayer() : new VerySimplePlayer();

        controller.startGame(scanner, computer);
    }
}
