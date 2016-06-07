import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public class Bank extends Event {
    public  Bank(){

    }

    @Override
    public String toTexture() {
        return "银";
    }
    public void bank(Person person){
        System.out.print("您的现金   "+person.cash+"\n"
        +"您的存款   "+person.deposit+"\n");
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("若需要存款请扣0//取款请扣1//没有需求请扣2");
        int number = sc.nextInt();
        if(number==0){
            save(person);
            break;
        }else if(number==1){
            get(person);
            break;
        }else if(number==2){


        }else{
            System.out.println("输入错误！！！");
        }
    }
    }
    public void save(Person person){
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("请输入您要存入金额");
        double price = sc.nextDouble();
        if(price>=0){
            if(price>person.cash){
                System.out.println("您没有那么多现金！");

            }else{
                person.cash-=price;
                person.deposit+=price;
                System.out.println("您的现金   "+person.cash);
                System.out.println("您的存款   "+person.deposit);
                break;
            }
        }else{
            System.out.println("输入格式错误");


        }
    }
    }
    public void get(Person person){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入您要取出金额");
            double price = sc.nextDouble();
            if(price>=0){
                if(price>person.deposit){
                    System.out.println("您没有那么多存款！");

                }else{
                    person.cash+=price;
                    person.deposit-=price;
                    System.out.println("您的现金   "+person.cash);
                    System.out.println("您的存款   "+person.deposit);
                    break;
                }
            }else{
                System.out.println("输入格式错误");


            }
        }
    }
}
