package TicTac;

public class Field {

    private int x;
    private int y;
    Sign sign;

    public Field(int x, int y, Sign sign) {
        this.x = x;
        this.y = y;
        this.sign = sign;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Sign getSign() {
        return sign;
    }
}
