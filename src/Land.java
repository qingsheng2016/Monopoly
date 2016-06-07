import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public  class Land extends Event{
    int level;
    double price;
    Person owner;
    //final String type="房产";

    public Land(int level,Person owner,double price){

        this.level=level;
        this.owner=owner;
        this.price=price;

    }
    public int getStreet(){
        return street;
    }




    @Override
    public  String toTexture(){
        if(owner!=null){
            switch (owner.id){
                case 0 :
                    return "○";
                case 1:
                    return "●";
                case  2:
                    return "◇";
                case 3:
                    return "◆";
            }
        }else{
            return "◎";
        }

        return "";
    }
    public void landDeal(Person person){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请问你是否购买当前土地 购买0不卖1");
        int  answer = scanner.nextInt();
        if(answer==0){
            if(person.cash<price){
                System.out.println("你的现金不够");
            }else{
                person.cash -=  price;
                owner=person;
                person.getLands().add(this);
                System.out.println("购买成功");
            }

        }else if(answer==1){

        }else{
            System.out.println("输入错误");
        }

    }
    public void landUpdate(Person person){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请问你是否升级当前土地 是 0否1");
        int  answer = scanner.nextInt();
        if(answer==0){
            if(person.cash<price*0.5){
                System.out.println("你的现金不够");
            }else if(level==6) {
                System.out.println("已达到最高级数");
            }
                else{
                    person.cash -=  price*0.5;
                    level++;
                System.out.println("升级成功");


            }

        }else if(answer==1){

        }else{
            System.out.println("输入错误");
        }

    }
    public boolean passfee(Person person, ArrayList<Land> lands){
        int id=owner.id;
        double fee=0;
        int count = lands.size();
        for(int i=0;i<count;i++){
            if(lands.get(i).street==street&&(lands.get(i).owner!=null)&&(lands.get(i).owner.id==id)){
                fee+=((lands.get(i).level+1)*2000*0.2);
            }
        }
        System.out.println("交了过路费"+fee);
        if(person.cash>=fee){
            person.cash-=fee;
            owner.cash+=fee;
            return false;
        }else if(person.cash+person.deposit>=fee){
            person.cash=0;
            person.deposit-=(fee-person.cash);
            owner.cash+=fee;
            return false;

        }else  {
            double all=person.cash+person.deposit;
            fee-=all;
            person.deposit=0;
            person.cash=0;
            owner.cash+=all;
            while(person.lands.size()>0){
                if(person.lands.get(0).level*2000>=fee){
                    double rest=person.lands.get(0).level*2000-fee;
                    person.cash+=rest;
                    Land  temp=person.lands.get(0);
                    owner.lands.add(temp);
                    person.lands.remove(0);
                    System.out.println("您卖了一处土地");
                    owner.cash+=fee;
                    return false;

                }else{
                    fee-=person.lands.get(0).level*2000;
                    Land  temp=person.lands.get(0);
                    owner.lands.add(temp);
                    person.lands.remove(0);
                    System.out.println("您卖了一处土地");
                    owner.cash+=temp.level*2000;
                }

            }


        }
        return true;

    }
}
