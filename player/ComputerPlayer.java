package player;
import controller.TicTacToeController;

    /*
    Bestimmt den nächsten Zug des Computers.
    Erwartet den aktuellen Spielzustand über einen TicTacToeController.
    Gibt die Position (0–8) zurück, die der Computer setzen möchte.
    */
    public abstract class ComputerPlayer {
        public abstract int naechsterSpielzug(TicTacToeController controller);
    }
