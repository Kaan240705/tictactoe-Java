package player;
import controller.TicTacToeController;
import java.util.Random;

public class VerySimplePlayer extends ComputerPlayer {
    private final Random rand = new Random();

    @Override
    public int naechsterSpielzug(TicTacToeController controller) {
        int zug;
        do {
            zug = rand.nextInt(9);
        } while (!controller.isFieldFree(zug));
        return zug;
    }
}
