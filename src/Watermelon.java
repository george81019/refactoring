public class Watermelon extends Seed{
	private int days=12;
	private int fruits=4;
	public final int price=35;
	private int accumulate=0;
	private boolean conti=false;
	
	public void setDays(int days){
		this.days=days;
	}
	public int getDays(){
		return days;
	}
	public void setFruits(int fruits){
		this.fruits=fruits;
	}
	public int getFruits(){
		return fruits;
	}
	public void setAccumulate(int accumulate){
		this.accumulate=accumulate;
	}
	public int getAccumulate(){
		return accumulate;
	}
	public void setConti(boolean conti){
		this.conti=conti;
	}
	public boolean getConti(){
		return conti;
	}
	public void DaysDecreasing(){
		if(getInTheEarth()){
			 days=days-1;
		 }
	}
	public boolean die(Sand sand,Clay clay,Loam loam){
		if(conti&&days!=0){
			accumulate=accumulate+1;
			if(accumulate>3&&accumulate<=5){
				fruits=fruits-1;
				if(fruits==0){
					isOffTheEarth();
					if(sand.getOnTheFarm()){
						sand.isOffTheFarm();
					}
					else if(clay.getOnTheFarm()){
						clay.isOffTheFarm();
					}
					else if(loam.getOnTheFarm()){
						loam.isOffTheFarm();
					}
					return true;//die
				}
				return false;//alive
			}
			else if(accumulate>5){
				isOffTheEarth();
				if(sand.getOnTheFarm()){
					sand.isOffTheFarm();
				}
				else if(clay.getOnTheFarm()){
					clay.isOffTheFarm();
				}
				else if(loam.getOnTheFarm()){
					loam.isOffTheFarm();
				}
				return true;//die
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}