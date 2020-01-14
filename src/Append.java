public class Append{
   private int append;
   public void setAppend(int append){
	   this.append=append;
   }
   public String getAppend(){
	   if(append==0){
		   return "Sunny";
	   }
	   else if(append==1){
		   return "Storm";
	   }
	   else if(append==2){
		   return "Normal";
	   }
	   else{
		   return "Rainy";
	   }
   }
   
}