package ir.sharif.math.bp02_1.hex_chess.GameCode;

public interface Directions {
    Pair UP = new Pair(1,0);
    Pair DOWN = new Pair(-1,0);
    Pair UP_LEFT = new Pair(0,-1);
    Pair DOWN_LEFT = new Pair(-1,-1);
    Pair UP_RIGHT = new Pair(1,1);
    Pair DOWN_RIGHT = new Pair(0,1);
    Pair Dia_UP_LEFT = new Pair(1,-1);
    Pair Dia_DOWN_LEFT = new Pair(-2,-1);
    Pair Dia_UP_RIGHT = new Pair(2,1);
    Pair Dia_DOWN_RIGHT = new Pair(-1,1);
    Pair Dia_LEFT = new Pair(-1,-2);
    Pair Dia_RIGHT = new Pair(1,2);
    Pair UP2 = new Pair(2,0);
    Pair DOWN2 = new Pair(-2,0);


}
