import java.util.ArrayList;

/**
 * Created by dell on 2016/4/26.
 */
public class StockMarket {
    ArrayList<Stock> stockList = new ArrayList<Stock>();
    public ArrayList<Stock> list() {
        Stock stock0 = new Stock(0, "中国石油", 7.9, 0.03);
        Stock stock1 = new Stock(1, "中国石化", 10.6, 0.08);
        Stock stock2 = new Stock(2, "中国北车", 5.6, -0.02);
        Stock stock3 = new Stock(3, "工商银行", 15.3, 0.04);
        Stock stock4 = new Stock(4, "建设银行", 6.0, -0.04);
        Stock stock5 = new Stock(5, "长航凤凰", 8.5, 0.05);
        Stock stock6 = new Stock(6, "亚通股份", 9.6, 0.06);
        Stock stock7 = new Stock(7, "宝钢股份", 10.2, -0.07);
        Stock stock8 = new Stock(8, "山东钢铁", 11.4, 0.03);
        Stock stock9 = new Stock(9, "河北钢铁", 4.9, -0.03);
        stockList.add(stock0);
        stockList.add(stock1);
        stockList.add(stock2);
        stockList.add(stock3);
        stockList.add(stock4);
        stockList.add(stock5);
        stockList.add(stock6);
        stockList.add(stock7);
        stockList.add(stock8);
        stockList.add(stock9);

 return stockList;



    }
}
