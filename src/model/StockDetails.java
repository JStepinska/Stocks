package model;

import utils.StockSymbol;
import utils.StockType;

public class StockDetails {

    private StockSymbol symbol;
    private StockType type;
    private double lastDividend;
    private double fixedDividend;
    private double parValue;

    public StockDetails() {}

    public StockDetails(StockSymbol symbol, StockType type, double lastDividend, double fixedDividend, double parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }

    public StockSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(StockSymbol symbol) {
        this.symbol = symbol;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(double lastDividend) {
        this.lastDividend = lastDividend;
    }

    public double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(double fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public double getParValue() {
        return parValue;
    }

    public void setParValue(double parValue) {
        this.parValue = parValue;
    }

    public double calculateDividendYield(double marketPrice) {
        double result = 0;
        if(marketPrice != 0) {
            if(StockType.COMMON.equals(this.type)) {
                result = this.lastDividend / marketPrice;
            } else if (StockType.PREFERRED.equals(this.type)) {
                result = (this.fixedDividend + this.parValue) / marketPrice;
            }
        }
        return result;
    }

    public double calculatePERatio(double marketPrice) {
        double result = 0;
        if(marketPrice != 0) {
            double dividend = this.calculateDividendYield(marketPrice);
            if(dividend != 0) {
                result = marketPrice / dividend;
            }
        }
        return result;
    }

}
