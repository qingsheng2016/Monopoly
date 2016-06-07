/**
 * Created by dell on 2016/4/24.
 */
public class Card extends Event{
   final String type="送卡片处";
    @Override
    public String toTexture() {
        return "卡";
    }
    public void card(Person person){
        int count=(int)(Math.random()*7);
        int temp;
        switch(count){
            case 0:
                temp=person.cards.get(0)+1;
                person.cards.put(0,temp);
                System.out.println("送您一张路障卡");
                break;
            case 1:
                temp=person.cards.get(1)+1;
                person.cards.put(1,temp);
                System.out.println("送您一张遥控骰子");
                break;
            case 2:
                 temp=person.cards.get(2)+1;
                person.cards.put(2,temp);
                System.out.println("送您一张滞留卡");
                break;
            case 3:
                temp=person.cards.get(3)+1;
                person.cards.put(3,temp);
                System.out.println("送您一张彩票卡");
                break;
            case 4:
                 temp=person.cards.get(4)+1;
                person.cards.put(4,temp);
                System.out.println("送您一张均富卡");
                break;
            case 5:
                 temp=person.cards.get(5)+1;
                person.cards.put(5,temp);
                System.out.println("送您一张红卡");
                break;
            case 6:
                temp=person.cards.get(6)+1;
                person.cards.put(6,temp);
                System.out.println("送您一张黑卡");
                break;

        }
    }
}
