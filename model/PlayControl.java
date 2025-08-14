package model;

/**
 * Verwaltet das Spielfeld und die Spielregeln von Tic-Tac-Toe.
 *
 * Enthält ein 3x3-Array für das Spielfeld, wobei die Werte für leer,
 * Spieler und Computer festgelegt sind. Stellt Methoden bereit, um
 * Züge zu setzen, zu überprüfen, ob ein Feld frei ist, ob das Spiel
 * vorbei ist, und wer gewonnen hat. Außerdem kann der aktuelle
 * Zustand des Spielfelds abgefragt werden.
 */

public class PlayControl {
    private final int[][] pField = new int[3][3];
    private final int none = 0, player = 1, computer = 2;

    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                pField[i][j] = none;
    }

    public void playerSet(int nr) {
        setPoint(nr, player);
    }

    public void computerSet(int nr) {
        setPoint(nr, computer);
    }

    private void setPoint(int pos, int type) {
        int row = pos / 3, col = pos % 3;
        pField[row][col] = type;
    }

    public boolean fieldFree(int nr) {
        int row = nr / 3, col = nr % 3;
        return pField[row][col] == none;
    }

    public boolean gameOver() {
        return winnerIs() != 0 || isFull();
    }

    public boolean playerHasWon() {
        return winnerIs() == player;
    }

    public boolean computerHasWon() {
        return winnerIs() == computer;
    }

    private boolean isFull() {
        for (int[] row : pField)
            for (int cell : row)
                if (cell == none) return false;
        return true;
    }

    private int winnerIs() {
        for (int i = 0; i < 3; i++) {
            if (pField[i][0] != 0 && pField[i][0] == pField[i][1] && pField[i][1] == pField[i][2])
                return pField[i][0];
            if (pField[0][i] != 0 && pField[0][i] == pField[1][i] && pField[1][i] == pField[2][i])
                return pField[0][i];
        }
        if (pField[0][0] != 0 && pField[0][0] == pField[1][1] && pField[1][1] == pField[2][2])
            return pField[0][0];
        if (pField[0][2] != 0 && pField[0][2] == pField[1][1] && pField[1][1] == pField[2][0])
            return pField[0][2];
        return 0;
    }

    public int[][] getBoard() {
        return pField;
    }
}
