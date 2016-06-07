import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dell on 2016/4/24.
 */
public class Game {
  public static void main(String[] args) throws IOException {
      //行走步数
      int step = 0;
      //人物列表
            getPerson  getperson = new getPerson();
      ArrayList<Person> personList = getperson.getPerson();
      //时间
      Date date = new Date(2016,5,1,"星期一");
      //指令
      Instruction instruc=new Instruction();
      //当前玩家
      PersonActive personActive = new PersonActive();

      //实时地图
      CreateMap createmap=new CreateMap();
      Map map=createmap.buildMap();
      //使用道具实例
      prop pro = new prop();
      //十步预警实例
      CheckWarning warning = new CheckWarning();
      //前后指定步数信息实例
      checkInf inf= new checkInf();
      //玩家资产信息实例
      CheckAssert asset = new CheckAssert();
      //骰子实例
      Dice dice=new Dice();
      //股市实例
      StockMarket market = new StockMarket();
      ArrayList<Stock> stocks = market.list();
      //股市交易
      Share share = new Share();
      //行走list
      ArrayList<Cell> walk = new ArrayList<>();
      for(int i=0;i<52;i++) {
          for(int j=0;j<160;j++) {
              if (map.cells.get(j).step == i) {
                  walk.add(map.cells.get(j));
                  break;
              }
          }
      }
      //银行实例
      Bank bank = new Bank();
      //彩票实例
      Lottery lottery = new Lottery();
      //新闻实例
      News news= new News();
      //送卡片实例
      Card card= new Card();
      //送点券实例
      StampStation stamp = new StampStation();
      //道具店实例
      PropShop  shop=new PropShop();
      //土地集合
      ArrayList<Land> lands =new ArrayList<>();
      for(int i=0;i<52;i++){
          if(walk.get(i).type.equals("房产")){
              lands.add((Land) walk.get(i).events.get(0));
          }
      }
      //System.out.println(lands.size());
      //System.out.println(lands.get(15).street);
      //初始化位置
      for(int i=0;i<personList.size();i++) {
          map.cells.get(0).location.add(personList.get(i));
      }
  //认输实例
      Giveup give=new Giveup();
      while(true){
          //游戏资格
          boolean giveup=true;

          //彩票奖项
          boolean lot=false;
          //回复涨幅
          pro.gushi=true;


          int amount = personList.size();
          if(amount==1){
              System.out.println("你赢了");
              break;
          }
          //银行利息
          if(date.day==1){
              for(int i =0;i<personList.size();i++){
                  personList.get(i).deposit*=1.1;
                  System.out.println("银行利息发放了");
              }

          }
          //是否开放股市
          boolean gushi;
          if(date.date.equals("星期六")||date.date.equals("星期日")){
              gushi=false;
          }else{
              gushi=true;
          }
          for(int i=0;i<personList.size();i++) {
              //指令开关
              boolean on = true;
              //游戏权限
              boolean conti = false;
              //打印时间
              System.out.println("今天是" + date.year + "年" + date.month + "月" + date.day + "日" + "  " + date.date);
              //获取当前玩家
              personActive.setPerson(personList.get(i));
              //玩家信息
              System.out.println("现在是玩家“" + personActive.getPerson().information + "”的操作时间，您的前进方向是顺时针");

              // System .out.println(personActive.getPerson().information);
              //操作信息
              while (on) {
                  instruc.instruction();
                  Scanner scanner = new Scanner(System.in);
                  int ins = scanner.nextInt();
                  if (ins >= 0 && ins <= 8) {
                      switch (ins) {
                          case 0:
                              System.out.println(map.toTexture());
                              break;
                          case 1:
                              CreateMap cm = new CreateMap();
                              System.out.println(cm.buildMap().toTexture());
                              break;
                          case 2:
                              pro.prop(personActive.getPerson(), map, personList, stocks);
                              break;
                          case 3:
                              warning.check(personActive.getPerson(), map);
                              break;
                          case 4:
                              inf.check(personActive.getPerson(), map);
                              break;
                          case 5:
                              asset.showAssert(personList);
                              break;
                          case 6:
                              if (pro.on) {
                                  step = dice.getCount();
                              } else {
                                  step = pro.steps;
                              }
                              on = false;
                              pro.on = true;
                              break;
                          case 7:
                              give.giveup(personActive.getPerson());
                              walk.get(personActive.getPerson().step).location.remove(personActive.getPerson());
                              personList.remove(i);
                              i--;
                              on = false;
                              giveup = false;
                              break;
                          case 8:
                              if (gushi) {
                                  share.share(personActive.getPerson(), stocks);
                              } else {
                                  System.out.println("今日股市不开放");
                              }
                              break;


                      }
                  }
              }//指令循环结束，正常功能界面
              if (giveup) {
                  int now = personActive.getPerson().step;
                  walk.get(now).location.remove(personActive.getPerson());
                  int result = now;

                  for (int j = 0; j < step; j++) {
                      result = (result + 1) % 52;
                      if (walk.get(result).barrier) {
                          System.out.println("您遇到了路障");
                          walk.get(result).barrier = false;
                          break;
                      } else if (walk.get(result).type.equals("银行") && j < step - 1) {
                          bank.bank(personActive.getPerson());
                      }
                  }

                  String type = walk.get(result).type;
                  switch (type) {
                      case "空地":
                          break;
                      case "房产":
                          Land temp = (Land) walk.get(result).events.get(0);
                          if (temp.owner == null) {
                              temp.landDeal(personActive.getPerson());
                          } else if (temp.owner.id == personActive.getPerson().id) {
                              temp.landUpdate(personActive.person);
                          } else {
                              conti = temp.passfee(personActive.getPerson(), lands);

                          }
                          break;
                      case "道具店":
                          shop.store(personActive.getPerson());
                          break;
                      case "彩票站":
                          lottery.lottery(personActive.getPerson(), pro.kai);
                          if ((!pro.kai) && pro.lottery == personActive.getPerson().lottery) {
                              System.out.println("恭喜你中奖");
                              personActive.getPerson().cash += 2000;
                          }
                          break;
                      case "送点券":
                          stamp.stamp(personActive.getPerson());
                          break;
                      case "送卡片":
                          card.card(personActive.getPerson());
                          break;
                      case "新闻":
                          news.showNews(personList);
                          break;
                      case "银行":
                          bank.bank(personActive.getPerson());
                          break;
                  }
                  personActive.getPerson().step = result;
                  walk.get(result).location.add(personActive.getPerson());

                  if (conti) {
                      System.out.println("你已经破产了");
                      walk.get(result).location.remove(personActive.getPerson());

                      personList.remove(i);
                      i--;
                  }


              }
              giveup=true;
          }
          if(gushi&&pro.gushi) {
              for (int i = 0; i < 10; i++) {
                  int rise0 = (int) (Math.random() * 20-10);
                  double rise=rise0*0.001;
                  stocks.get(i).rise=rise;
                  stocks.get(i).price*=(1+rise);


              }
          }
          date.day++;
          date.dealTime();





          }


      }



  }

