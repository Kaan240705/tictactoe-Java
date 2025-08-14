package model;

    // Setzt alle Felder des Spielfelds auf leer
    public void reset() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                pField[i][j] = none;
    }

    // Setzt das Feld an der angegebenen Position für den Spieler
    public void playerSet(int nr) {
        setPoint(nr, player);
    }

    // Setzt das Feld an der angegebenen Position für den Computer
    public void computerSet(int nr) {
        setPoint(nr, computer);
    }

    // Setzt ein Feld an der gegebenen Position mit dem angegebenen Typ (Spieler oder Computer)
    private void setPoint(int pos, int type) {
        int row = pos / 3, col = pos % 3;
        pField[row][col] = type;
    }

    // Prüft, ob das Feld an der angegebenen Position frei ist
    public boolean fieldFree(int nr) {
        int row = nr / 3, col = nr % 3;
        return pField[row][col] == none;
    }

    // Prüft, ob das Spiel vorbei ist (Sieg oder volles Spielfeld)
    public boolean gameOver() {
        return winnerIs() != 0 || isFull();
    }

    // Prüft, ob der Spieler gewonnen hat
    public boolean playerHasWon() {
        return winnerIs() == player;
    }

    // Prüft, ob der Computer gewonnen hat
    public boolean computerHasWon() {
        return winnerIs() == computer;
    }

    // Prüft, ob das Spielfeld voll ist
    private boolean isFull() {
        for (int[] row : pField)
            for (int cell : row)
                if (cell == none) return false;
        return true;
    }

    // Prüft, ob es einen Gewinner gibt und gibt den Typ (Spieler oder Computer) zurück, sonst 0
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

    // Gibt das aktuelle Spielfeld zurück
    public int[][] getBoard() {
        return pField;
    }
}
