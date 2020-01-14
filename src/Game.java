import java.io.IOException;
import java.util.Scanner;
public class Game{
	
	static boolean nextday=true; //是否有一天
	
	static int[] watermelon_decay_count=new int[999999];  //若那一天的array為1，代表濕度不合適，判斷是否造成衰敗
	static int[] mulberry_decay_count=new int[999999];    //若那一天的array為1，代表濕度不合適，判斷是否造成衰敗
	
	static boolean watermelon_decay;  //西瓜是否衰敗
	static boolean mulberry_decay;   //桑樹是衰敗
	
	static boolean watermelon_die;   //西瓜是否死亡
	static boolean mulberry_die;     //桑樹是死亡

	
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		player player1=new player();
		environment environment1=new environment();
		vegetable vegetable1=new vegetable();
		
		
		player1.setenergy();                   //初始化
		player1.setmoney();                    //初始化
		player1.setamount_watermelonseed();    //初始化
		player1.setamount_mulberryseed();      //初始化
		player1.setamount_sand();              //初始化
		player1.setamount_clay();              //初始化
		player1.setamount_loam();              //初始化
		player1.setamount_watermelonplanted(); //初始化
		player1.setamount_mulberryplanted();   //初始化
		player1.setamount_redbull();           //初始化
		
		environment1.setday();                 //初始化
		environment1.set_moisture();           //初始化
		environment1.setmoisture_endday();     //初始化
		
		
		System.out.println("歡迎來到農場物語");
		System.out.println("請輸入角色名稱：");
		player1.setname(scanner.nextLine());
		
		
		while(nextday==true) {
		
			
			System.out.println("第"+environment1.getday()+"天");
			System.out.println("天氣："+environment1.getweather()+" 濕度："+environment1.get_moisture());
			if(vegetable1.getwatermelon_day_planted()==vegetable1.getwatermelon_day()) {  //西瓜剛好成熟
				System.out.println("西瓜已成熟，可以收割嘍");
			}
			else if(watermelon_die==true) {    //西瓜已死亡 
				System.out.println("種植的西瓜已死亡");}
			else if(watermelon_decay==true) {  //西瓜開始衰敗
				System.out.println("種植的西瓜開始衰敗了，趕緊收割");}
			
			else if(vegetable1.getmulberry_day_planted()==vegetable1.getmulberry_day()) {  //剛好成熟
				System.out.println("桑樹已成熟，可以收割嘍");
			}
			else if(mulberry_die==true) {    //桑樹已死亡 
				System.out.println("種植的桑樹已死亡");
			}
			else if(mulberry_decay==true) {  //桑樹開始衰敗
				System.out.println("種植的桑數開始衰敗了，趕緊收割");}
			
			
			while(true) {  //重複執行直到玩家選擇睡眠
				
				if(player1.getenergy()==0) {player1.sleep();}  //體力=0，進行睡眠
				
				if(player1.getmoney()<=0&&player1.getwatermelonplanted()==false&&player1.getmulberryplanted()==false) {break;}  //若破產也無種植植物，則結束遊戲
				
				System.out.println("體力值："+player1.getenergy());
				System.out.println("金錢："+player1.getmoney());	
				System.out.println("請輸入指令");
				String[] action=scanner.nextLine().split(" ");
				if(action[0].equals("water")) {
					if(action[1].equals("watermelon")) {player1.water_watermelon();environment1.water();if(player1.getenergy()==0) {player1.sleep();}}
					else if(action[1].equals("mulberry")) {player1.water_mulberry();environment1.water();if(player1.getenergy()==0) {player1.sleep();}}
					else {System.out.println("植物名輸入錯誤，請重新輸入");}	
				}
				
				else if(action[0].equals("fill")&&action[1].equals("and")&&action[2].equals("loose")) {
					if(action[3].equals("sand")) {player1.fill_and_loose_sand();environment1.new_change_soil();environment1.setenvironment_moisture();if(player1.getenergy()==0) {player1.sleep();}}
					else if(action[3].equals("clay")) {player1.fill_and_loose_clay();environment1.new_change_soil();environment1.setenvironment_moisture();if(player1.getenergy()==0) {player1.sleep();}}
					else if(action[3].equals("loam")) {player1.fill_and_loose_loam();environment1.new_change_soil();environment1.setenvironment_moisture();if(player1.getenergy()==0) {player1.sleep();}}
					else {System.out.println("土壤名輸入錯誤，請重新輸入");}
				}
				
				else if(action[0].equals("plant")) {
					if(action[1].equals("watermelon")) {player1.plant_watermelonseed();if(player1.getenergy()==0) {player1.sleep();}}
					else if(action[1].equals("mulberry")) {player1.plant_mulberryseed();if(player1.getenergy()==0) {player1.sleep();}}
					else {System.out.println("植物名輸入錯誤，請重新輸入");}
				}
				
				else if(action[0].equals("reap")&&action[1].equals("and")&&action[2].equals("sell")) {
					if(action[3].equals("watermelon")) {player1.reap_and_sell_watermelon();if(player1.getenergy()==0) {player1.sleep();}}
					else if(action[3].equals("mulberry")) {player1.reap_and_sell_mulberry();if(player1.getenergy()==0) {player1.sleep();}}
					else {System.out.println("植物名輸入錯誤，請重新輸入");}
				}
				
				else if(action[0].equals("buy")) {
					if(action[1].equals("wateringcan")) {
						player1.buy_wateringcan();
						}
					
					else if(action[1].equals("hoe")) {
						player1.buy_hoe();
					    }
					
					else if(action[1].equals("sickle")) {
						player1.buy_sickle();
						}
					
					else if(action[1].equals("watermelon")) {
						player1.buy_watermelonseed();}
					
					else if(action[1].equals("mulberry")) {
						player1.buy_mulberryseed();}
					
					else if(action[1].equals("sand")) {
						player1.buy_sand();}
					
					else if(action[1].equals("clay")) {
						player1.buy_clay();}
					
					else if(action[1].equals("loam")) {
						player1.buy_loam();}
					
					else if(action[1].equals("redbull")) {
						player1.buy_redbull();}
					
					else {System.out.println("商品名輸入錯誤，請重新輸入");}
				}
				else if(action[0].equals("drink")) {
					if(action[1].equals("redbull")) {
						player1.drink_redbull();
					}
					else {System.out.println("輸入有誤，請重新輸入");}
				}
				
				else if(action[0].equals("check")) {player1.check();}
				
				else if(action[0].equals("backpack")) {player1.backpack();}
				
				else if(action[0].equals("sleep")) {
					
					environment1.setmoisture_sleep();
					player1.sleep();
					
					
					if(player1.getamount_watermelonplanted()==1) {  //有種植西瓜
						
						if(environment1.getmoisture_endday()>25||environment1.getmoisture_endday()<15) {  //若結算濕度不合適，則assign 1到watermelon_decay_count的array當天欄位
							watermelon_decay_count[environment1.getday()]=1;
							if(vegetable1.getwatermelon_day_planted()>=5) {   //如果種植天數達五天
								if(watermelon_decay_count[environment1.getday()-4]==1&&watermelon_decay_count[environment1.getday()-3]==1&&watermelon_decay_count[environment1.getday()-2]==1&&watermelon_decay_count[environment1.getday()-1]==1&&watermelon_decay_count[environment1.getday()]==1) {    //檢查是否連續五天濕度都不合適     
									watermelon_die=true;vegetable1.setwatermelon_day();vegetable1.setwatermelon_day_planted();vegetable1.setamount_watermelonfruit();player1.setwatermelonplanted();
								}
								else {watermelon_die=false;}
								
							}
							if(watermelon_die=false) {
							if(vegetable1.getwatermelon_day_planted()>=3) {   //如果種植天數達三天
								if(watermelon_decay_count[environment1.getday()-2]==1&&watermelon_decay_count[environment1.getday()-1]==1&&watermelon_decay_count[environment1.getday()]==1) {    //檢查是否連續三天濕度都不合適
									watermelon_decay=true;vegetable1.watermelon_decay();
								}
								
								else {watermelon_decay=false;}
						}
							}
						}
						else {watermelon_decay_count[environment1.getday()]=0;} //若結算濕度不合適，則assign 0到watermelon_decay_count的array當天欄位
					}
					
					else if(player1.getamount_mulberryplanted()==1) {  //有種植桑樹
						if(environment1.getmoisture_endday()>35||environment1.getmoisture_endday()<25) {  //若結算濕度不合適，則assign 1到mulberry_decay_count的array當天欄位
							mulberry_decay_count[environment1.getday()]=1;
						if(vegetable1.getmulberry_day_planted()>=5) {   //如果種植天數達五天
							if(mulberry_decay_count[environment1.getday()-5]==1&&mulberry_decay_count[environment1.getday()-4]==1&&mulberry_decay_count[environment1.getday()-3]==1&&mulberry_decay_count[environment1.getday()-2]==1&&mulberry_decay_count[environment1.getday()-1]==1&&mulberry_decay_count[environment1.getday()]==1) {    //檢查是否連續五天濕度都不合適
							mulberry_die=true;vegetable1.setmulberry_day();vegetable1.setmulberry_day_planted();vegetable1.setamount_mulberryfruit();player1.setmulberryplanted();
						}
						else {mulberry_die=false;}
							
						}
						if(mulberry_die=false) {
						if(vegetable1.getmulberry_day_planted()>=3) {   //如果種植天數達三天
								if(mulberry_decay_count[environment1.getday()-2]==1&&mulberry_decay_count[environment1.getday()-1]==1&&mulberry_decay_count[environment1.getday()]==1) {    //檢查是否連續三天濕度都不合適
									mulberry_decay=true;vegetable1.mulberry_decay();
								}
								else {mulberry_decay=false;}
								
								
							}
						}
					}
						else {mulberry_decay_count[environment1.getday()]=0;} //若結算濕度不合適，則assign 0到mulberry_decay_count的array當天欄位
							}
					
					
					environment1.nextday();   //下一天日期
					environment1.nextday_moisture();   //設定下一天濕度
					if(environment1.getday()==101) {nextday=false;}   //天數超過環境的天數，結束遊戲
					break;
					}
				else {System.out.println("指令輸入有誤，請重新輸入");}
				
			}
		
			
		}
		
		System.out.println("遊戲結束，您共獲得："+player1.getmoney()+"元");
		
	}
	
	
	
	
	
	
}
