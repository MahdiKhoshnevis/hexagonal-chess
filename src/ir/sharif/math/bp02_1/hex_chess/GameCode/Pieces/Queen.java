package ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces;

import ir.sharif.math.bp02_1.hex_chess.GameCode.Directions;
import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pair;

import java.awt.*;

public class Queen extends Piece implements Directions {
    public Queen(int row, char col, String name, Color color, Color backColor, boolean firstMove, GameManager gameManager) {
        super(row, col, name, color, backColor, firstMove, gameManager);
    }
    public void move (int row, int col) {
        Color color = gameManager.Board[row][col].color;
        // Bishop
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
        //Rook
        row = tempRow; col = tempCol;
        while (isValid(row+DOWN_LEFT.first, col+DOWN_LEFT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+DOWN_LEFT.first, col+DOWN_LEFT.second));
            row += DOWN_LEFT.first; col += DOWN_LEFT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+DOWN_RIGHT.first, col+DOWN_RIGHT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+DOWN_RIGHT.first, col+DOWN_RIGHT.second));
            row += DOWN_RIGHT.first; col += DOWN_RIGHT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+UP_LEFT.first, col+UP_LEFT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+UP_LEFT.first, col+UP_LEFT.second));
            row += UP_LEFT.first; col += UP_LEFT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+UP_RIGHT.first, col+UP_RIGHT.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+UP_RIGHT.first, col+UP_RIGHT.second));
            row += UP_RIGHT.first; col += UP_RIGHT.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+UP.first, col+UP.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+UP.first, col+UP.second));
            row += UP.first; col += UP.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
        row = tempRow; col = tempCol;
        while (isValid(row+DOWN.first, col+DOWN.second, gameManager.Board[tempRow][tempCol].color)) {
            gameManager.validMoves.add(new Pair(row+DOWN.first, col+DOWN.second));
            row += DOWN.first; col += DOWN.second;
            if (!isValid2(row,col,color)) {
                break;
            }
        }
    }
}
