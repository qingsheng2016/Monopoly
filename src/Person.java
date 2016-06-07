import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by dell on 2016/4/24.
 */
public class Person extends Event {
    double cash;
    double deposit;
    int stamps;
    int id;
    int step;
    int lottery;
    //String name;
    //Vector<Card> cards = new Vector<Card>();
    Hashtable<Integer, Integer> cards= new Hashtable<>();
    Hashtable<Integer, Integer> stocks= new Hashtable<>();
    ArrayList<Land> lands = new ArrayList<>();
    public Person(int id, double cash, double deposit, Hashtable<Integer, Integer> cards, Hashtable<Integer, Integer> stocks, ArrayList<Land> lands, int stamps, int step, String  information){
          this.id=id;
          this.cash=cash;
          this.deposit=deposit;
          this.cards=cards;
          this.lands=lands;
          this.stocks=stocks;
          this.stamps=stamps;
        this.step=step;
        this.information=information;


    }
    public double getCash(){
        return cash;
    }
    public double getDeposit(){
        return deposit;
    }

    public Hashtable<Integer, Integer> getCards() {
        return cards;
    }

    public Hashtable<Integer, Integer> getStocks(){
        return stocks;
    }
    public ArrayList<Land> getLands(){
        return lands;
    }

    @Override
    public String toTexture() {
        switch(id){
            case 0:
                return "□";
            case 1:
                return "■";
            case 2:
                return "△";
            case 3:
                return "▲";
        }
        return "";
    }
}
