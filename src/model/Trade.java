package model;

import java.sql.Timestamp;

public class Trade {

    private Timestamp timestamp;
    private long quanityOfShares;
    private double buyIndicator;
    private double sellIndicator;
    private double price;

    public Trade() {
    }

    public Trade(Timestamp timestamp, long quanityOfShares, double buyIndicator, double sellIndicator, double price) {
        this.timestamp = timestamp;
        this.quanityOfShares = quanityOfShares;
        this.buyIndicator = buyIndicator;
        this.sellIndicator = sellIndicator;
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getQuanityOfShares() {
        return quanityOfShares;
    }

    public void setQuanityOfShares(long quanityOfShares) {
        this.quanityOfShares = quanityOfShares;
    }

    public double getBuyIndicator() {
        return buyIndicator;
    }

    public void setBuyIndicator(double buyIndicator) {
        this.buyIndicator = buyIndicator;
    }

    public double getSellIndicator() {
        return sellIndicator;
    }

    public void setSellIndicator(double sellIndicator) {
        this.sellIndicator = sellIndicator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
