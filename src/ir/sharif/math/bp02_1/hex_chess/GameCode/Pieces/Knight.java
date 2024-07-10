package ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces;

import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pair;

import java.awt.*;

public class Knight extends Piece {
    public Knight(int row, char col, String name, Color color, Color backColor, boolean firstMove, GameManager gameManager) {
        super(row, col, name, color, backColor, firstMove, gameManager);
    }
    public void move (int row, int col) {
        if (isValid(row+1, col-2, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+1, col-2));
        }
        if (isValid(row+2, col-1, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+2, col-1));
        }
        if (isValid(row+3, col+1, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+3, col+1));
        }
        if (isValid(row+3, col+2, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+3, col+2));
        }
        if (isValid(row+1, col+3, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+1, col+3));
        }
        if (isValid(row+2, col+3, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row+2, col+3));
        }
        if (isValid(row-2, col+1, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row-2, col+1));
        }
        if (isValid(row-1, col+2, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row-1, col+2));
        }
        if (isValid(row-3, col-1, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row-3, col-1));
        }
        if (isValid(row-3, col-2, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row-3, col-2));
        }
        if (isValid(row-1, col-3, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row-1, col-3));
        }
        if (isValid(row-2, col-3, gameManager.Board[row][col].color)) {
            gameManager.validMoves.add(new Pair(row-2, col-3));
        }

    }
}
