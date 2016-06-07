/**
 * Created by dell on 2016/4/24.
 */
public class StampStation extends Event {
    @Override
    public String toTexture() {
        return "券";
    }
    public void stamp(Person person){
        int temp = (int) ( 50 * Math.random() + 10);
        person.stamps+=temp;
        System.out.println("获得点券"+temp+"点");
    }
}
