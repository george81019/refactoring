public class player {
	
	environment environment1=new environment();
	vegetable vegetable1=new vegetable();
	
	private String name;
	private int energy;  
	private int money;
    private int amount_watermelonseed=0;   //擁有的西瓜種子數量
	private int amount_mulberryseed=0;     //擁有的桑樹種子數量
	private int amount_sand;               //擁有的沙土數量
	private int amount_clay;               //擁有的黏土數量
	private int amount_loam;               //擁有的壤土數量
	private int amount_magicdust;
	private int amount_watermelonplanted;  //被種植的西瓜數量
	private int amount_mulberryplanted;    //被種植的桑樹數量
	private int wateringcan_durability;    //澆水器耐久度
	private int hoe_durability;            //鋤頭耐久度 
	private int sickle_durability;         //鐮刀耐久度
	private int amount_redbull;
	
	
	private boolean watermelonplanted=false;      //有西瓜被種植
	private boolean mulberryplanted=false;        //有桑樹被種植
	static boolean thereisunusedsand=false;       //擁有尚未使用的沙土
	static boolean thereisunusedclay=false;       //擁有尚未使用的黏土
	static boolean thereisunusedloam=false;       //擁有尚未使用的壤土
	static boolean thereiswatermelonseed=false;   //擁有尚未使用的西瓜種子
	static boolean thereismulberryseed=false;     //擁有尚未使用的桑樹種子
	static boolean wateringcan_exist=false;       //擁有澆水器
	static boolean hoe_exist=false;               //擁有鋤頭   
	static boolean sickle_exist=false;            //擁有鐮刀 
	static boolean sand_loosen=false;             //被換上沙土 
	static boolean clay_loosen=false;             //被換上黏土 
	static boolean loam_loosen=false;             //被換上壤土 
	static boolean magicdust_loosen=false;
	
	public String[] action=new String[9999];
	
	
	
	
	
	public void setname(String name) {this.name=name;}
	public String getname() {return name;}
	
	public void setenergy() {this.energy=100;}  //初始化體力為100
	public int getenergy() {return energy;}
	
	public void setmoney() {this.money=900;}  //初始化金錢為900
	public int getmoney() {return money;}
	
	

	
	public void setamount_watermelonseed() {amount_watermelonseed=0;}     //初始化擁有的西瓜種子為0 
	public int getamount_watermelonseed() {return amount_watermelonseed;}
	
	public void setamount_mulberryseed() {amount_mulberryseed=0;}        //初始化擁有的桑樹種子為0
	public int getamount_mulberryseed() {return amount_mulberryseed;}
	
	public void setamount_sand() {amount_sand=0;}        //初始化擁有的沙土數量為0
	public int getamount_sand() {return amount_sand;}
	
	public void setamount_clay() {amount_clay=0;}        //初始化擁有的黏土數量為0
	public int getamount_clay() {return amount_clay;}
	
	public void setamount_loam() {amount_loam=0;}        //初始化擁有的壤土數量為0
	public int getamount_loam() {return amount_loam;}
	
	public void setamount_watermelonplanted() {amount_watermelonplanted=0;}      //初始化種植的西瓜數量為0
	public int getamount_watermelonplanted() {return amount_watermelonplanted;}
	
	public void setamount_mulberryplanted() {amount_mulberryplanted=0;}          //初始化種植的桑樹數量為0
	public int getamount_mulberryplanted() {return amount_mulberryplanted;}
	
	public void setamount_redbull() {amount_redbull=0;}
	public int getamount_redbull() {return amount_redbull;}
	
	public boolean wateringcan_exist() {return wateringcan_exist;}
	public boolean hoe_exist() {return hoe_exist;}
	public boolean sickle_exist() {return sickle_exist;}
	
	
	public void setwateringcan_durability() {this.wateringcan_durability=100;}     //初始化澆水器耐久度為100
	public int getwateringcan_durability() {return wateringcan_durability;}
	
	public void sethoe_durability() {this.hoe_durability=100;}     //初始化鋤頭耐久度為100
	public int gethoe_durability() {return hoe_durability;}
	
	public void setsickle_durability() {this.sickle_durability=100;}     //初始化鐮刀耐久度為100
	public int getsickle_durability() {return sickle_durability;}
	
	public void setwatermelonplanted() {this.watermelonplanted=false;}     //初始化沒有西瓜被種植
	public boolean getwatermelonplanted() {return watermelonplanted;}
	
	public void setmulberryplanted() {this.mulberryplanted=false;}     //初始化沒有桑樹被種植
	public boolean getmulberryplanted() {return mulberryplanted;}
	
	
	public void water_watermelon() {
		if(energy>=10) {                                //體力足夠
			if(amount_watermelonplanted>=1) {           //有種植的西瓜
				if(wateringcan_exist) {                 //有澆水器
					wateringcan_durability-=5;          //使用澆水器，澆水器耐久度-5
					energy-=10;                         //使用澆水器，體力-10
					System.out.println("您成功替西瓜澆了水");
			    }
			    else {
				   System.out.println("沒有澆水器，請前去購買");
			    }
			}
			else {
				System.out.println("沒有西瓜被種植，請前去購買");
			}
		}
		else {System.out.println("體力不足");}
	}
	
	public void water_mulberry() {
		if(energy>=10) {                                //體力足夠
			if(amount_mulberryplanted>=1) {             //有種植的桑樹
				if(wateringcan_exist) {                 //有澆水器
					if(wateringcan_durability>=5) {     //澆水器耐久度足夠
					wateringcan_durability-=5;          //使用澆水器，澆水器耐久度-5
					energy-=10;                         //使用澆水器，體力-10
					System.out.println("您成功替桑樹澆了水");
					}
			    }
			    else {
				   System.out.println("沒有澆水器，請前去購買");
			    }
			}
			else {
				System.out.println("沒有桑樹被種植，請前去購買");
			}
		}
		else {System.out.println("體力不足");}
	}
	
	public void fill_and_loose_sand() {
		if(energy>=5) {                       //體力足夠
	    	 if(amount_sand>=1) {             //擁有沙土
		    	 if(hoe_exist) {              //擁有鋤頭
		    		 if(hoe_durability>=10) { //鋤頭耐久度足夠
		    			 hoe_durability-=10;  //鋤頭耐久度-10
			    		 energy-=5;           //體力-5
			    		 amount_sand-=1;      //沙土數量-1
			    		 sand_loosen=true;    //沙土被填過
			    		 System.out.println("您成功填土並鬆土");
		    		 }
		    		 else {System.out.println("鋤頭已無法使用，請前去購買");}
		    	 }
		    	 else {
		    		 System.out.println("沒有鋤頭，請前去購買");
		    	 }
		     }
		     else {
		    	 System.out.println("沒有未使用的沙土，請前去購買");
		     }
	     }
	     else {System.out.println("體力不足");}
	}
	
	
	public void fill_and_loose_clay() {
		if(energy>=5) {                       //體力足夠
	    	 if(amount_clay>=1) {             //擁有黏土
		    	 if(hoe_exist) {              //擁有鋤頭
		    		 if(hoe_durability>=10) { //鋤頭耐久度足夠
		    			 hoe_durability-=10;  //鋤頭耐久度-10
			    		 energy-=5;           //體力-5
			    		 amount_clay-=1;      //黏土數量-1
			    		 clay_loosen=true;    //黏土被填過
			    		 System.out.println("您成功填土並鬆土");
		    		 }
		    		 else {System.out.println("鋤頭已無法使用，請前去購買");}
		    	 }
		    	 else {
		    		 System.out.println("沒有鋤頭，請前去購買");
		    	 }
		     }
		     else {
		    	 System.out.println("沒有未使用的黏土，請前去購買");
		     }
	     }
	     else {System.out.println("體力不足");}
	     
	}
	
	
	public void fill_and_loose_loam() {
	     if(energy>=5) {                       //體力足夠
	    	 if(amount_loam>=1) {              //擁有壤土
		    	 if(hoe_exist) {               //擁有鋤頭
		    		 if(hoe_durability>=10) {  //鋤頭耐久度足夠
		    			 hoe_durability-=10;   //鋤頭耐久度-10
			    		 energy-=5;            //體力-5
			    		 amount_loam-=1;       //壤土數量-1
			    		 loam_loosen=true;     //壤土被填過
			    		 System.out.println("您成功填土並鬆土");
		    		 }
		    		 else {System.out.println("鋤頭已無法使用，請前去購買");}
		    	 }
		    	 else {
		    		 System.out.println("沒有鋤頭，請前去購買");
		    	 }
		     }
		     else {
		    	 System.out.println("沒有未使用的壤土，請前去購買");
		     }
	     }
	     else {System.out.println("體力不足");}
	     
	}
	
	
	
	public void plant_watermelonseed() {
		if(watermelonplanted==true||mulberryplanted==true) {System.out.println("田地已種植植物");}  //判斷田地有種植物
		else if(sand_loosen==true||clay_loosen==true||loam_loosen==true){    //判斷有填過土壤
		 if(energy>=15) {                                                    //判斷體力足夠
			if(thereiswatermelonseed) {                                      //判斷擁有西瓜種子
				energy-=15;                                                  //體力-15
				amount_watermelonplanted=1;                                  //一個西瓜被種植
				watermelonplanted=true;                                      //西瓜被種植
				vegetable1.setwatermelon_day();
				vegetable1.setwatermelon_day_planted();                      //設定已種植天數
				vegetable1.setwatermelon_planteddate(environment1.getday()); //設定開始種植的日期
				if(clay_loosen) {vegetable1.watermelon_clay();}              //判斷使用的土壤為何，改變成熟需要的天數、果實數量
				else if(loam_loosen) {vegetable1.watermelon_loam();}         //判斷使用的土壤為何，改變成熟需要的天數、果實數量
				System.out.println("您成功種植了西瓜");
			}
			else {System.out.println("沒有西瓜種子，請前去購買");}
		
		}
		else {System.out.println("體力不足");}
	    }
		else {System.out.println("尚未翻土");}
	}
	
	
	public void plant_mulberryseed() {
		if(watermelonplanted==true||mulberryplanted==true) {System.out.println("田地已種植植物");}  //判斷田地有種植物
		else if(sand_loosen==true||clay_loosen==true||loam_loosen==true){     //判斷有填過土壤
		    if(energy>=15) {                                                  //判斷體力足夠
			if(thereismulberryseed) {                                         //判斷擁有西瓜種子
				energy-=15;                                                   //體力-15
				amount_mulberryplanted=1;                                     //一個西瓜被種植
				mulberryplanted=true;                                         //西瓜被種植
				vegetable1.setmulberry_day();
				vegetable1.setmulberry_day_planted();                         //設定已種植天數
				vegetable1.setwatermelon_planteddate(environment1.getday());  //設定開始種植的日期
				if(clay_loosen) {vegetable1.mulberry_clay();}                 //判斷使用的土壤為何，改變成熟需要的天數、果實數量
				else if(loam_loosen) {vegetable1.mulberry_loam();}            //判斷使用的土壤為何，改變成熟需要的天數、果實數量
				System.out.println("您成功種植了桑樹");
			}
			else {System.out.println("沒有桑樹種子，請前去購買");}
		}
		
		else {System.out.println("體力不足");}
	    } 
		else {System.out.println("尚未翻土");}
	}
	
	
	public void reap_and_sell_watermelon() {
		if(watermelonplanted==true) {  //判斷田地有種植植物
			if(energy>=5) {   //判斷體力足夠
				if(vegetable1.getwatermelon_day_planted()>=vegetable1.getwatermelon_day()) {  //判斷西瓜是否成熟
					if(sickle_exist) {   //判斷是否有鐮刀
						if(sickle_durability>=20) { //判斷鐮刀耐久度是否足夠
						sickle_durability-=20;       //鐮刀耐久度-20
						money+=vegetable1.getamount_watermelonfruit()*35;  //錢=果實數量*西瓜價錢
						vegetable1.setwatermelon_day();                    //初始化西瓜成熟所需的天數
						vegetable1.setwatermelon_day_planted();            //初始化西瓜被種植的天數
						vegetable1.setamount_watermelonfruit();            //初始化西瓜成熟時結的果實數
						sand_loosen=false; clay_loosen=false; loam_loosen=false;  //初始化土壤，變成都沒填過土
						System.out.println("您成功收割並販賣了西瓜果實");
					}
						
	             }
					else {System.out.println("鐮刀已無法使用，請前去購買");}
			
			}
				else {System.out.println("西瓜未成熟");}
			}
			else {System.out.println("體力不足");}
		
	}
		else if(watermelonplanted==false) {
			System.out.println("尚未種植西瓜，請前去購買");
		}
	}
	
	public void reap_and_sell_mulberry() {
		if(mulberryplanted==true) {  //判斷田地有種植桑樹
			if(energy>=5) {   //判斷體力足夠
				if(vegetable1.getmulberry_day()==vegetable1.getmulberry_day_planted()) {  //判斷桑樹是否成熟
					if(sickle_exist) {   //判斷是否有鐮刀
						if(sickle_durability>=20) {   //判斷是否有鐮刀
						sickle_durability-=20;	      //鐮刀耐久度-20
						money+=vegetable1.getamount_mulberryfruit()*10;  //錢=果實數量*桑樹價錢
						vegetable1.setmulberry_day();                    //初始化桑樹成熟所需的天數
						vegetable1.setmulberry_day_planted();            //初始化桑樹被種植的天數
						vegetable1.setamount_mulberryfruit();            //初始化桑樹成熟時結的果實數
						sand_loosen=false; clay_loosen=false; loam_loosen=false;  //初始化土壤，變成都沒填過土
						System.out.println("您成功收割並販賣了桑樹果實");
					   }
					    
	             }
					else {System.out.println("鐮刀已無法使用，請前去購買");}
			}
				else {System.out.println("桑樹未成熟");}
		}
			else {System.out.println("體力不足");}
		
		}
		else if(mulberryplanted==false) {
			System.out.println("尚未種植桑樹，請前去購買");
		}
	}
	
	public void buy_wateringcan() {
		if(wateringcan_exist==true) {  //判斷是否擁有澆水器
			System.out.println("已擁有澆水器，一次只能擁有一個哦");}
		else {
			if(money>=50) {                   //判斷錢足夠
				money-=50;                    //錢-50
				wateringcan_exist=true;       //擁有澆水器
				setwateringcan_durability();  //初始化澆水器耐久度
				System.out.println("您成功購買了澆水器");
				}
			else{System.out.println("金額不足，無法購買");}
		}
	}
	
	public void buy_hoe() {
		if(hoe_exist==true) {  //判斷是否擁有鋤頭
			System.out.println("已擁有鋤頭，一次只能擁有一個哦");
		}
		else {
			if(money>=420) {                   //判斷錢足夠
				money-=420;                    //錢-420
				hoe_exist=true;                //擁有鋤頭
				sethoe_durability();           //初始化鋤頭耐久度
				System.out.println("您成功購買了鋤頭");
			}
			else{System.out.println("金額不足，無法購買");}
		}
		
	}
	
	public void buy_sickle() {
		if(sickle_exist==true) {  //判斷是否擁有鐮刀
			System.out.println("已擁有鐮刀，一次只能擁有一個哦");
		}
		else{
			if(money>=210) {                   //判斷錢足夠
				money-=210;                    //錢-420
				sickle_exist=true;             //擁有鐮刀
				setsickle_durability();        //初始化鐮刀耐久度
				System.out.println("您成功購買了鐮刀");
			}
			else{System.out.println("金額不足，無法購買");}
		}
	}
	
	public void buy_watermelonseed() {
		if(money>=10) {  //判斷錢是否足夠
			money-=10;   //錢-10
			amount_watermelonseed+=1;  //擁有的西瓜種子+1
			thereiswatermelonseed=true;//擁有西瓜種子
			System.out.println("您成功購買了西瓜種子");
		}
		else{System.out.println("金額不足，無法購買");}
	}
	
	public void buy_mulberryseed() {
		if(money>=5) {  //判斷錢是否足夠
			money-=5;   //錢-5
			amount_mulberryseed+=1;  //擁有的桑樹種子+1
			thereismulberryseed=true;//擁有桑樹種子
			System.out.println("您成功購買了桑樹種子");
		}
		else{System.out.println("金額不足，無法購買");}
	}
	
	public void buy_sand() {
		if(money>=15) {  //判斷錢是否足夠
			money-=15;   //錢-15
			amount_sand+=1;  //擁有的沙土+1
			System.out.println("您成功購買了沙土");
		}
		else{System.out.println("金額不足，無法購買");}
	}
	
	public void buy_clay() {
		if(money>=20) {  //判斷錢是否足夠
			money-=20;   //錢-20
			amount_clay+=1;  //擁有的黏土+1
			System.out.println("您成功購買了黏土");
		}
		else{System.out.println("金額不足，無法購買");}
	}
	
	public void buy_loam() {
		if(money>=20) {  //判斷錢是否足夠
			money-=20;   //錢-20
			amount_loam+=1;  //擁有的壤土+1
			System.out.println("您成功購買了壤土");
		}
		else{System.out.println("金額不足，無法購買");}
	}
	
	public void buy_redbull() {
		if(money>=15) {
			money-=15;
			amount_redbull+=1;
			System.out.println("您成功購買了redbull");
		}
		else{System.out.println("金額不足，無法購買");}
	}
	
	public void drink_redbull() {
		if(amount_redbull>=1) {
			energy+=20;
			amount_redbull-=1;
		}
		else {System.out.println("背包無redbull，請前去購買");}
	}
	
	public void check() {
		if(watermelonplanted==true||mulberryplanted==true) {  //如果田中有種植植物的狀況
		System.out.print("田中目前種植：");
		if(watermelonplanted==true) {System.out.println("西瓜");}
		else if(mulberryplanted==true) {System.out.println("桑樹");}
		else {System.out.println("無種植植物，請前去購買");}
		
		System.out.print("土壤為：");
		if(sand_loosen=true) {System.out.println("沙土");}
		else if(clay_loosen=true) {System.out.println("黏土");}
		else if(loam_loosen=true) {System.out.println("壤土");}
		else {System.out.println("無土壤，請前去購買");}
		
		System.out.println("濕度為："+environment1.get_moisture());
		
		System.out.print("已生長");
		if(watermelonplanted==true) {System.out.println(vegetable1.getwatermelon_day_planted()+"天");}
		else if(mulberryplanted==true) {System.out.println(vegetable1.getmulberry_day_planted()+"天");}
		else {System.out.println("無種植植物，請前去購買");}
		
		System.out.print("預計再過");
		if(watermelonplanted==true) {System.out.println((vegetable1.getwatermelon_day()-vegetable1.getwatermelon_day_planted())+"天結成果實");}  //預計再幾天成熟的天數=成熟所需天數-已種植天數        
		else if(mulberryplanted==true) {System.out.println((vegetable1.getmulberry_day()-vegetable1.getmulberry_day_planted())+"天結成果實");}   //預計再幾天成熟的天數=成熟所需天數-已種植天數
		else {System.out.println("無種植植物，請前去購買");}
		}
		
		else {
			System.out.println("田中目前無種植植");
			System.out.print("土壤為：");
			if(sand_loosen==true) {System.out.println("沙土");}
			else if(clay_loosen==true) {System.out.println("黏土");}
			else if(loam_loosen==true) {System.out.println("壤土");}
			else {System.out.println("無");}
			System.out.println("濕度為"+environment1.get_moisture());
		}
		
		
	}
	
	
	public void sleep() {
		energy+=70;   //睡眠體力+70
		if(watermelonplanted=true) {vegetable1.setwatermelon_dayplus1();}   //現在種植西瓜，過一天西瓜種植的天數+1
		else if(mulberryplanted=true) {vegetable1.setmulberry_dayplus1();}  //現在種植桑樹，過一天桑樹種植的天數+1
		}
	
	public void backpack() {  //檢查背包內物品	
	   System.out.println("工具：");
	   if(wateringcan_exist==true) {System.out.println("澆水器耐久度："+wateringcan_durability);}
	   if(hoe_exist==true) {System.out.println("鋤頭耐久度："+hoe_durability);}
	   if(sickle_exist==true) {System.out.println("鐮刀耐久度："+sickle_durability);}
	   
	   System.out.println("種子：");
	   System.out.println("西瓜種子："+amount_watermelonseed);
	   System.out.println("桑樹種子："+amount_mulberryseed);
	   
	   System.out.println("土壤:");
	   if(thereisunusedsand==true) {System.out.println("沙土"+amount_sand);}
	   if(thereisunusedclay==true) {System.out.println("黏土"+amount_clay);}
	   if(thereisunusedloam==true) {System.out.println("壤土"+amount_loam);}
	}
	
	}