package utils;

public enum StockSymbol {
    TEA("Tea"),
    POP("Pop"),
    ALE("Ale"),
    GIN("Gin"),
    JOE("Joe");

    private final String text;

    StockSymbol(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
