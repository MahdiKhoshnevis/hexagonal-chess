package ir.sharif.math.bp02_1.hex_chess.GameCode;

import ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces.*;
import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.CompactNumberFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GameManager implements Directions{
    private Application application;
    int lastRow, lastCol, counter;
    public Piece[][]Board = new Piece[11][11];
    public boolean isBlackMove, isSecondClick, isWhiteCheck, isBlackCheck;
    File file = new File("Game.txt");
    Listener listener;
    StringColor []stringColors = new StringColor[36];
    public ArrayList<Pair> validMoves = new ArrayList<>();
    public int []max = new int[11];
    public int []min = new int[11];

    public GameManager(Application application) throws FileNotFoundException {
        this.application = application;
        listener = new Listener(this);
        this.application.registerEventListener(listener);
        for (int i = 0; i < 11; i++) {
            if (i >= 5) {
                max[i] = 10;
                min[i] = i-5;

            } else {
                max[i] = 10-(5-i);
                min[i] = 0;
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = min[i]; j <= max[i]; j++) {
                if (i <= 5) {
                    Board[j][i] = new Piece(j+1, (char)('a'+i));
                } else if (i <= 8) {
                    Board[j][i] = new Piece(j+1-(i-5), (char)('a'+i));
                } else {
                    Board[j][i] = new Piece(j+1-(i-5), (char)('a'+i+1));
                }
            }
        }
        if (!file.exists()) {
            defaulBoard();
        }
        readFile(file);
        Draw();
    }
    public void defaulBoard () throws FileNotFoundException {
        stringColors = new StringColor[36];
        counter = 0;
        isSecondClick = false;
        PrintWriter out = new PrintWriter(file);
        out.println("false");
        out.println("0 1 " + PieceName.WHITE_PAWN + " W F");
        out.println("1 2 " + PieceName.WHITE_PAWN + " W F");
        out.println("2 3 " + PieceName.WHITE_PAWN + " W F");
        out.println("3 4 " + PieceName.WHITE_PAWN + " W F");
        out.println("4 5 " + PieceName.WHITE_PAWN + " W F");
        out.println("4 6 " + PieceName.WHITE_PAWN + " W F");
        out.println("4 7 " + PieceName.WHITE_PAWN + " W F");
        out.println("4 8 " + PieceName.WHITE_PAWN + " W F");
        out.println("4 9 " + PieceName.WHITE_PAWN + " W F");

        out.println("6 1 " + PieceName.BLACK_PAWN + " B F");
        out.println("6 2 " + PieceName.BLACK_PAWN + " B F");
        out.println("6 3 " + PieceName.BLACK_PAWN + " B F");
        out.println("6 4 " + PieceName.BLACK_PAWN + " B F");
        out.println("6 5 " + PieceName.BLACK_PAWN + " B F");
        out.println("7 6 " + PieceName.BLACK_PAWN + " B F");
        out.println("8 7 " + PieceName.BLACK_PAWN + " B F");
        out.println("9 8 " + PieceName.BLACK_PAWN + " B F");
        out.println("10 9 " + PieceName.BLACK_PAWN + " B F");

        out.println("0 2 " + PieceName.WHITE_ROCK + " W F");
        out.println("3 8 " + PieceName.WHITE_ROCK + " W F");
        out.println("0 3 " + PieceName.WHITE_KNIGHT + " W F");
        out.println("2 7 " + PieceName.WHITE_KNIGHT + " W F");
        out.println("0 5 " + PieceName.WHITE_BISHOP + " W F");
        out.println("1 5 " + PieceName.WHITE_BISHOP + " W F");
        out.println("2 5 " + PieceName.WHITE_BISHOP + " W F");
        out.println("0 4 " + PieceName.WHITE_QUEEN + " W F");
        out.println("1 6 " + PieceName.WHITE_KING + " W F");

        out.println("7 2 " + PieceName.BLACK_ROCK + " B F");
        out.println("10 8 " + PieceName.BLACK_ROCK + " B F");
        out.println("8 3 " + PieceName.BLACK_KNIGHT + " B F");
        out.println("10 7 " + PieceName.BLACK_KNIGHT + " B F");
        out.println("10 5 " + PieceName.BLACK_BISHOP + " B F");
        out.println("9 5 " + PieceName.BLACK_BISHOP + " B F");
        out.println("8 5 " + PieceName.BLACK_BISHOP + " B F");
        out.println("9 4 " + PieceName.BLACK_QUEEN + " B F");
        out.println("10 6 " + PieceName.BLACK_KING + " B F");
        out.close();
    }
    public void readFile (File file) throws FileNotFoundException {
        stringColors = new StringColor[36];
        counter = 0;
        isSecondClick = false;
        Scanner sc = new Scanner(file);
        for (int i = 0; i < 11; i++) {
            for (int j = min[i]; j <= max[i]; j++) {
                if (i <= 5) {
                    Board[j][i] = new Piece(j+1, (char)('a'+i));
                } else if (i <= 8) {
                    Board[j][i] = new Piece(j+1-(i-5), (char)('a'+i));
                } else {
                    Board[j][i] = new Piece(j+1-(i-5), (char)('a'+i+1));
                }
            }
        }
        String str = sc.nextLine();
        if (str.equals("true")) {
            isBlackMove = true;
        } else {
            isBlackMove = false;
        }
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            String [] strings = str.split(" ");
            int row = 0, col = 0;
            if (strings[0].length() == 2) {
                row += 10*(strings[0].charAt(0)-'0');
                row += (strings[0].charAt(1)-'0');
            } else {
                row += (strings[0].charAt(0)-'0');
            }
            if (strings[1].length() == 2) {
                col += 10*(strings[1].charAt(0)-'0');
                col += (strings[1].charAt(1)-'0');
            } else {
                col += (strings[1].charAt(0)-'0');
            }
            String name = strings[2];
            Color color;
            if (strings[3].equals("B")) {
                color = Color.BLACK;
            } else {
                color = Color.WHITE;
            }
            if (row == 11 && col == 11) {
                stringColors[counter] = new StringColor(name, color);
                counter++;
            } else {
                boolean firstMove;
                if (strings[4].equals("T")) {
                    firstMove = true;
                } else {
                    firstMove = false;
                }
                if (name.equals(PieceName.BLACK_KING) || name.equals(PieceName.WHITE_KING)) {
                    Board[row][col] = new King(Board[row][col].row, Board[row][col].col, name, color, null, firstMove, this);
                }
                if (name.equals(PieceName.BLACK_KNIGHT) || name.equals(PieceName.WHITE_KNIGHT)) {
                    Board[row][col] = new Knight(Board[row][col].row, Board[row][col].col, name, color, null, firstMove, this);
                }
                if (name.equals(PieceName.BLACK_BISHOP) || name.equals(PieceName.WHITE_BISHOP)) {
                    Board[row][col] = new Bishop(Board[row][col].row, Board[row][col].col, name, color, null, firstMove, this);
                }
                if (name.equals(PieceName.BLACK_PAWN) || name.equals(PieceName.WHITE_PAWN)) {
                    Board[row][col] = new Pawn(Board[row][col].row, Board[row][col].col, name, color, null, firstMove, this);
                }
                if (name.equals(PieceName.BLACK_ROCK) || name.equals(PieceName.WHITE_ROCK)) {
                    Board[row][col] = new Rook(Board[row][col].row, Board[row][col].col, name, color, null, firstMove, this);
                }
                if (name.equals(PieceName.BLACK_QUEEN) || name.equals(PieceName.WHITE_QUEEN)) {
                    Board[row][col] = new Queen(Board[row][col].row, Board[row][col].col, name, color, null, firstMove, this);
                }
            }
        }
    }
    public void writeFile (File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        out.println(isBlackMove);
        for (int i = 0; i < 11; i++) { // ->
            for (int j = min[i]; j <= max[i]; j++) { // |
                if (Board[j][i].name != null) {
                    String color = "", firstMove = "";
                    if (Board[j][i].color == Color.BLACK) {
                        color = "B";
                    } else {
                        color = "W";
                    }
                    if (Board[j][i].firstMove) {
                        firstMove = "T";
                    } else {
                        firstMove = "F";
                    }
                    out.println(j + " " + i + " " + Board[j][i].name + " " + color + " " + firstMove);
                }
            }
        }
        for (int i = 0; i < counter; i++) {
            String color = " ";
            if (stringColors[i].getColor() == Color.BLACK) {
                color = "B";
            } else {
                color = "W";
            }
            out.println("11 11 " + stringColors[i].getText() + " " + color);
        }
        out.close();
    }
    public void clicked (int row, int col) throws FileNotFoundException {
        if (!isSecondClick &&
                ((Board[row][col].color == Color.BLACK && isBlackMove) || (Board[row][col].color == Color.WHITE && !isBlackMove))) {
            isSecondClick = true;
            validMoves.clear();
            if (Board[row][col] instanceof King) {
                ((King)Board[row][col]).move(row, col);
            }
            if (Board[row][col] instanceof Bishop) {
                ((Bishop)Board[row][col]).move(row, col);
            }
            if (Board[row][col] instanceof Rook) {
                ((Rook)Board[row][col]).move(row, col);
            }
            if (Board[row][col] instanceof Queen) {
                ((Queen)Board[row][col]).move(row, col);
            }
            if (Board[row][col] instanceof Pawn) {
                ((Pawn)Board[row][col]).move(row,col);
            }
            if (Board[row][col] instanceof Knight) {
                ((Knight)Board[row][col]).move(row,col);
            }
        } else if (isSecondClick) {
            isSecondClick = false;
            ArrayList<Pair> validCopy = new ArrayList<>();
            for (Pair pair : validMoves) {
                validCopy.add(new Pair(pair.first, pair.second));
            }
            validMoves.clear();
            for (Pair pair : validCopy) {
                if (pair.first == row && pair.second == col) {
                    isBlackMove = !isBlackMove;
                    Piece temp = new Piece(Board[row][col].row, Board[row][col].col);
                    // firstMove lastRow lastCol in case the move wasn't valid
                    boolean firstMove_before = Board[lastRow][lastCol].firstMove;
                    if (Board[row][col].name != null) {
                        if (Board[row][col] instanceof King) {
                            temp = new King(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                    Board[row][col].color, null, Board[row][col].firstMove, this);
                        }
                        if (Board[row][col] instanceof Knight) {
                            temp = new Knight(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                    Board[row][col].color, null, Board[row][col].firstMove, this);
                        }
                        if (Board[row][col] instanceof Queen) {
                            temp = new Queen(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                    Board[row][col].color, null, Board[row][col].firstMove, this);
                        }
                        if (Board[row][col] instanceof Rook) {
                            temp = new Rook(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                    Board[row][col].color, null, Board[row][col].firstMove, this);
                        }
                        if (Board[row][col] instanceof Bishop) {
                            temp = new Bishop(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                    Board[row][col].color, null, Board[row][col].firstMove, this);
                        }
                        if (Board[row][col] instanceof Pawn) {
                            temp = new Pawn(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                    Board[row][col].color, null, Board[row][col].firstMove, this);
                        }
                    }
                    if (Board[lastRow][lastCol] instanceof King) {
                        Board[row][col] = new King(Board[row][col].row, Board[row][col].col, Board[lastRow][lastCol].name,
                                Board[lastRow][lastCol].color, null, true, this);
                        Board[lastRow][lastCol] = new Piece(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col);
                    }
                    if (Board[lastRow][lastCol] instanceof Bishop) {
                        Board[row][col] = new Bishop(Board[row][col].row, Board[row][col].col, Board[lastRow][lastCol].name,
                                Board[lastRow][lastCol].color, null, true, this);
                        Board[lastRow][lastCol] = new Piece(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col);
                    }
                    if (Board[lastRow][lastCol] instanceof Rook) {
                        Board[row][col] = new Rook(Board[row][col].row, Board[row][col].col, Board[lastRow][lastCol].name,
                                Board[lastRow][lastCol].color, null, true, this);
                        Board[lastRow][lastCol] = new Piece(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col);
                    }
                    if (Board[lastRow][lastCol] instanceof Queen) {
                        Board[row][col] = new Queen(Board[row][col].row, Board[row][col].col, Board[lastRow][lastCol].name,
                                Board[lastRow][lastCol].color, null, true, this);
                        Board[lastRow][lastCol] = new Piece(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col);
                    }
                    if (Board[lastRow][lastCol] instanceof Pawn) {
                        Board[row][col] = new Pawn(Board[row][col].row, Board[row][col].col, Board[lastRow][lastCol].name,
                                Board[lastRow][lastCol].color, null, true, this);
                        Board[lastRow][lastCol] = new Piece(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col);
                    }
                    if (Board[lastRow][lastCol] instanceof Knight) {
                        Board[row][col] = new Knight(Board[row][col].row, Board[row][col].col, Board[lastRow][lastCol].name,
                                Board[lastRow][lastCol].color, null, true, this);
                        Board[lastRow][lastCol] = new Piece(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col);
                    }
                    // check for checks
                    if (!isValid()) {
                        if (Board[row][col] instanceof King) {
                            Board[lastRow][lastCol] = new King(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Bishop) {
                            Board[lastRow][lastCol] = new Bishop(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Rook) {
                            Board[lastRow][lastCol] = new Rook(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Queen) {
                            Board[lastRow][lastCol] = new Queen(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Pawn) {
                            Board[lastRow][lastCol] = new Pawn(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Knight) {
                            Board[lastRow][lastCol] = new Knight(Board[lastRow][lastCol].row, Board[lastRow][lastCol].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        Board[row][col] = temp;
                        isBlackMove = !isBlackMove;
                    } else {
                        isWhiteCheck = false;
                        isBlackCheck = false;
                        if (temp instanceof King || temp instanceof Queen || temp instanceof Rook
                                || temp instanceof Knight || temp instanceof Bishop || temp instanceof Pawn) {
                            stringColors[counter] = new StringColor(temp.name, temp.color);
                            counter++;
                            points();
                        }
                        if (Board[row][col] instanceof Pawn) {
                            if (row == max[col] && Board[row][col].color == Color.WHITE) {
                                String str = application.showPromotionPopup();
                                if (str.equals("Knight")) {
                                    Board[row][col] = new Knight(Board[row][col].row, Board[row][col].col, PieceName.WHITE_KNIGHT,
                                            Color.WHITE, null, true, this);
                                } else if (str.equals("Bishop")) {
                                    Board[row][col] = new Bishop(Board[row][col].row, Board[row][col].col, PieceName.WHITE_BISHOP,
                                            Color.WHITE, null, true, this);

                                } else if (str.equals("Queen")) {
                                    Board[row][col] = new Queen(Board[row][col].row, Board[row][col].col, PieceName.WHITE_QUEEN,
                                            Color.WHITE, null, true, this);

                                } else if (str.equals("Rook")) {
                                    Board[row][col] = new Rook(Board[row][col].row, Board[row][col].col, PieceName.WHITE_ROCK,
                                            Color.WHITE, null, true, this);

                                }
                                points();
                            } else if (row == min[col] && Board[row][col].color == Color.BLACK) {
                                String str = application.showPromotionPopup();
                                if (str.equals("Knight")) {
                                    Board[row][col] = new Knight(Board[row][col].row, Board[row][col].col, PieceName.BLACK_KNIGHT,
                                            Color.BLACK, null, true, this);
                                } else if (str.equals("Bishop")) {
                                    Board[row][col] = new Bishop(Board[row][col].row, Board[row][col].col, PieceName.BLACK_BISHOP,
                                            Color.BLACK, null, true, this);

                                } else if (str.equals("Queen")) {
                                    Board[row][col] = new Queen(Board[row][col].row, Board[row][col].col, PieceName.BLACK_QUEEN,
                                            Color.BLACK, null, true, this);

                                } else if (str.equals("Rook")) {
                                    Board[row][col] = new Rook(Board[row][col].row, Board[row][col].col, PieceName.BLACK_ROCK,
                                            Color.BLACK, null, true, this);

                                }
                                points();
                            }
                        }
                        isBlackMove = !isBlackMove;
                        if (isCheck()) {
                            isBlackMove = !isBlackMove;
                            if (isThereAMove()) {
                                if (!isBlackMove) {
                                    isWhiteCheck = true;
                                } else {
                                    isBlackCheck = true;
                                }
                                application.showMessagePopup("CHECK");
                            } else {
                                application.showMessagePopup("MATE!");
                                defaulBoard();
                                readFile(file);
                                Draw();
                            }
                            isBlackMove = !isBlackMove;
                        } else {
                            isBlackMove = !isBlackMove;
                            if (!isThereAMove()) {
                                application.showMessagePopup("STALEMATE");
                                defaulBoard();
                                readFile(file);
                                Draw();
                            }
                            isBlackMove = !isBlackMove;
                        }
                        isBlackMove = !isBlackMove;
                    }
                }
            }
            for (int i = 0; i < 11; i++) {
                for (int j = min[i]; j <= max[i]; j++) {
                    if (isWhiteCheck && Board[j][i].name != null && Board[j][i].name.equals(PieceName.WHITE_KING)) {
                        Board[j][i].backColor = Color.decode("#B00020");
                    } else if (!isWhiteCheck && Board[j][i].name != null && Board[j][i].name.equals(PieceName.WHITE_KING)) {
                        Board[j][i].backColor = null;
                    }
                    if (isBlackCheck && Board[j][i].name != null && Board[j][i].name.equals(PieceName.BLACK_KING)) {

                        Board[j][i].backColor = Color.decode("#B00020");
                    } else if (!isBlackCheck && Board[j][i].name != null && Board[j][i].name.equals(PieceName.BLACK_KING)) {
                        Board[j][i].backColor = null;
                    }
                }
            }
        }
        //draw the board
        for (Pair pair : validMoves) {
            Board[pair.first][pair.second].backColor = Color.decode("#41FF35");
        }
        Board[row][col].backColor = Color.decode("#1E37FF");
        Draw();
        Board[row][col].backColor = null;
        for (Pair pair : validMoves) {
            Board[pair.first][pair.second].backColor = null;
        }
        //
        lastRow = row;
        lastCol = col;
        writeFile(file);
    }
    private boolean isThereAMove () {
        boolean ans = false;
        for (int i = 0; i < 11 && !ans; i++) {
            for (int j = min[i]; j <= max[i] && !ans; j++) {
                if ((isBlackMove && Board[j][i].color == Color.BLACK) || (!isBlackMove && Board[j][i].color == Color.WHITE)) {
                    validMoves.clear();
                    if (Board[j][i] instanceof King) {
                        ((King)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Bishop) {
                        ((Bishop)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Rook) {
                        ((Rook)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Queen) {
                        ((Queen)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Pawn) {
                        ((Pawn)Board[j][i]).move(j,i);
                    }
                    if (Board[j][i] instanceof Knight) {
                        ((Knight)Board[j][i]).move(j,i);
                    }
                    ArrayList<Pair> moves = new ArrayList<>();
                    for (Pair pair : validMoves) {
                        moves.add(new Pair(pair.first, pair.second));
                    }
                    validMoves.clear();
                    for (Pair pair1 : moves) {
                        int row = pair1.first, col = pair1.second;
                        Piece temp = new Piece(Board[row][col].row, Board[row][col].col);
                        // because we want to undo the move after we checked it (idk if this is even true)
                        boolean firstMove_before = Board[j][i].firstMove;
                        if (Board[row][col].name != null) {
                            if (Board[row][col] instanceof King) {
                                temp = new King(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                        Board[row][col].color, null, Board[row][col].firstMove, this);
                            }
                            if (Board[row][col] instanceof Knight) {
                                temp = new Knight(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                        Board[row][col].color, null, Board[row][col].firstMove, this);
                            }
                            if (Board[row][col] instanceof Queen) {
                                temp = new Queen(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                        Board[row][col].color, null, Board[row][col].firstMove, this);
                            }
                            if (Board[row][col] instanceof Rook) {
                                temp = new Rook(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                        Board[row][col].color, null, Board[row][col].firstMove, this);
                            }
                            if (Board[row][col] instanceof Bishop) {
                                temp = new Bishop(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                        Board[row][col].color, null, Board[row][col].firstMove, this);
                            }
                            if (Board[row][col] instanceof Pawn) {
                                temp = new Pawn(Board[row][col].row, Board[row][col].col, Board[row][col].name,
                                        Board[row][col].color, null, Board[row][col].firstMove, this);
                            }
                        }
                        if (Board[j][i] instanceof King) {
                            Board[row][col] = new King(Board[row][col].row, Board[row][col].col, Board[j][i].name,
                                    Board[j][i].color, null, true, this);
                            Board[j][i] = new Piece(Board[j][i].row, Board[j][i].col);
                        }
                        if (Board[j][i] instanceof Bishop) {
                            Board[row][col] = new Bishop(Board[row][col].row, Board[row][col].col, Board[j][i].name,
                                    Board[j][i].color, null, true, this);
                            Board[j][i] = new Piece(Board[j][i].row, Board[j][i].col);
                        }
                        if (Board[j][i] instanceof Rook) {
                            Board[row][col] = new Rook(Board[row][col].row, Board[row][col].col, Board[j][i].name,
                                    Board[j][i].color, null, true, this);
                            Board[j][i] = new Piece(Board[j][i].row, Board[j][i].col);
                        }
                        if (Board[j][i] instanceof Queen) {
                            Board[row][col] = new Queen(Board[row][col].row, Board[row][col].col, Board[j][i].name,
                                    Board[j][i].color, null, true, this);
                            Board[j][i] = new Piece(Board[j][i].row, Board[j][i].col);
                        }
                        if (Board[j][i] instanceof Pawn) {
                            Board[row][col] = new Pawn(Board[row][col].row, Board[row][col].col, Board[j][i].name,
                                    Board[j][i].color, null, true, this);
                            Board[j][i] = new Piece(Board[j][i].row, Board[j][i].col);
                        }
                        if (Board[j][i] instanceof Knight) {
                            Board[row][col] = new Knight(Board[row][col].row, Board[row][col].col, Board[j][i].name,
                                    Board[j][i].color, null, true, this);
                            Board[j][i] = new Piece(Board[j][i].row, Board[j][i].col);
                        }
                        isBlackMove = !isBlackMove;
                        if (isValid()) {
                            ans = true;
                        }
                        isBlackMove = !isBlackMove;
                        if (Board[row][col] instanceof King) {
                            Board[j][i] = new King(Board[j][i].row, Board[j][i].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Bishop) {
                            Board[j][i] = new Bishop(Board[j][i].row, Board[j][i].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Rook) {
                            Board[j][i] = new Rook(Board[j][i].row, Board[j][i].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Queen) {
                            Board[j][i] = new Queen(Board[j][i].row, Board[j][i].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Pawn) {
                            Board[j][i] = new Pawn(Board[j][i].row, Board[j][i].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        if (Board[row][col] instanceof Knight) {
                            Board[j][i] = new Knight(Board[j][i].row, Board[j][i].col, Board[row][col].name,
                                    Board[row][col].color, null, firstMove_before, this);
                        }
                        Board[row][col] = temp;
                        if (ans) {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
    private boolean isCheck () {
        for (int i = 0; i < 11; i++) {
            for (int j = min[i]; j <= max[i]; j++) {
                if ((isBlackMove && Board[j][i].color == Color.BLACK) || (!isBlackMove && Board[j][i].color == Color.WHITE)) {
                    validMoves.clear();
                    if (Board[j][i] instanceof King) {
                        ((King)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Bishop) {
                        ((Bishop)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Rook) {
                        ((Rook)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Queen) {
                        ((Queen)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Pawn) {
                        ((Pawn)Board[j][i]).move(j,i);
                    }
                    if (Board[j][i] instanceof Knight) {
                        ((Knight)Board[j][i]).move(j,i);
                    }
                }
                for (Pair pair : validMoves) {
                    if (Board[pair.first][pair.second].name != null &&
                            (Board[pair.first][pair.second].name.equals(PieceName.BLACK_KING) || Board[pair.first][pair.second].name.equals(PieceName.WHITE_KING))) {
                        validMoves.clear();
                        return true;
                    }
                }
                validMoves.clear();
            }
        }
        return false;
    }
    private void points () {
        int point = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = min[i]; j <= max[i]; j++) {
                point += Board[j][i].getValue();
            }
        }
        if (point < 0) {
            String score = "";
            point = Math.abs(point);
            for (int i = 0; i < point; i++) {
                score += "⬜";
            }
            application.showMessagePopup("SCORE = " + point + " (WHITE)\n" + score);
        } else if (point == 0) {
            application.showMessagePopup("SCORE = 0 (TIED)");
        } else {
            String score = "";
            point = Math.abs(point);
            for (int i = 0; i < point; i++) {
                score += "⬛";
            }
            application.showMessagePopup("SCORE = " + point + " (BLACK)\n" + score);
        }
    }
    private boolean isValid () {
        for (int i = 0; i < 11; i++) {
            for (int j = min[i]; j <= max[i]; j++) {
                if ((isBlackMove && Board[j][i].color == Color.BLACK) || (!isBlackMove && Board[j][i].color == Color.WHITE)) {
                    validMoves.clear();
                    if (Board[j][i] instanceof King) {
                        ((King)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Bishop) {
                        ((Bishop)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Rook) {
                        ((Rook)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Queen) {
                        ((Queen)Board[j][i]).move(j, i);
                    }
                    if (Board[j][i] instanceof Pawn) {
                        ((Pawn)Board[j][i]).move(j,i);
                    }
                    if (Board[j][i] instanceof Knight) {
                        ((Knight)Board[j][i]).move(j,i);
                    }
                }
                for (Pair pair : validMoves) {
                    if (Board[pair.first][pair.second].name != null &&
                            (Board[pair.first][pair.second].name.equals(PieceName.BLACK_KING) || Board[pair.first][pair.second].name.equals(PieceName.WHITE_KING))) {
                        validMoves.clear();
                        return false;
                    }
                }
                validMoves.clear();
            }
        }
        return true;
    }
    public boolean compare(StringColor x, StringColor y) {
        int valueX = 0, valueY = 0;
        if (x.getColor() == Color.BLACK) {
            valueX += 5;
        }
        if (y.getColor() == Color.BLACK) {
            valueY += 5;
        }
        if (x.getText().equals(PieceName.BLACK_ROCK) || x.getText().equals(PieceName.WHITE_ROCK)) {
            valueX += 1;
        } else if (x.getText().equals(PieceName.BLACK_KNIGHT) || x.getText().equals(PieceName.WHITE_KNIGHT)) {
            valueX += 2;
        } else if (x.getText().equals(PieceName.BLACK_BISHOP) || x.getText().equals(PieceName.WHITE_BISHOP)) {
            valueX += 3;
        } else if (x.getText().equals(PieceName.BLACK_PAWN) || x.getText().equals(PieceName.WHITE_PAWN)) {
            valueX += 4;
        }
        if (y.getText().equals(PieceName.BLACK_ROCK) || y.getText().equals(PieceName.WHITE_ROCK)) {
            valueY += 1;
        } else if (y.getText().equals(PieceName.BLACK_KNIGHT) || y.getText().equals(PieceName.WHITE_KNIGHT)) {
            valueY += 2;
        } else if (y.getText().equals(PieceName.BLACK_BISHOP) || y.getText().equals(PieceName.WHITE_BISHOP)) {
            valueY += 3;
        } else if (y.getText().equals(PieceName.BLACK_PAWN) || y.getText().equals(PieceName.WHITE_PAWN)) {
            valueY += 4;
        }
        if (valueX <= valueY) {
            return false;
        }
        return true;
    }
    public void Draw () {
        StringColor []stringColorsCopy = new StringColor[counter];
        for (int i = 0; i < counter; i++) {
            for (int j = i+1; j < counter; j++) {
                if (compare(stringColors[i], stringColors[j])) {
                    StringColor temp = new StringColor(stringColors[i].getText(),stringColors[i].getColor());
                    stringColors[i] = new StringColor(stringColors[j].getText(),stringColors[j].getColor());
                    stringColors[j] = new StringColor(temp.getText(),temp.getColor());
                }
            }
        }
        for (int i = 0; i < counter; i++) {
            stringColorsCopy[i] = new StringColor(stringColors[i].getText(), stringColors[i].getColor());
        }
        application.setRemovedPieces(stringColorsCopy);
        if (isBlackMove) {
            if (isSecondClick) {
                application.setMessage("Black's Turn -> Choose your move");
            } else {
                application.setMessage("Black's Turn -> Choose your piece");
            }
        } else {
            if (isSecondClick) {
                application.setMessage("White's Turn -> Choose your move");
            } else {
                application.setMessage("White's Turn -> Choose your piece");
            }
        }
        if (!isBlackMove) {
            for (int i = 0; i < 11; i++) {
                for (int j = min[i]; j <= max[i]; j++) {
                    application.setCellProperties(Board[j][i].row, Board[j][i].col, Board[j][i].name, Board[j][i].backColor, Board[j][i].color);
                }
            }
        } else {
            for (int i = 0; i < 11; i++) {
                for (int j = min[i]; j <= max[i]; j++) {
                    int row = min[i]+max[i]-j;
                    application.setCellProperties(Board[row][i].row, Board[row][i].col, Board[j][i].name, Board[j][i].backColor, Board[j][i].color);
                }
            }
        }
    }
}
