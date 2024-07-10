package ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces;

import ir.sharif.math.bp02_1.hex_chess.GameCode.Directions;
import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pair;

import java.awt.*;

public class Bishop extends Piece implements Directions {
    GameManager gameManager;
    public Bishop(int row, char col, String name, Color color, Color backColor, boolean firstMove, GameManager gameManager) {
        super(row, col, name, color, backColor, firstMove, gameManager);
        this.gameManager = gameManager;
    }
    public void move (int row, int col) {
        Color color = gameManager.Board[row][col].color;
        int tempRow = row, tempCol = col;
        while (isValid(row+Dia_DOWN_LEFT.first, col+Dia_DOWN_LEFT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_DOWN_LEFT.first, col+Dia_DOWN_LEFT.second));
            row += Dia_DOWN_LEFT.first; col += Dia_DOWN_LEFT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+Dia_DOWN_RIGHT.first, col+Dia_DOWN_RIGHT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_DOWN_RIGHT.first, col+Dia_DOWN_RIGHT.second));
            row += Dia_DOWN_RIGHT.first; col += Dia_DOWN_RIGHT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+Dia_UP_LEFT.first, col+Dia_UP_LEFT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_UP_LEFT.first, col+Dia_UP_LEFT.second));
            row += Dia_UP_LEFT.first; col += Dia_UP_LEFT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+Dia_UP_RIGHT.first, col+Dia_UP_RIGHT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_UP_RIGHT.first, col+Dia_UP_RIGHT.second));
            row += Dia_UP_RIGHT.first; col += Dia_UP_RIGHT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+Dia_LEFT.first, col+Dia_LEFT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_LEFT.first, col+Dia_LEFT.second));
            row += Dia_LEFT.first; col += Dia_LEFT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+Dia_RIGHT.first, col+Dia_RIGHT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+Dia_RIGHT.first, col+Dia_RIGHT.second));
            row += Dia_RIGHT.first; col += Dia_RIGHT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
    }
}
