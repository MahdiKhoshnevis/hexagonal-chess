package ir.sharif.math.bp02_1.hex_chess.graphics.panel;

import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        requestFocus();
        setBackground(Color.decode("#f7f7f7"));
        setPreferredSize(new Dimension(Config.GAME_WIDTH, Config.GAME_HEIGHT));
    }
}
