package ir.sharif.math.bp02_1.hex_chess.graphics.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HintUtil {
    private static final HashMap<Character, Integer> map = new HashMap<>();

    static {
        for (int i = 'a'; i < (int) 'j'; i++) {
            map.put((char) i, i - ((int) 'a') + 1);
        }
        map.put('k', 10);
        map.put('l', 11);
        map.put('z', 0);
        map.put('x', 12);
    }

    private static final Color[] colors = {Color.decode("#985EFF"), Color.decode("#BB86FC"), Color.decode("#7F39FB")};

    public static Color getColor(int i, char c) {
        return colors[((map.get(c) <= 6 ? i + map.get(c) : i - map.get(c)) % 3 + 3) % 3];
    }

    public static int getCol(char c) {
        return map.get(c);
    }

    public static char getCharCol(int x) {
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == x) {
                return e.getKey();
            }
        }
        return 0;
    }

    public static Character[] getChars() {
        ArrayList<Character> l = new ArrayList<>(map.keySet());
        l.remove(Character.valueOf('z'));
        l.remove(Character.valueOf('x'));
        Collections.sort(l);
        Character[] chars = new Character[l.size()];
        chars = l.toArray(chars);
        return chars;
    }
}
