package ir.sharif.math.bp02_1.hex_chess.graphics.models;


import ir.sharif.math.bp02_1.hex_chess.graphics.util.Config;

import java.awt.*;

public class HexagonHint extends Hexagon implements Paintable {
    final private String hintLabel;

    public HexagonHint(int row, char col, int startX, int startY, String hintLabel) {
        super(row, col, startX, startY);
        this.hintLabel = hintLabel;
    }

    @Override
    public void paint(Graphics2D g2) {
        Polygon p = this.getPolygon();

        g2.setFont(Config.HINT_FONT);
        drawTextOnCenter(g2, p, hintLabel, Color.WHITE);
    }
}
