package player;
import controller.TicTacToeController;
import java.util.Random;

public class VerySimplePlayer extends ComputerPlayer {
    private final Random rand = new Random();

    /*
       Bestimmt den nächsten Zug des Computers.
       Wählt zufällig ein freies Feld (0–8) aus, bis ein gültiger Zug gefunden wird.
    */
    @Override
    public int naechsterSpielzug(TicTacToeController controller) {
        int zug;
        do {
            zug = rand.nextInt(9);
        } while (!controller.isFieldFree(zug));
        return zug;
    }
}
