import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public class Lottery extends Event{
    final String type="彩票";
    @Override
    public String toTexture() {
        return "彩";
    }
    public void lottery(Person person,boolean on){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你所想选的幸运数字0~20");
        int number = scanner.nextInt();
        if(number>=0&&number<=20){
            System.out.println("购买成功");
            person.lottery=number;
            if(on){
                int winner=(int)(Math.random()*21);
                if(number==winner){
                    System.out.println("恭喜你中奖了");
                    person.cash+=2000;
                }else{
                    System.out.println("对不起您没有中奖");
                }
            }
        }else{
            System.out.println("输入错误");
            lottery(person,on);
        }

    }



}
