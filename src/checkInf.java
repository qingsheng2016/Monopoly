import java.util.Scanner;

/**
 * Created by dell on 2016/4/26.
 */
public class checkInf {
    public void check(Person person,Map map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您想查询的点与您相差的步数（后方用负数）");
        int number = scanner.nextInt();
        int temp=number+person.step;
        int result;
        if(temp>=0){
         result=temp%51;}
        else{
            result=temp+51;
        }
        int size = map.cells.size();
        for(int i=0;i<size;i++){
            if(map.cells.get(i).step==result){
                if(map.cells.get(i).type.equals("房产")){
                    Land land= (Land) map.cells.get(i).events.get(0);
                    String inf="<可供出售状态>";
                    if(land.owner!=null){
                        inf=land.owner.information;
                    }
                    System.out.print("类型：房产\n"+"名称："+map.cells.get(i).events.get(0).information+"\n"+"初始价格：2000元\n"+"当前等级："+land.level+"\n"+"拥有者："+inf+"\n");
                }else if(map.cells.get(i).type.equals("银行")){
                    System.out.print("类型：银行\n");
                }else if(map.cells.get(i).type.equals("空地")){
                    System.out.print("类型：空地\n");
                }else if(map.cells.get(i).type.equals("道具店")){
                    System.out.print("类型：道具店\n");
                }else if(map.cells.get(i).type.equals("彩票站")){
                    System.out.print("类型：彩票站\n");
                }else if(map.cells.get(i).type.equals("新闻")){
                    System.out.print("类型：新闻\n");
                }else if(map.cells.get(i).type.equals("点券")){
                    System.out.print("类型：点券\n");
                }else if(map.cells.get(i).type.equals("卡片")){
                    System.out.print("类型：卡片\n");
                }
            }
        }
    }
}
