public class vegetable{
	
	public int watermelon_day;   //西瓜成熟所需天數
	public int mulberry_day;     //桑樹成熟所需天數

    private int amount_watermelonfruit;  //西瓜果實數量
    private int amount_mulberryfruit;    //桑樹果實數量
    
    private int watermelonprice;
    private int mulberryprice;
    
    
    public void setwatermelon_day() {watermelon_day=12;}  //西瓜成熟所需天數
    public int getwatermelon_day() {return watermelon_day;}
    
    public void setmulberry_day() {this.mulberry_day=16;}     //桑樹成熟所需天數
    public int getmulberry_day() {return mulberry_day;}
    

    
    public void setamount_watermelonfruit() {this.amount_watermelonfruit=4;}  //正常情況下西瓜可4個果實成熟
    public int getamount_watermelonfruit() {return amount_watermelonfruit;}
    
    public void setamount_mulberryfruit() {this.amount_mulberryfruit=8;}  //正常情況下桑樹可8個果實成熟
    public int getamount_mulberryfruit() {return amount_mulberryfruit;}
    
    public void watermelon_clay() {this.watermelon_day-=3; this.amount_watermelonfruit-=1;}  //使用clay種植，所需天數-3，成熟果實數-1
    public void watermelon_loam() {this.watermelon_day+=3; this.amount_watermelonfruit+=1;}  //使用loam種植，所需天數+3，成熟果實數+1
    
    public void mulberry_clay() {this.mulberry_day-=3; this.amount_mulberryfruit-=1;}  //使用clay種植，所需天數-3，成熟果實數-1
    public void mulberry_loam() {this.mulberry_day+=3; this.amount_mulberryfruit+=1;}  //使用loam種植，所需天數+3，成熟果實數+1
    
    private int watermelon_day_planted;  //已種植西瓜天數
    private int mulberry_day_planted;    //已種植桑樹天數
    
    public void setwatermelon_day_planted() {this.watermelon_day_planted=0;}      //西瓜已種植的天數
    public void setwatermelon_dayplus1() {this.watermelon_day_planted+=1;}        //過一天，西瓜種植的天數加一
    public int getwatermelon_day_planted() {return watermelon_day_planted;}
    
    public void setmulberry_day_planted() {this.mulberry_day_planted=0;}          //桑樹已種植的天數
    public void setmulberry_dayplus1() {this.mulberry_day_planted+=1;}            //過一天，桑樹種植的天數加一
    public int getmulberry_day_planted() {return mulberry_day_planted;}
    
   
    
    
    private int watermelon_planteddate;  //西瓜開始種植的日子
    private int mulberry_planteddate;    //桑樹開始種植的日子
    
    public void setwatermelon_planteddate(int watermelon_planteddate) {this.watermelon_planteddate=watermelon_planteddate;}
    public int getwatermelon_planteddate() {return watermelon_planteddate;}
	
    public void setmulberry_planteddate(int mulberry_planteddate) {this.mulberry_planteddate=mulberry_planteddate;}
    public int getmulberry_planteddate() {return mulberry_planteddate;}
   
    public void watermelon_decay() {amount_watermelonfruit-=1;}  //西瓜衰敗，能結出的果實數量-1
    public void mulberry_decay() {amount_mulberryfruit-=1;}      //桑樹衰敗，能結出的果實數量-1
	
    
    private boolean vegetableplanted;
    public void setvegetableplanted() {this.vegetableplanted=false;}
    public void vegetableplanted() {this.vegetableplanted=true;}
    public boolean getvegetable1planted() {return this.vegetableplanted;}
	
	public void setwatermelonprice() {this.watermelonprice=35;}
	public int getwatermelonprice() {return watermelonprice;}
	
	public void setmulberryprice() {this.mulberryprice=10;}
	public int getmulberryrice() {return mulberryprice;}
	
	}
   
