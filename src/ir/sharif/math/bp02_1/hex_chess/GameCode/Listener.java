package ir.sharif.math.bp02_1.hex_chess.GameCode;

import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.EventListener;

import java.io.File;
import java.io.FileNotFoundException;

public class Listener implements EventListener {
    GameManager gameManager;
    File file = new File("Game.txt");
    public Listener (GameManager gameManager) {
        this.gameManager = gameManager;
    }
    @Override
    public void onClick(int row, char col) {
        int Col = (int)col;
        Col -= (int)'a';
        row--;
        if (Col >= 10) {
            Col--;
        }
        try {
            if (Col > 5) {
                row += Col - 5;
            }
            if (!gameManager.isBlackMove) {
                gameManager.clicked(row, Col);
            } else {
                gameManager.clicked(gameManager.min[Col]+gameManager.max[Col]-row,Col);
            }
        }
        catch (Exception e) {

        }
    }

    @Override
    public void onLoad(File file) {
        try {
            gameManager.readFile(file);
            gameManager.Draw();
        }
        catch (Exception e) {

        }
    }

    @Override
    public void onSave(File file) {
        try {
            gameManager.writeFile(file);
        } catch (Exception e) {

        }
    }

    @Override
    public void onNewGame() {
        try {
            gameManager.defaulBoard();
            gameManager.readFile(file);
            gameManager.Draw();
        }
        catch (Exception e) {

        }
    }
}
