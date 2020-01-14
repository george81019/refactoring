public class Earth{
	private int humidity=20;
	private int quantity=0;
	private boolean onthefarm=false;
	
	public void setHumidity(int humidity){
		this.humidity=humidity;
	}
	public int getHumidity(){
		return humidity;
	}
	public void ensureHumidity(){
		if(humidity<=0){
			humidity=0;
		}
		else if(humidity>=100){
			humidity=100;
		}
	}
	
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public int getQuantity(){
		return quantity;
	}
	
	public void isOnTheFarm(){
		this.onthefarm=true;
		quantity=quantity-1;
	}
	public void isOffTheFarm(){
		this.onthefarm=false;
	}
	public boolean getOnTheFarm(){
		return onthefarm;
	}
	public void Wateringforearth(){
		if(getOnTheFarm()){
			humidity=humidity+5;
		}
	}
	
}