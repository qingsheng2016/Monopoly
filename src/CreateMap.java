import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by dell on 2016/4/26.
 */
public class CreateMap {
    public String maps="16 10\n"+
            "◎◎◎◎◎   空◎◎◎券券券空\n"+
                       "券   空   道      卡\n"+
                       "◎   彩券◎◎◎      道\n"+
                      "卡              道\n"+
                      "道              券\n"+
                     "◎       道◎◎空◎◎◎◎\n"+
                    "◎空◎券银   卡       \n"+
            "    彩   新       \n"+
            "    新   彩       \n"+
            "    券◎◎◎◎       \n";
    public Map buildMap() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(maps));
        String[] dimension = reader.readLine().split(" ");
        Map map = new Map(Integer.parseInt(dimension[0]),Integer.parseInt(dimension[1]));
        for(int y = 0;y <map.getHeight();y++){
            char[] chars = reader.readLine().toCharArray();
            for(int x = 0;x <map.getWidth();x++){

                Cell curCell = map.getCell(x, y);
                switch(chars[x]){
                    case '◎':curCell.addEvent(new Land(0,null,2000.0),"房产"); break;
                    case '新':curCell.addEvent(new News(),"新闻"); break;
                    case '银':curCell.addEvent(new Bank(),"银行"); break;
                    case '道':curCell.addEvent(new PropShop(),"道具店"); break;
                    case '券':curCell.addEvent(new StampStation(),"送点券"); break;
                    case '空':curCell.addEvent(new Empty(),"空地"); break;
                    case '卡':curCell.addEvent(new Card(),"送卡片"); break;
                    case '彩':curCell.addEvent(new Lottery(),"彩票站");break;



                }
            }
        }

        for(int i=0;i<160;i++){
            map.cells.get(i).setBarrier(false);
        }
        map.cells.get(0).setStep(0);
        map.cells.get(0).events.get(0).information="金星1号";
        map.cells.get(0).events.get(0).street=0;

        map.cells.get(1).setStep(1);
        map.cells.get(1).events.get(0).information="金星2号";
        map.cells.get(1).events.get(0).street=0;

        map.cells.get(2).setStep(2);
        map.cells.get(2).events.get(0).information="金星3号";
        map.cells.get(2).events.get(0).street=0;

        map.cells.get(3).setStep(3);
        map.cells.get(3).events.get(0).information="金星4号";
        map.cells.get(3).events.get(0).street=0;

        map.cells.get(4).setStep(4);
        map.cells.get(4).events.get(0).information="金星5号";
        map.cells.get(4).events.get(0).street=0;
    for(int i=8;i<16;i++) {
        map.cells.get(i).setStep(i + 4);
        map.cells.get(i).events.get(0).street = 2;

    }

        map.cells.get(9).events.get(0).information="木星1号";
        map.cells.get(10).events.get(0).information="木星2号";
        map.cells.get(11).events.get(0).information="木星3号";

        map.cells.get(16).setStep(51);
        map.cells.get(20).setStep(5);
        map.cells.get(24).setStep(11);
        map.cells.get(31).setStep(20);

        map.cells.get(32).setStep(50);
        map.cells.get(32).events.get(0).information="月球1号";
        map.cells.get(32).events.get(0).street=7;

        for(int i=36;i<41;i++) {
            map.cells.get(i).setStep(i -30);
            map.cells.get(i).events.get(0).street = 1;

        }
        map.cells.get(38).events.get(0).information="水星1号";
        map.cells.get(39).events.get(0).information="水星2号";
        map.cells.get(40).events.get(0).information="水星3号";
        map.cells.get(47).setStep(21);
        map.cells.get(48).setStep(49);
        map.cells.get(63).setStep(22);
        map.cells.get(64).setStep(48);
        map.cells.get(79).setStep(23);
        map.cells.get(80).setStep(47);
        map.cells.get(80).events.get(0).information="月球2号";
        map.cells.get(32).events.get(0).street=7;
        int number=24;
        for(int i=95;i>87;i--){
            map.cells.get(i).setStep(number);
            number++;
            map.cells.get(i).events.get(0).street = 4;
        }
        map.cells.get(95).events.get(0).information="火星1号";
        map.cells.get(94).events.get(0).information="火星2号";
        map.cells.get(93).events.get(0).information="火星3号";
        map.cells.get(92).events.get(0).information="火星4号";
        map.cells.get(90).events.get(0).information="火星5号";
        map.cells.get(89).events.get(0).information="火星6号";
        int n=46;
        for(int i=96;i<101;i++){
            map.cells.get(i).setStep(n);
            n--;
            map.cells.get(i).events.get(0).street = 6;
        }
        map.cells.get(96).events.get(0).information="地球1号";
        map.cells.get(98).events.get(0).information="地球2号";
        map.cells.get(104).setStep(32);
        map.cells.get(116).setStep(41);
        map.cells.get(120).setStep(33);
        map.cells.get(132).setStep(40);
        map.cells.get(136).setStep(34);
        map.cells.get(148).setStep(39);

        map.cells.get(149).setStep(38);
        map.cells.get(150).setStep(37);
        map.cells.get(151).setStep(36);
        map.cells.get(152).setStep(35);
        map.cells.get(149).events.get(0).street = 5;
        map.cells.get(150).events.get(0).street = 5;
        map.cells.get(151).events.get(0).street = 5;
        map.cells.get(152).events.get(0).street = 5;

        map.cells.get(149).events.get(0).information="土星1号";
        map.cells.get(150).events.get(0).information="土星2号";
        map.cells.get(151).events.get(0).information="土星3号";
        map.cells.get(152).events.get(0).information="土星4号";









        return map;
    }

}












