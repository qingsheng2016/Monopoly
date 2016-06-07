import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public class PropShop extends Event {
    final String type="道具店";
    @Override
    public String toTexture() {
        return "道";
    }
    public void store(Person person){
        System.out.println("      ///////////道具商店////////////");
        System.out.println("       0    路障卡   价格 点/张  50");
        System.out.println("       1    遥控骰子 价格 点/张  30");
        System.out.println("       2    滞留卡   价格 点/张  25");
        System.out.println("       3    彩票卡   价格 点/张  55");
        System.out.println("       4    均富卡   价格 点/张  80");
        System.out.println("       5    红卡     价格 点/张  60");
        System.out.println("       6    黑卡     价格 点/张  60");

        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("请输入你所需要购买卡片的代号0~6，若不买退出请扣7");
        int card =sc.nextInt();
        if(card>=0&&card<=6){
           switch (card){
               case 0:
                   if(person.stamps>=50){
                         int number=person.cards.get(0)+1;
                         person.cards.put(0,number);
                       person.stamps-=50;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
               case 1:
                   if(person.stamps>=30){
                       int number=person.cards.get(1)+1;
                       person.cards.put(1,number);
                       person.stamps-=30;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
               case 2:
                   if(person.stamps>=25){
                       int number=person.cards.get(2)+1;
                       person.cards.put(2,number);
                       person.stamps-=25;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
               case 3:
                   if(person.stamps>=55){
                       int number=person.cards.get(3)+1;
                       person.cards.put(3,number);
                       person.stamps-=55;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
               case 4:
                   if(person.stamps>=80){
                       int number=person.cards.get(4)+1;
                       person.cards.put(4,number);
                       person.stamps-=80;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
               case 5:
                   if(person.stamps>=60){
                       int number=person.cards.get(5)+1;
                       person.cards.put(5,number);
                       person.stamps-=60;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
               case 6:
                   if(person.stamps>=60){
                       int number=person.cards.get(6)+1;
                       person.cards.put(6,number);
                       person.stamps-=60;
                       System.out.println("购买成功");

                   }else{
                       System.out.println("对不起，你所持有点券不足！");
                   }
                   break;
           }

        }else if(card==7) {
            break;
        }else{
            System.out.println("输入格式错误");
            continue;
        }

        }











    }
}
