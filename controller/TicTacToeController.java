package controller;
import model.PlayControl;
import player.ComputerPlayer;
import java.util.Scanner;

/* Steuert das Spiel Tic-Tac-Toe */
public class TicTacToeController {
    private final PlayControl control = new PlayControl();

/* 
* Spielfeld als 3x3-Array 
* Werte für leer, Spieler, Computer
*/
public class PlayControl {
    private final int[][] pField = new int[3][3];
    private final int none = 0, player = 1, computer = 2;

/* 
* Startet das Spiel, liest Spielzüge ein und wechselt zwischen Spieler und Computer,
* bis das Spiel beendet ist. Gibt am Ende das Ergebnis aus.
*/
    public void startGame(Scanner scanner, ComputerPlayer computer) {
        control.reset();
        boolean playerTurn = true;

        while (!control.gameOver()) {
            printBoard();
            if (playerTurn) {
                System.out.print("Dein Zug (0–8): ");
                int zug = scanner.nextInt();
                if (control.fieldFree(zug)) {
                    control.playerSet(zug);
                    playerTurn = false;
                } else {
                    System.out.println("Feld belegt! Versuch es erneut.");
                }
            } else {
                int computerZug = computer.naechsterSpielzug(this);
                System.out.println("Computer spielt: " + computerZug);
                control.computerSet(computerZug);
                playerTurn = true;
            }
        }

        printBoard();
        if (control.playerHasWon()) System.out.println("Du hast gewonnen!");
        else if (control.computerHasWon()) System.out.println("Computer hat gewonnen.");
        else System.out.println("Unentschieden.");
    }

    // Prüft, ob ein bestimmtes Feld frei ist
    public boolean isFieldFree(int pos) {
        return control.fieldFree(pos);
    }

    //Prüft, ob das Spiel beendet ist

    public boolean gameOver() {
        return control.gameOver();
    }

   /*
   * Gibt das aktuelle Spielfeld auf der Konsole aus.
   * Wandelt die Zahlenwerte des Spielfelds in Symbole um:
   * 1 = X, 2 = O, 0 = -.
   */
    private void printBoard() {
        int[][] board = control.getBoard();
        System.out.println();
        for (int[] row : board) {
            for (int cell : row) {
                char symbol = switch (cell) {
                    case 1 -> 'X';
                    case 2 -> 'O';
                    default -> '-';
                };
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
