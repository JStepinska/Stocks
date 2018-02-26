package services;

import model.Trade;
import repositories.TradeRepository;
import repositories.interfaces.ITradeRepository;
import services.interfaces.ITradeService;

import java.util.ArrayList;
import java.util.List;

public class TradeService implements ITradeService {

    private static final long FIFTEEN_MINUTES = 15 * 60 * 1000;
    private ITradeRepository tradeRepository;

    public TradeService(TradeRepository _tradeRepository) {
        this.tradeRepository = _tradeRepository;
    }

    public double calculateVolumeWeightedStockPrice() {
        List<Trade> lastTrades = new ArrayList<>();
        double nominator = 0;
        double denominator = 0;
        long fifteenAgo = System.currentTimeMillis() - FIFTEEN_MINUTES;
        for(Trade trade : tradeRepository.getAll()) {
            if(trade.getTimestamp().getTime() > fifteenAgo) {
                lastTrades.add(trade);
                nominator += trade.getQuanityOfShares() * trade.getPrice();
                denominator += trade.getQuanityOfShares();
            }
        }
        return denominator != 0 ? nominator/denominator : 0d;
    }

    public double calculateAllShareIndex() {
        List<Trade> allTrades = tradeRepository.getAll();
        double product = 1;
        for(Trade trade: allTrades) {
            product *= trade.getPrice();
        }
        return Math.pow(product, 1.0 / allTrades.size());
    }

    public boolean addTrade(Trade trade) {
        return this.tradeRepository.addTrade(trade);
    }

    public boolean removeTrade(Trade trade) {
        return this.tradeRepository.removeTrade(trade);
    }

    public List<Trade> getAll() {
        return this.tradeRepository.getAll();
    }

    public void removeAll() {
        this.tradeRepository.removeAll();
    }

}
