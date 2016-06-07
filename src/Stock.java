import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public class Stock {
    int order;
    String name;
    double price;
    double rise;
    public Stock(int order,String name,double price,double rise ){
        this.order=order;
        this.name=name;
        this.price=price;
        this.rise=rise;
    }

    public void buyStock(int number,Person person){
              if(number*price>(person.deposit+person.cash)){
                  System.out.println("您的资产不够购买股票数量");
              }else {
                  System.out.println("购买成功");
                  double money=number*price;
                  if(money<=person.deposit){
                      person.deposit-=money;

                  }else{
                      person.deposit=0;
                      person.cash-=(money-person.deposit);
                  }

                  person.getStocks().put(order, number);
              }
    }
    public void soldStock(int number,Person person){
        int count=person.getStocks().get(order);
        if(count>=number){
            System.out.println("售出成功");
            double money=number*price;
            count-=number;
            person.getStocks().put(order,count);
            person.deposit+=money;

        }else{
            System.out.println("您并没有足够的股票");
        }

    }
    public void deal(){
        price=price*(1+rise);
    }
}
