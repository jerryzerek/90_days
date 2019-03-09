package TicTac;

public enum Sign {
    SGN_CROSS("X"),
    SGN_CRICLE("O"),
    SGN_EMPTY(" ");

    private String sign;

    Sign (String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
//dadasd
