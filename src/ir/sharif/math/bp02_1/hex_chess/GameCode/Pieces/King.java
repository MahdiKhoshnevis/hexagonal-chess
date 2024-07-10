package ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces;

import ir.sharif.math.bp02_1.hex_chess.GameCode.Directions;
import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pair;

import java.awt.*;

public class King extends Piece implements Directions {
    public King(int row, char col, String name, Color color, Color backColor, boolean firstMove, GameManager gameManager) {
        super(row, col, name, color, backColor, firstMove, gameManager);
    }
    public void move (int row, int col) {
        if (isValid(row+UP.first, col+UP.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+UP.first, col+UP.second));
        }
        if (isValid(row+DOWN.first, col+DOWN.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+DOWN.first, col+DOWN.second));
        }
        if (isValid(row+UP_LEFT.first, col+UP_LEFT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+UP_LEFT.first, col+UP_LEFT.second));
        }
        if (isValid(row+UP_RIGHT.first, col+UP_RIGHT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+UP_RIGHT.first, col+UP_RIGHT.second));
        }
        if (isValid(row+DOWN_LEFT.first, col+DOWN_LEFT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+DOWN_LEFT.first, col+DOWN_LEFT.second));
        }
        if (isValid(row+DOWN_RIGHT.first, col+DOWN_RIGHT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+DOWN_RIGHT.first, col+DOWN_RIGHT.second));
        }
        if (isValid(row+Dia_UP_LEFT.first, col+Dia_UP_LEFT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_UP_LEFT.first, col+Dia_UP_LEFT.second));
        }
        if (isValid(row+Dia_DOWN_LEFT.first, col+Dia_DOWN_LEFT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_DOWN_LEFT.first, col+Dia_DOWN_LEFT.second));
        }
        if (isValid(row+Dia_LEFT.first, col+Dia_LEFT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_LEFT.first, col+Dia_LEFT.second));
        }
        if (isValid(row+Dia_UP_RIGHT.first, col+Dia_UP_RIGHT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_UP_RIGHT.first, col+Dia_UP_RIGHT.second));
        }
        if (isValid(row+Dia_DOWN_RIGHT.first, col+Dia_DOWN_RIGHT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_DOWN_RIGHT.first, col+Dia_DOWN_RIGHT.second));
        }
        if (isValid(row+Dia_RIGHT.first, col+Dia_RIGHT.second, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_RIGHT.first, col+Dia_RIGHT.second));
        }
    }
}
