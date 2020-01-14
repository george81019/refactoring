import java.util.*;
import java.io.*; 

public class Game{
 public static void main(String[] args){
	 Player player = new Player();
	 Sand sand = new Sand();
	 Clay clay = new Clay();
	 Loam loam = new Loam();//construct earth
	 Wateringcan wateringcan = new Wateringcan();
	 Hoe hoe = new Hoe();
	 Sickle sickle = new Sickle();//construct tool
	 Watermelon watermelon = new Watermelon();
	 Mulberry mulberry = new Mulberry();//construct seed
	 int humidity=0;
	 String Player_name;
	 System.out.println("Welcome to the Farm");
	 System.out.println("Please enter your name");
	 Scanner playername = new Scanner(System.in);
	 Player_name = playername.nextLine();
	 player.setName(Player_name);
	 System.out.println();
	 System.out.println("Hi, "+Player_name);
	 System.out.println();
	 Scanner environment=null;
	 Scanner instruction=null;
	 Scanner tips=null;
	 String str=null;
	 String ins=null;
	try{
		environment = new Scanner(new File("Environment//environment.txt"));
	}catch(Exception e){
		System.out.println("File not found");
	}
	
	try{
		instruction = new Scanner(new File("flow.txt"));
	}catch(Exception e){
		System.out.println("File not found");
	}
	while(instruction.hasNextLine()){
		 ins=instruction.nextLine();
		 System.out.println(ins);
	 }
	//int face;
	//PrintWriter writer=null;
	/*try{
		writer = new PrintWriter(new FileOutputStream("Environment//environment.txt",true));
	}catch(Exception e){
		System.out.println("File not found");
	}
	
	for(int r=1;r<=100000;r++){
		face =(int)(Math.random()*4);
		if(face==0){
			writer.println("Sunny");
		}
		else if (face==1){
			writer.println("Storm");
		}
		else if (face==2){
			writer.println("Rainy");
		}
		else if (face==3){
			writer.println("Normal");
		}
	}*/
	 labelmain:
	 for(int Days=1;Days<=100000;Days++){
		 if(environment.hasNextLine()){
			 str=environment.nextLine();
			 if(str.equals("Sunny")){
				 humidity= -15;
			 }
			 else if(str.equals("Storm")){
				 humidity= 10;
			 }
			 else if(str.equals("Normal")){
				 humidity= -5;
			 }
			 else if(str.equals("Rainy")){
				 humidity= 5;
			 }
		 }
		 else{
			 System.out.println("No next line");
			 break labelmain;
		 }
		 
		 //System.out.println(humidity);
		 labelfileinput:
		 if(sand.getOnTheFarm()){
			 sand.setHumidity(sand.getHumidity()+humidity);
		 }
		 else if(clay.getOnTheFarm()){
			 clay.setHumidity(clay.getHumidity()+humidity);
		 }
		 else if(loam.getOnTheFarm()){
			 loam.setHumidity(loam.getHumidity()+humidity);
		 }
		 sand.ensureHumidity();
		 clay.ensureHumidity();
		 loam.ensureHumidity();
		 System.out.println("==================================");
		 System.out.println("It's Day "+Days+". "+"A "+str+" day.");
		 System.out.println("Your energy: "+player.getEnergy());
		 System.out.println("Your money : "+player.getMoney());
		 System.out.println("----------------------------------");
		 System.out.println("watering can: "+wateringcan.getbuyed()+"("+wateringcan.getEndurance()+"/100)");
		 System.out.println("hoe         : "+hoe.getbuyed()+"("+hoe.getEndurance()+"/100)");
		 System.out.println("sickle      : "+sickle.getbuyed()+"("+sickle.getEndurance()+"/100)");
		 System.out.println("----------------------------------");
		 System.out.println("watermelon seed : "+watermelon.getQuantity());
		 System.out.println("mulberry   seed : "+mulberry.getQuantity());
		 System.out.println("----------------------------------");
		 System.out.println("sand : "+sand.getQuantity());
		 System.out.println("clay : "+clay.getQuantity());
		 System.out.println("loam : "+loam.getQuantity());
		 System.out.println("==================================");
		 System.out.println("|  Type  |     Item     |  price |");
	     System.out.println("==================================");
	     System.out.println("|  Seed  | watering can |    50  |");
		 System.out.println("|        |      hoe     |   420  |");
		 System.out.println("|        |     sickle   |   210  |");
		 System.out.println("==================================");
		 System.out.println("|  Tool  |  watermelon  |    10  |");
		 System.out.println("|        |   mulberry   |     5  |");
		 System.out.println("==================================");
		 System.out.println("|  Earth |     sand     |    15  |");
		 System.out.println("|        |     clay     |    20  |");
		 System.out.println("|        |     loam     |    20  |");
		 System.out.println("==================================");
		 System.out.println();
		 labelexecution:
		 for(int execution=1;execution<=100000;execution++){
			 Scanner scan = new Scanner(System.in);
			 String scanner = scan.nextLine();
			 String[] AfterSplit = scanner.split(" ");
			 int size = AfterSplit.length;
			 labelswitch:
			 switch(AfterSplit[0].intern()){
				 case"water":
				   if(size!=2){
					   System.out.println("Error Length");
					   continue labelexecution;
				   }
				   if(wateringcan.getbuyed()==false){
					   System.out.println("You didn't buy the watering can");
					   continue labelexecution;
				   }
				   if(AfterSplit[1].equals("watermelon")&&watermelon.getInTheEarth()){
					   player.Watering_sand(sand,wateringcan);
					   player.Watering_clay(clay,wateringcan);
					   player.Watering_loam(loam,wateringcan);
				   }
				   else if(AfterSplit[1].equals("mulberry")&&mulberry.getInTheEarth()){
					   player.Watering_sand(sand,wateringcan);
					   player.Watering_clay(clay,wateringcan);
					   player.Watering_loam(loam,wateringcan);
				   }
				   else{
					   System.out.println("Error Type or the seed is not in the earth");
					   continue labelexecution;
				   }
				   //when earth on the farm, watering
				   break;
				 case"fill":
				   if(AfterSplit[1].equals("and")&&AfterSplit[2].equals("loosen")){
					   if(watermelon.getInTheEarth()||mulberry.getInTheEarth()){
						   System.out.println("The seed is in the earth. You can't fill or loosen");
						   continue labelexecution;
					   }
					   if(hoe.getbuyed()==false){
						   System.out.println("You didn't buy the hoe");
						   continue labelexecution;
					   }
					   if(size!=4){
						   System.out.println("Error Length");
						   continue labelexecution;
					   }
					   if(AfterSplit[3].equals("sand")&&sand.getQuantity()>=1){
						   sand.isOnTheFarm();
						   player.Fillingandloosening_sand(sand,hoe);
						   clay.isOffTheFarm();
						   loam.isOffTheFarm();
						   if(sand.getOnTheFarm()){
								 sand.setHumidity(20+humidity);
							 }
		               }
					   else if(AfterSplit[3].equals("clay")&&clay.getQuantity()>=1){
						   clay.isOnTheFarm();
						   player.Fillingandloosening_clay(clay,hoe);
						   loam.isOffTheFarm();
						   sand.isOffTheFarm();
						   if(clay.getOnTheFarm()){
								 clay.setHumidity(20+humidity);
						   }
					   }
					   else if(AfterSplit[3].equals("loam")&&loam.getQuantity()>=1){
						   loam.isOnTheFarm();
						   player.Fillingandloosening_loam(loam,hoe);
						   clay.isOffTheFarm();
						   sand.isOffTheFarm();
						   if(loam.getOnTheFarm()){
								 loam.setHumidity(20+humidity);
							 }
					   }
					   else{
						   System.out.println("Error Type or there is no earth ");
						   continue labelexecution;
					   }
				   }
				   else{
					   System.out.println("Error Type");
					   continue labelexecution;
				   }
				   sand.ensureHumidity();
		           clay.ensureHumidity();
		           loam.ensureHumidity();
				   break labelswitch;
				 case"plant":
				   if(watermelon.getInTheEarth()||mulberry.getInTheEarth()){
					   System.out.println("The seed is in the earth. You can't plant anything now");
					   continue labelexecution;
				   }
				   if(size!=2){
					   System.out.println("Error Length");
					   continue labelexecution;
				   }
				   if(sand.getOnTheFarm()){
					   if(AfterSplit[1].equals("watermelon")&&watermelon.getQuantity()>=1&&player.getEnergy()>=15){
						   watermelon.isInTheEarth();
						   mulberry.isOffTheEarth();
						   watermelon.setConti(false);
						   watermelon.setAccumulate(0);
						   player.Plant_watermelon(watermelon);
					   }
					   else if(AfterSplit[1].equals("mulberry")&&mulberry.getQuantity()>=1&&player.getEnergy()>=15){
						   mulberry.isInTheEarth();
						   watermelon.isOffTheEarth();
						   mulberry.setConti(false);
						   mulberry.setAccumulate(0);
						   player.Plant_mulberry(mulberry);
					   }
					   else{
						   System.out.println("No that fruit or you don't have enough energy or seeds");
					       continue labelexecution;
					   }
						   
				   }
				   else if(clay.getOnTheFarm()){
					   if(AfterSplit[1].equals("watermelon")&&watermelon.getQuantity()>=1&&player.getEnergy()>=15){
						   watermelon.isInTheEarth();
						   mulberry.isOffTheEarth();
						   watermelon.setConti(false);
						   watermelon.setAccumulate(0);
						   player.Plant_watermelon(watermelon);
						   watermelon.setDays(watermelon.getDays()-3);
						   watermelon.setFruits(watermelon.getFruits()-1);
					   }
					   else if(AfterSplit[1].equals("mulberry")&&mulberry.getQuantity()>=1&&player.getEnergy()>=15){
						   mulberry.isInTheEarth();
						   watermelon.isOffTheEarth();
						   player.Plant_mulberry(mulberry);
						   mulberry.setConti(false);
						   mulberry.setAccumulate(0);
						   mulberry.setDays(mulberry.getDays()-3);
						   mulberry.setFruits(mulberry.getFruits()-1);
					   }
					   else{
						   System.out.println("No that fruit or you don't have enough energy or seeds");
					       continue labelexecution;
					   }
				   }
				   else if(loam.getOnTheFarm()){
					   if(AfterSplit[1].equals("watermelon")&&watermelon.getQuantity()>=1&&player.getEnergy()>=15){
						   watermelon.isInTheEarth();
						   mulberry.isOffTheEarth();
						   watermelon.setConti(false);
						   watermelon.setAccumulate(0);
						   player.Plant_watermelon(watermelon);
						   watermelon.setDays(watermelon.getDays()+3);
						   watermelon.setFruits(watermelon.getFruits()+1);
					   }
					   else if(AfterSplit[1].equals("mulberry")&&mulberry.getQuantity()>=1&&player.getEnergy()>=15){
						   mulberry.isInTheEarth();
						   watermelon.isOffTheEarth();
						   player.Plant_mulberry(mulberry);
						   mulberry.setConti(false);
						   mulberry.setAccumulate(0);
						   mulberry.setDays(mulberry.getDays()+3);
						   mulberry.setFruits(mulberry.getFruits()+1);
					   }
					   else{
						   System.out.println("No that fruit or you don't have enough energy or seeds");
					       continue labelexecution;
					   }
				   }
				   else{
					   System.out.println("No land on the farm");
					   System.out.println("Please fill and loosen");
				   }
				   
				   break;
				 case"reap":
				   if(size==4){
					   if(AfterSplit[1].equals("and")&&AfterSplit[2].equals("sell")){
						   if(sickle.getbuyed()==false){
							   System.out.println("You didn't buy the sickle");
							   continue labelexecution;
						   }
						   if(AfterSplit[3].equals("watermelon")){
							   player.Reapingandselling_watermelon(watermelon);
						   }
						   else if(AfterSplit[3].equals("mulberry")){
							   player.Reapingandselling_mulberry(mulberry);
						   }
						   else{
							   System.out.println("No that fruit");
							   continue labelexecution;
						   }
					   }
					   else{
						   System.out.println("Wrong Type");
					       continue labelexecution;
					   }
				   }
				   else{
					   System.out.println("Wrong length");
					   continue labelexecution;
				   }
				   break;
				 case"buy":
				   if(size==2){
					   switch(AfterSplit[1].intern()){
						   case"hoe":
						     player.Buying_hoe(hoe);
							 break;
						   case"sickle":
						     player.Buying_sickle(sickle);
							 break;
						   case"watermelon":
						     player.Buying_watermelon(watermelon);
							 break;
						   case"mulberry":
						     player.Buying_mullberry(mulberry);
							 break;
						   case"sand":
						     player.Buying_sand(sand);
							 break;
						   case"clay":
						     player.Buying_clay(clay);
							 break;
						   case"loam":
						     player.Buying_loam(loam);
							 break;
						   default:
						     System.out.println("Wrong Type");
							 break;
					   }
				   }
				   else if(size==3){
					   if(AfterSplit[1].equals("watering")&&AfterSplit[2].equals("can")){
						   player.Buying_wateringcan(wateringcan);
					   }
					   else{
						   System.out.println("Wrong Type");
						   continue labelexecution;
					   }
				   }
				   else{
					   System.out.println("Wrong Type");
					   continue labelexecution;
				   }
				   break;
				 case"check":
				   if(size==1){
					   player.Checking(watermelon,mulberry);
				   }
				   else{
					   System.out.println("Wrong Type");
				       continue labelexecution;
				   }
				   if(sand.getOnTheFarm()){
					   System.out.println("sand");
					   System.out.println("Humidity: "+sand.getHumidity());
				   }
				   else if(clay.getOnTheFarm()){
					   System.out.println("clay");
					   System.out.println("Humidity: "+clay.getHumidity());
				   }
				   else if(loam.getOnTheFarm()){
					   System.out.println("loam");
					   System.out.println("Humidity: "+loam.getHumidity());
				   }
				   break;
				 case"sleep":
				   if(size==1){
					   player.Sleep();
					   break labelexecution;
				   }
				   else{
					   System.out.println("Wrong Type");
					   continue labelexecution;
				   }
				 case"I":
				   if(size==5&&AfterSplit[1].equals("am")&&AfterSplit[2].equals("tired")&&AfterSplit[3].equals("of")&&AfterSplit[4].equals("it")){
					   break labelmain;
				   }
				   else{
					   System.out.println("Wrong Type");
					   continue labelexecution;
				   }
				 case"instruction":
				     try{
						tips = new Scanner(new File("flow.txt"));
					}catch(Exception e){
						System.out.println("File not found");
					}
					 while(tips.hasNextLine()){
						 ins=tips.nextLine();
						 System.out.println(ins);
					 }
					 continue labelexecution;
				 default:
				   System.out.println("Wrong Type");
				   continue labelexecution;
			 }
			 if(player.getEnergy()>100){
				 player.setEnergy(100);
			 }
			 else if(player.getEnergy()<=0){
				 player.Sleep();
				 break labelexecution;
			 }
			 System.out.println("===================================");
			 System.out.println("Your energy: "+player.getEnergy());
			 System.out.println("Your money : "+player.getMoney());
			 System.out.println("----------------------------------");
			 System.out.println("watering can: "+wateringcan.getbuyed()+"("+wateringcan.getEndurance()+"/100)");
			 System.out.println("hoe         : "+hoe.getbuyed()+"("+hoe.getEndurance()+"/100)");
			 System.out.println("sickle      : "+sickle.getbuyed()+"("+sickle.getEndurance()+"/100)");
			 System.out.println("----------------------------------");
			 System.out.println("watermelon seed : "+watermelon.getQuantity());
			 System.out.println("mulberry   seed : "+mulberry.getQuantity());
			 System.out.println("----------------------------------");
			 System.out.println("sand : "+sand.getQuantity());
			 System.out.println("clay : "+clay.getQuantity());
			 System.out.println("loam : "+loam.getQuantity());
             System.out.println("===================================");		
             System.out.println();		
			 if(player.bankrupt(watermelon,mulberry)){
			    break labelmain;
		     }					 
		 }//loopexecution
		 sand.ensureHumidity();
		 clay.ensureHumidity();
		 loam.ensureHumidity();
		 watermelon.DaysDecreasing();
		 mulberry.DaysDecreasing();
		 
		 if(watermelon.getInTheEarth()&&watermelon.getDays()<=0){
			 watermelon.setDays(0);
			 System.out.println("Go reap your watermelon now ");
		 }
		 else if(mulberry.getInTheEarth()&&mulberry.getDays()<=0){
			 mulberry.setDays(0);
			 System.out.println("Go reap your mulberry now ");
		 }
		 if(wateringcan.getbuyed()&&wateringcan.getEndurance()==0){
			 wateringcan.isbuyed(false);
		 }
		 else if(hoe.getbuyed()&&hoe.getEndurance()==0){
			 hoe.isbuyed(false);
		 }
		 else if(sickle.getbuyed()&&sickle.getEndurance()==0){
			 sickle.isbuyed(false);
		 }
		 if(player.getEnergy()>100){
			 player.setEnergy(100);
		 }
		 
		 //whether die
		 player.WhetherDie(sand,clay,loam,watermelon,mulberry);
	 }//loopmain
	 System.out.println("Your final money:"+player.getMoney());
	 
 }
}
