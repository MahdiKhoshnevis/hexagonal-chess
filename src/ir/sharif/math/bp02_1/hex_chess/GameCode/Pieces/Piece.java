package ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces;

import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Piece {
    public int row;
    public char col;
    public String name;
    public Color color, backColor;
    public boolean firstMove;
    public GameManager gameManager;

    public Piece (int row, char col, String name, Color color, Color backColor, boolean firstMove, GameManager gameManager) {
        this.row = row;
        this.col = col;
        this.name = name;
        this.color = color;
        this.backColor = backColor;
        this.firstMove = firstMove;
        this.gameManager = gameManager;
    }
    public Piece (int row, char col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getBackColor() {
        return backColor;
    }

    public void setBackColor(Color backColor) {
        this.backColor = backColor;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    public boolean isValid (int row, int col, Color color) {
        if (col < 0 || col >= 11) {
            return false;
        }
        if (row < gameManager.min[col] || row > gameManager.max[col]) {
            return false;
        }
        if ((color == Color.BLACK && !gameManager.isBlackMove) ||
                (color == Color.WHITE && gameManager.isBlackMove)) {
            return false;
        }
        if (gameManager.Board[row][col].name != null && gameManager.Board[row][col].color == color) {
            return false;
        }
        return true;
    }
    public boolean isValid2 (int row, int col, Color color) {
        if (col < 0 || col >= 11) {
            return false;
        }
        if (row < gameManager.min[col] || row > gameManager.max[col]) {
            return false;
        }
        if ((color == Color.BLACK && !gameManager.isBlackMove) ||
                (color == Color.WHITE && gameManager.isBlackMove)) {
            return false;
        }
        if (gameManager.Board[row][col].name != null) {
            return false;
        }
        return true;
    }
    public int getValue () {
        if (this instanceof Bishop) {
            if (this.color == Color.BLACK) {
                return 3;
            } else {
                return -3;
            }
        }
        if (this instanceof Rook) {
            if (this.color == Color.BLACK) {
                return 5;
            } else {
                return -5;
            }
        }
        if (this instanceof Queen) {
            if (this.color == Color.BLACK) {
                return 9;
            } else {
                return -9;
            }
        }
        if (this instanceof Pawn) {
            if (this.color == Color.BLACK) {
                return 1;
            } else {
                return -1;
            }
        }
        if (this instanceof Knight) {
            if (this.color == Color.BLACK) {
                return 3;
            } else {
                return -3;
            }
        }
        return 0;
    }
}
