import model.StockDetails;
import model.Trade;
import repositories.TradeRepository;
import services.TradeService;
import utils.StockSymbol;
import utils.StockType;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;


public class Main {

    private static TradeRepository tradeRepository = new TradeRepository();
    private static TradeService tradeService = new TradeService(tradeRepository);

    public static void main(String[] args) {

        StockDetails tea = new StockDetails(StockSymbol.TEA, StockType.COMMON, 0, 0, 100);
        StockDetails pop = new StockDetails(StockSymbol.POP, StockType.COMMON, 8, 0, 100);
        StockDetails ale = new StockDetails(StockSymbol.ALE, StockType.COMMON, 23, 0, 60);
        StockDetails gin = new StockDetails(StockSymbol.GIN, StockType.PREFERRED, 8, 2, 100);
        StockDetails joe = new StockDetails(StockSymbol.JOE, StockType.COMMON, 13, 0, 250);

        System.out.println("Examplary result or POP Stock");
        System.out.println("Dividend yield for market price 100: " + pop.calculateDividendYield(100));
        System.out.println("P/E ratio for market price 100: " + pop.calculatePERatio(100));

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        Trade trade1 = new Trade(new Timestamp(now.getTime()), 100, 1, 1, 20);
        Trade trade2 = new Trade(new Timestamp(now.getTime()), 200, 2, 2, 40);

        tradeService.addTrade(trade1);
        tradeService.addTrade(trade2);

        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("Volume Weighted Stock Price for arbitrary data: " + df.format(tradeService.calculateVolumeWeightedStockPrice()));
        System.out.println("GBCE All Share index for arbitrary data: " + df.format((tradeService.calculateAllShareIndex())));
    }
}
