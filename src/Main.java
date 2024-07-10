import ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces.King;
import ir.sharif.math.bp02_1.hex_chess.GameCode.Pieces.Piece;
import ir.sharif.math.bp02_1.hex_chess.graphics.Application;
import ir.sharif.math.bp02_1.hex_chess.graphics.listeners.SystemOutEventListener;
import ir.sharif.math.bp02_1.hex_chess.GameCode.GameManager;
import ir.sharif.math.bp02_1.hex_chess.util.PieceName;

import java.awt.*;
import java.io.FileNotFoundException;

import ir.sharif.math.bp02_1.hex_chess.graphics.models.StringColor;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Application application = new Application();
        GameManager manager = new GameManager(application);
    }
}