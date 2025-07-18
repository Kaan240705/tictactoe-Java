package controller;
import model.PlayControl;
import player.ComputerPlayer;
import java.util.Scanner;

public class TicTacToeController {
    private final PlayControl control = new PlayControl();

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

    public boolean isFieldFree(int pos) {
        return control.fieldFree(pos);
    }

    public boolean gameOver() {
        return control.gameOver();
    }

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
