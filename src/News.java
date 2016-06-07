import java.util.ArrayList;

/**
 * Created by dell on 2016/4/24.
 */
public class News extends Event {
    final String type="新闻";

    public News(){

    }

    @Override
    public String toTexture() {
        return"新";
    }

    public void showNews(ArrayList<Person> personList){
        int temp = (int) ( 5 * Math.random() );
        int number=personList.size();
        int most=personList.get(0).lands.size();
        String winner=personList.get(0).information;
        String loser=personList.get(0).information;
        int least = personList.get(0).lands.size();
        int w=0;
        int l=0;
        for(int i=1;i<number;i++){
            if(personList.get(i).lands.size()>most){
                most=personList.get(i).lands.size();
                winner = personList.get(i).information;
                w=i;
            }
            if(personList.get(i).lands.size()<least){
                least=personList.get(i).lands.size();
                loser=personList.get(i).information;
                l=0;
            }
        }
        switch(temp){
            case 0:
                personList.get(w).cash+=2000;

                System.out.println("公开表扬第一地主"+winner+"奖励2000元");
                break;
            case 1:
                personList.get(l).cash+=2000;
                System.out.println("公开补助土地最少者"+loser+"奖励2000元");
                break;
            case 2:
                for(int i=0;i<number;i++){
                    personList.get(i).deposit*=0.9;
                }
                System.out.println("所有人缴纳财产税10%");
                break;
            case 3:
                for(int i=0;i<number;i++){
                    personList.get(i).deposit*=1.1;
                }
                System.out.println("每人得到存款10%");
                break;
        }
    }
}
