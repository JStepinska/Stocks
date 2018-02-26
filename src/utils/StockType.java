package utils;

public enum StockType {
    COMMON("Common"),
    PREFERRED("Preferred");

    private final String text;

    StockType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
