package repositories.interfaces;

import model.Trade;

import java.util.List;

public interface ITradeRepository {
    boolean addTrade(Trade trade);
    boolean removeTrade(Trade trade);
    List<Trade> getAll();
    void removeAll();
}
