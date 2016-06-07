import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by dell on 2016/4/27.
 */
public class Share {
    public void  share(Person person, ArrayList<Stock> stocklist) {
        DecimalFormat    df   = new DecimalFormat("######0.00");
        Hashtable<Integer, Integer> stocks = person.stocks;
        System.out.println("序号     股票名     单价    涨跌幅      持有数");
        for (int i = 0; i < 10; i++) {
            Stock temp = stocklist.get(i);
            System.out.println(temp.order + "          " + temp.name + "   " + df.format(temp.price)  + "     " + df.format(temp.rise) + "     " + person.stocks.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入'b x n'表示买入序号为x的股票n股；输入's x n'表示卖出序号为x的股票n股,退出x");
        String choice = scanner.next();
        if (choice.equals("x")) {

        } else {
            int ord = Integer.parseInt(scanner.next());
            Stock s = stocklist.get(ord);
            int count = Integer.parseInt(scanner.next());
            if (choice.equals("b")) {
                s.buyStock(count, person);
            } else if(choice.equals("s")){
                s.soldStock(count, person);
            }else{
                System.out.println("输入错误");
            }

        }
    }
}
