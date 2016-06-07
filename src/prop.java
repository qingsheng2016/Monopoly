import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public class prop {
    //控制行走
    boolean on = true;
    int steps;
    //控制彩票
    boolean kai = true;
    int lottery;
    boolean gushi=true;

    public prop() {

    }

    public void prop(Person person, Map map, ArrayList<Person> personList,ArrayList<Stock> stockList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("您现在拥有的道具如下：");
        Hashtable<Integer, Integer> cards = person.cards;
        if (cards.get(0) > 0) {
            System.out.println("0、路障卡");
        }
        if (cards.get(1) > 0) {
            System.out.println("1、遥控骰子");
        }
        if (cards.get(2) > 0) {
            System.out.println("2、滞留卡");
        }
        if (cards.get(3) > 0) {
            System.out.println("3、彩票卡");
        }
        if (cards.get(4) > 0) {

            System.out.println("4、均富卡");
        }
        if (cards.get(5) > 0) {
            System.out.println("5、红卡");
        }
        if (cards.get(6) > 0) {
            System.out.println("6、黑卡");
        }
        System.out.println("请输入您想要的使用卡片的编号");
        int number = scanner.nextInt();
        switch (number) {
            case 0:
                if(cards.get(0)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                card0(person,map);
                break;
            case 1:
                if(cards.get(1)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                on = false;
                steps = card1(person, map);
                break;
            case 2:
                if(cards.get(2)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                on = false;
                steps = 0;
                int te = person.cards.get(2)-1;
                person.cards.put(2,te);
                break;
            case 3:
                if(cards.get(3)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                lottery = card3();
                int te3 = person.cards.get(3)-1;
                person.cards.put(3,te3);
                kai = false;
                break;
            case 4:
                if(cards.get(4)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                card4(personList);
                int te4 = person.cards.get(4)-1;
                person.cards.put(4,te4);
                break;
            case 5:
                if(cards.get(5)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                card5(stockList);
                int te5 = person.cards.get(5)-1;
                person.cards.put(5,te5);
                gushi=false;
                break;
            case 6:
                if(cards.get(6)==0){
                    System.out.println("你并没有该卡");
                    break;
                }
                card6(stockList);
                gushi=false;
                int te6 = person.cards.get(6)-1;
                person.cards.put(6,te6);
                break;
            default:
                System.out.println("输入错误");
                break;
        }


    }



    public void card0(Person person, Map map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请在您前后八步内设置路障 后方请用负数");
        int steps = scanner.nextInt();
        int result = steps + person.step;
        if (result < 0) {
            result += 52;
        } else {
            result = result % 52;
        }

        for (int i = 0; i < 160; i++) {
            if (map.cells.get(i).step == result) {
                map.cells.get(i).setBarrier(true);
            }
        }
        int te = person.cards.get(0)-1;
        person.cards.put(0,te);
        System.out.println("设置成功");

    }

    public int card1(Person person, Map map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您所想要的步数");
        int steps = scanner.nextInt();
        if (steps >= 1 && steps <= 6) {
            int te = person.cards.get(1)-1;
            person.cards.put(1,te);
            return steps;
        }else{
            System.out.println("输入错误");
            card1(person,map);
        }
        return 0;
    }

    public int card3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您所希望的彩票结果0~20");
        int re = scanner.nextInt();

        return re;
    }

    public void card4(ArrayList<Person> personList) {
        double all=0;
        int number = personList.size();
        for(int i=0;i<number;i++){
            all+=personList.get(i).cash;
        }
        for(int i=0;i<number;i++){
            personList.get(i).cash=all/number;
        }

    }
    public void card5(ArrayList<Stock>  stockList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您所想要使用红卡的股票序号0~9");
        int order = scanner.nextInt();
        int size= stockList.size();
        for (int i=0;i<size;i++){
            if(stockList.get(i).order==order){
                stockList.get(i).rise+=0.1;
                stockList.get(i).price*=(1+stockList.get(i).rise);
                System.out.println("修改成功");
                break;
            }
        }

    }
    public void card6(ArrayList<Stock>  stockList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您所想要使用黑卡的股票序号0~9");
        int order = scanner.nextInt();
        int size= stockList.size();
        for (int i=0;i<size;i++){
            if(stockList.get(i).order==order){
                stockList.get(i).rise-=0.1;
                stockList.get(i).price*=(1+stockList.get(i).rise);
                System.out.println("修改成功");
                break;
            }
        }
    }
}


