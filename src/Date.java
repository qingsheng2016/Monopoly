/**
 * Created by dell on 2016/4/26.
 */
public class Date {
    int year;
    int month;
    int day;
    String date;
    public Date(int year,int month,int day,String date){
        this.year=year;
        this.month=month;
        this.day=day;
        this.date=date;
    }
    public void dealTime(){
        int days=0;
        if(month==4&&day>30){
           day=1;
            month++;}else
        if(month==5&&day>31){
            day=1;
            month++;}
           if(month==4) {
               days=(day-4)%7;
           }else if(month==5){
               days=(day+30-4)%7;}
            switch(days){
                case 0:
                    date="星期一";
                    break;
                case 1:
                    date="星期二";
                    break;
                case 2:
                    date= "星期三";
                    break;
                case 3:
                    date = "星期四";
                    break;
                case 4:
                    date = "星期五";
                    break;
                case 5:
                    date = "星期六";
                    break;
                case 6:
                    date = "星期日";
                    break;
                default:
                    break;
            }

    }
}
