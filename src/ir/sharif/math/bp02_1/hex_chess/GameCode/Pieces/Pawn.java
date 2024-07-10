package ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces;

import ir.sharif.math.bp02_1.hex_chess.GameCode.Directions;
import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pair;

import java.awt.*;

public class Pawn extends Piece implements Directions {
    public Pawn(int row, char col, String name, Color color, Color backColor, boolean firstMove, GameManager gameManager) {
        super(row, col, name, color, backColor, firstMove, gameManager);
    }
    public void move (int row, int col) {
        if (gameManager.Board[row][col].color == Color.WHITE) {
            if (isValid2(row + UP.first, col + UP.second, Color.WHITE)) {
                gameManager.validMoves.add(new Pair(row + UP.first, col + UP.second));
                if (!firstMove && isValid2(row + UP2.first, col + UP2.second, Color.WHITE)) {
                    gameManager.validMoves.add(new Pair(row + UP2.first, col + UP2.second));
                }
            }
            if (isValidToHit(row+UP_LEFT.first, col+UP_LEFT.second, Color.BLACK)) {
                gameManager.validMoves.add(new Pair(row + UP_LEFT.first, col + UP_LEFT.second));
            }
            if (isValidToHit(row+UP_RIGHT.first, col+UP_RIGHT.second, Color.BLACK)) {
                gameManager.validMoves.add(new Pair(row + UP_RIGHT.first, col + UP_RIGHT.second));
            }
        } else {
            if (isValid2(row + DOWN.first, col + DOWN.second, Color.BLACK)) {
                gameManager.validMoves.add(new Pair(row + DOWN.first, col + DOWN.second));
                if (!firstMove && isValid2(row + DOWN2.first, col + DOWN2.second, Color.BLACK)) {
                    gameManager.validMoves.add(new Pair(row + DOWN2.first, col + DOWN2.second));
                }
            }
            if (isValidToHit(row+DOWN_LEFT.first, col+DOWN_LEFT.second, Color.WHITE)) {
                gameManager.validMoves.add(new Pair(row + DOWN_LEFT.first, col + DOWN_LEFT.second));
            }
            if (isValidToHit(row+DOWN_RIGHT.first, col+DOWN_RIGHT.second, Color.WHITE)) {
                gameManager.validMoves.add(new Pair(row + DOWN_RIGHT.first, col + DOWN_RIGHT.second));
            }
        }
    }
    private boolean isValidToHit (int row, int col, Color color) {
        if (col < 0 || col >= 11) {
            return false;
        }
        if (row < gameManager.min[col] || row > gameManager.max[col]) {
            return false;
        }
        if (gameManager.Board[row][col].name != null && gameManager.Board[row][col].color == color) {
            return true;
        }
        return false;
    }
}
