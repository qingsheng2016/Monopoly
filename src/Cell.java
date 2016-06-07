import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 2016/4/24.
 */
public class Cell {

    int x;
    int y;
     ArrayList<Event> events = new ArrayList<Event>();
    boolean barrier;
    int step;
    String type;
    ArrayList<Person> location=new ArrayList<>();
    public Cell(int x,int y){
        //this.step=step;
        this.x=x;
        this.y=y;


    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setStep(int step){
        this.step=step;
    }
    public int getStep(){
        return step;
    }
    public void addEvent(Event event,String type){
        events.add(event);
        this.type=type;
    }
    public void setBarrier(boolean barrier){
        this.barrier=barrier;
    }
    public boolean  getBarrier(){
        return barrier;
    }
    public String toTextual() {
        if(location.size()>0){
            return location.get(0).toTexture();
        }
        if(events.size()==0){
            return  "　";
        }else if(events.size()==1){
            return events.get(0).toTexture();
        }else{
            return events.get(1).toTexture();
        }

    }


}
