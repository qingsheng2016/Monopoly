import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by dell on 2016/4/27.
 */
public class getPerson {
    public ArrayList<Person> getPerson(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> personList = new ArrayList<>();
        System.out.println("请问参与人数有多少 请输入2~4");
        int number = scanner.nextInt();
        if(number>=2&&number<=4){
            for(int i=0;i<number;i++){
                Scanner sca = new Scanner(System.in);
            System.out.println("请输入玩家"+(i+1)+"的名字");
            String name=sca.nextLine();
                Hashtable<Integer,Integer> temp=new Hashtable<>();
                for(int j=0;j<7;j++){
                temp.put(j,1);
                }
                Hashtable<Integer,Integer> tem=new Hashtable<>();
                for(int j=0;j<10;j++){
                    tem.put(j,0);
                }
            Person person = new Person(i,20000,20000,temp,tem,new ArrayList<Land>(),80,0,name);
                personList.add(person);


        }
    }else{
            System.out.println("输入格式错误");
        }
        return personList;
    }
}
