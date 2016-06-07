/**
 * Created by dell on 2016/4/24.
 */
public class Dice {

    public int getCount(){
        int count=(int)(1+Math.random()*6);
        System.out.println("您掷出了"+count+"步");
        return  count;
    }
}
