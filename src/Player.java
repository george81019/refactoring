public class Player{
	private int energy=100;
	private int money=900;
	private String name;
	
	public void setEnergy(int energy){
		this.energy=energy;
	}
	public int getEnergy(){
		return energy;
	}
	public void setMoney(int money){
		this.money=money;
	}
	public int getMoney(){
		return money;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	//method buying
	public void Buying_wateringcan(Wateringcan wateringcan){
		if(wateringcan.getbuyed()==false&&money>=50){
			wateringcan.setEndurance(100);
			money=money-50;
			wateringcan.isbuyed(true);
		}
		else{
			System.out.println("The watering can was buyed or you don't have enough money");
		}
	}
	public void Buying_hoe(Hoe hoe){
		if(hoe.getbuyed()==false&&money>=420){
			hoe.setEndurance(100);
			money=money-420;
			hoe.isbuyed(true);
		}
		else{
			System.out.println("The hoe was buyed or you don't have enough money");
		}
	}
	public void Buying_sickle(Sickle sickle){
		if(sickle.getbuyed()==false&&money>=210){
			sickle.setEndurance(100);
			money=money-210;
			sickle.isbuyed(true);
		}
		else{
			System.out.println("The sickle was buyed or you don't have enough money");
		}
	}
	public void Buying_watermelon(Watermelon watermelon){
		if(money>=10){
			money=money-10;
		    watermelon.setQuantity(watermelon.getQuantity()+1);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	public void Buying_mullberry(Mulberry mulberry){
		if(money>=5){
			money=money-5;
			mulberry.setQuantity(mulberry.getQuantity()+1);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	public void Buying_sand(Sand sand){
		if(money>=15){
			money=money-15;
		    sand.setQuantity(sand.getQuantity()+1);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	public void Buying_clay(Clay clay){
		if(money>=20){
			money=money-20;
			clay.setQuantity(clay.getQuantity()+1);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	public void Buying_loam(Loam loam){
		if(money>=20){
			money=money-20;
		    loam.setQuantity(loam.getQuantity()+1);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	//method watering
	public void Watering_sand(Sand sand,Wateringcan wateringcan){
		if(energy>10&&sand.getOnTheFarm()){
		energy=energy-10;
		sand.setHumidity(sand.getHumidity()+5);
		wateringcan.setEndurance(wateringcan.getEndurance()-5);
		}
	}
	public void Watering_clay(Clay clay,Wateringcan wateringcan){
		if(energy>10&&clay.getOnTheFarm()){
		energy=energy-10;
		clay.setHumidity(clay.getHumidity()+5);
		wateringcan.setEndurance(wateringcan.getEndurance()-5);
		}
	}
	public void Watering_loam(Loam loam,Wateringcan wateringcan){
		if(energy>10&&loam.getOnTheFarm()){
		energy=energy-10;
		loam.setHumidity(loam.getHumidity()+5);
		wateringcan.setEndurance(wateringcan.getEndurance()-5);
		}
	}
	//method fillandloosen
	public void Fillingandloosening_sand(Sand sand,Hoe hoe){
		if(energy>=5){
			energy=energy-5;
			sand.setHumidity(20);
			hoe.setEndurance(hoe.getEndurance()-10);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	public void Fillingandloosening_clay(Clay clay,Hoe hoe){
		if(energy>=5){
			energy=energy-5;
			clay.setHumidity(20);
			hoe.setEndurance(hoe.getEndurance()-10);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	public void Fillingandloosening_loam(Loam loam,Hoe hoe){
		if(energy>=5){
			energy=energy-5;
			loam.setHumidity(20);
			hoe.setEndurance(hoe.getEndurance()-10);
		}
		else{
			 System.out.println("you don't have enough money");
		}
	}
	//method reap and sell
	public int Reapingandselling_watermelon(Watermelon watermelon){
		if(watermelon.getInTheEarth()&&(watermelon.getDays()==0&&energy>=5)){
			energy=energy-5;
			money=money+watermelon.getFruits()*watermelon.price;
			watermelon.isOffTheEarth();
		}
		return money;
	}
	public int Reapingandselling_mulberry(Mulberry mulberry){
		if(mulberry.getInTheEarth()&&(mulberry.getDays()==0)&&energy>=5){
			energy=energy-5;
			money=money+mulberry.getFruits()*mulberry.price;
			mulberry.isOffTheEarth();
		}
		return money;
	}
	//method check
	public void Checking(Watermelon watermelon,Mulberry mulberry){
		if(watermelon.getInTheEarth()&&energy>=5){
			energy=energy-5;
			System.out.println("After "+watermelon.getDays()+" days, you'll get "+watermelon.getFruits()+" watermelon");
			System.out.println("Watermelon is suitable living in humidity 15-25");
			
		}
		else if(mulberry.getInTheEarth()&&energy>=5){
			energy=energy-5;
			System.out.println("After "+mulberry.getDays()+" days, you'll get "+mulberry.getFruits()+" mulberry");
			System.out.println("Mulberry is suitable living in humidity 25-35");
			
		}
		else{
			System.out.println("You didn't plant anything or you don't have enough energy");
		}
	}
	//method plant
    public void Plant_watermelon(Watermelon watermelon){
			watermelon.setDays(12);
			watermelon.setFruits(4);
			energy=energy-15;
			watermelon.setQuantity(watermelon.getQuantity()-1);
		
	}
    public void Plant_mulberry(Mulberry mulberry){
			mulberry.setDays(16);
			mulberry.setFruits(8);
			energy=energy-15;
			mulberry.setQuantity(mulberry.getQuantity()-1);
		
	}    
	//method sleep
	public void Sleep(){
		energy=energy+70;
	}
	//method plant whether die
	public void WhetherDie(Sand sand,Clay clay,Loam loam,Watermelon watermelon,Mulberry mulberry){
		 if(sand.getOnTheFarm()){
			 if(sand.getHumidity()>25||sand.getHumidity()<15){
				 if(watermelon.getInTheEarth()){
					 watermelon.setConti(true);
					 watermelon.die(sand,clay,loam);
				 }
			 }
			 else if(sand.getHumidity()>=15&&sand.getHumidity()<=25){
				 watermelon.setConti(false);
				 watermelon.setAccumulate(0);
			 }
			 else if(sand.getHumidity()>35||sand.getHumidity()<25){
				 if(mulberry.getInTheEarth()){
					 mulberry.setConti(true);
					 mulberry.die(sand,clay,loam);
				 }
			 }
			 else if(sand.getHumidity()>=25&&sand.getHumidity()<=35){
				 mulberry.setConti(false);
				 mulberry.setAccumulate(0);
			 }
			 
		 }
		 else if(clay.getOnTheFarm()){
			 if(clay.getHumidity()>25||clay.getHumidity()<15){
				 System.out.println("hoho");
				 if(watermelon.getInTheEarth()){
					 watermelon.setConti(true);
					 watermelon.die(sand,clay,loam);
				 }
			 }
			 else if(clay.getHumidity()>=15&&clay.getHumidity()<=25){
				 watermelon.setConti(false);
				 watermelon.setAccumulate(0);
			 }
			 else if(clay.getHumidity()>35||clay.getHumidity()<25){
				 if(mulberry.getInTheEarth()){
					 mulberry.setConti(true);
					 mulberry.die(sand,clay,loam);
				 }
			 }
			 else if(clay.getHumidity()>=25&&clay.getHumidity()<=35){
				 mulberry.setConti(false);
				 mulberry.setAccumulate(0);
			 }
		 }
		 else if(loam.getOnTheFarm()){
			 if(loam.getHumidity()>25||loam.getHumidity()<15){
				 if(watermelon.getInTheEarth()){
					 watermelon.setConti(true);
					 watermelon.die(sand,clay,loam);
				 }
			 }
			 else if(loam.getHumidity()>=15&&loam.getHumidity()<=25){
				 watermelon.setConti(false);
				 watermelon.setAccumulate(0);
			 }
			 else if(loam.getHumidity()>35||loam.getHumidity()<25){
				 if(mulberry.getInTheEarth()){
					 mulberry.setConti(true);
					 mulberry.die(sand,clay,loam);
				 }
			 }
			 else if(loam.getHumidity()>=25&&loam.getHumidity()<=35){
				 mulberry.setConti(false);
				 mulberry.setAccumulate(0);
			 }
		 }
	}
	/*public boolean bankrupt(Watermelon watermelon,Mulberry mulberry,Hoe hoe,Sickle sickle,Sand sand,Clay clay,Loam loam){
		if(money<=0){
			if(watermelon.getInTheEarth()==false&&mulberry.getInTheEarth()==false){
				if((watermelon.getQuantity()+mulberry.getQuantity())!=0){
					if(sickle.getEndurance()!=0){
						if(sand.getQuantity()+clay.getQuantity()+loam.getQuantity()!=0){
							if(hoe.getEndurance()!=0){
								return false;
							}
							else{
								System.out.println("You don't have any hoe and money");
								return true;
							}
						}
						else{
							System.out.println("You don't have any earth and money");
							return true;
						}
					}
					else{
						System.out.println("You don't have any sickle and money");
						return true;
					}
				}
				else{
					System.out.println("You don't have any seed and money");
					return true;
				}
			}
			else if(watermelon.getInTheEarth()){
				if(watermelon.getFruits()==0){
					if(watermelon.getQuantity()!=0){
						if(sickle.getEndurance()!=0){
							if(sand.getQuantity()+clay.getQuantity()+loam.getQuantity()!=0){
								if(hoe.getEndurance()!=0){
									return false;
								}
								else{
									System.out.println("You don't have any hoe, fruits and money");
									return true;
								}
							}
							else{
								System.out.println("You don't have any earth, fruits and money");
								return true;
							}
						}
						else{
							System.out.println("You don't have any sickle, fruits and money");
							return true;
						}
					}
					else{
						System.out.println("You don't have any seed, fruits and money");
						return true;
					}
				}
				else{
					return false;
				}
			}
			else if(mulberry.getInTheEarth()){
				if(mulberry.getFruits()==0){
					if(mulberry.getQuantity()!=0){
						if(sickle.getEndurance()!=0){
							if(sand.getQuantity()+clay.getQuantity()+loam.getQuantity()!=0){
								if(sickle.getEndurance()!=0){
									return false;
								}
								else{
									System.out.println("You don't have any hoe, fruits and money");
									return true;
								}
							}
							else{
								System.out.println("You don't have any earth, fruits and money");
								return true;
							}
						}
						else{
							System.out.println("You don't have any sickle, fruits and money");
							return true;
						}
					}
					else{
						System.out.println("You don't have any seed, fruits and money");
						return true;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}*/
	public boolean bankrupt(Watermelon watermelon,Mulberry mulberry){
		if(money<=0){
				if(!watermelon.getInTheEarth()&&!mulberry.getInTheEarth()){
					return true;
				}
				else if(watermelon.getInTheEarth()){
					if(watermelon.getFruits()==0){
						return true;
					}
					else{
						return false;
					}
					
				}
				else{
					if(mulberry.getFruits()==0){
						return true;
					}
					else{
						return false;
					}	
				}
			
		}
		else{
			return false;
		}
	}
	
	
	
	
	
	
	
}