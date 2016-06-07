/**
 * Created by dell on 2016/4/24.
 */
public class CheckWarning {

    public void check(Person person,Map map){
            int step=person.step;
            boolean ishave = false;
            for(int i=1;i<=10;i++){
                int size=map.cells.size();
                for(int j=0;j<size;j++){
                    if(map.cells.get(j).step==step+i&&map.cells.get(j).barrier){
                        System.out.println("距离您"+j+"步有路障");
                        ishave=true;
                    }
                }
            }
        if(!ishave){
            System.out.println("前方无路障");
        }

    }
}
