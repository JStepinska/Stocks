package services.interfaces;

import model.Trade;

import java.util.List;

public interface ITradeService {

    double calculateVolumeWeightedStockPrice();
    boolean addTrade(Trade trade);
    boolean removeTrade(Trade trade);
    List<Trade> getAll();
    void removeAll();
    double calculateAllShareIndex();

}
