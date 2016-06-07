/**
 * Created by dell on 2016/4/27.
 */
public class Giveup {
    public void giveup(Person person){
        int number = person.lands.size();
        for(int i =0;i<number;i++){
            person.lands.get(i).owner=null;
        }
        System.out.println("你认输了");
    }
}
