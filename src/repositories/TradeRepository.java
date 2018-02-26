package repositories;

import model.Trade;
import repositories.interfaces.ITradeRepository;
import java.util.ArrayList;
import java.util.List;

public class TradeRepository implements ITradeRepository {

    List<Trade> trades = new ArrayList();

    public boolean addTrade(Trade trade) {
       return this.trades.add(trade);
    }

    public boolean removeTrade(Trade trade) {
        return this.removeTrade(trade);
    }

    public List<Trade> getAll() {
        return this.trades;
    }

    public void removeAll() {
        this.trades.clear();
    }

}
