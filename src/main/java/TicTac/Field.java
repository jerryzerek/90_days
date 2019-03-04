package TicTac;

public enum Field {
    FLD_CROSS("X"),
    FLD_CIRCLE("O"),
    FLD_EMPTY(" ");

    private String field;

    Field(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

}
