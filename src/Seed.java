public class Seed{
	private int quantity=0;
	private boolean intheearth=false;
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public int getQuantity(){
		return quantity;
	}
	public void isInTheEarth(){
		this.intheearth=true;
	}
	public void isOffTheEarth(){
		this.intheearth=false;
	}
	public boolean getInTheEarth(){
		return intheearth;
	}
	
}