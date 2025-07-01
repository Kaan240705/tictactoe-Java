package player;
import controller.TicTacToeController;

public class HeuristicPlayer extends ComputerPlayer {
    private final int[] prio = {4, 0, 2, 6, 8, 1, 3, 5, 7};

    @Override
    public int naechsterSpielzug(TicTacToeController controller) {
        for (int feld : prio) {
            if (controller.isFieldFree(feld)) return feld;
        }
        return -1;
    }
}
