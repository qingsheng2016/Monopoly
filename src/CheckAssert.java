import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by dell on 2016/4/24.
 */
public class CheckAssert {
    public CheckAssert(){

    }
    public void showAssert(ArrayList<Person> personlist){
        DecimalFormat    df   = new DecimalFormat("######0.00");
        System.out.println("玩家资产信息如下：");
        System.out.println("玩家名   点券   现金    存款    房产    资产总额");
        int amount = personlist.size();
        for(int i=0;i<amount;i++){
            double houses=2000*(personlist.get(i).lands.size());
            System.out.println(personlist.get(i).information+"    "+personlist.get(i).stamps+"   "+df.format(personlist.get(i).cash)+"   "+df.format(personlist.get(i).deposit)+"   "+houses+"   "+df.format(personlist.get(i).cash+personlist.get(i).deposit+houses));
        }

    }
}
