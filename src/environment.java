import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class environment{
	
	private BufferedReader br;
	private FileReader fr;
	private FileWriter fw;
	//private Random random;
	
	public environment() {
		//random=new Random();
		try {
			try {
				BufferedWriter fw=new BufferedWriter(new FileWriter("./src/Environment/environment.txt"));
				for(int i=1;i<=10;i++) {
				fw.write("normal\r\nnormal\r\nrainy\r\nrainy\r\nnormal\r\nsunny\r\nsunny\r\nnormal\r\nnormal\r\nstorm\r\n");}fw.flush();fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fr=new FileReader("./src/Environment/environment.txt");
			
			br=new BufferedReader(fr);
			weather=br.readLine();
		}
		catch(FileNotFoundException e){
			System.out.println("找不到此檔案");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private int day;
	public final int sunny=-15;
    public final int storm=10;
    public final int normal=-5;
    public final int rainy=5;
    private int moisture;  //濕度
    private int moisture_endday;  //結算濕度
    private String weather;
    
	public void setday() {this.day=1;}
	public int getday() {return day;}
	public void nextday() {this.day+=1;}  //過一天，天數加一
	
	public void set_moisture() {this.moisture=0;}  //初始化
	public int get_moisture() {return moisture;}
	

	
	public void new_change_soil() {this.moisture=20;}  //一旦填土或換土，濕度改為20
	public void water() {this.moisture+=5;}  //澆水，濕度加五

	public void nextday_moisture() throws IOException {
		switch(weather) {                       //br.readLine()
		case "normal":                               //讀到檔案天氣為normal
			this.moisture=moisture_endday+normal;break;   //隔天的濕度前一天的結算濕度＋環境濕度
		case "rainy":                                //讀到檔案天氣為rainy
			this.moisture=moisture_endday+rainy;break;    //隔天的濕度前一天的結算濕度＋環境濕度
		case "sunny":                                //讀到檔案天氣為sunny
			this.moisture=moisture_endday+sunny;break;    //隔天的濕度前一天的結算濕度＋環境濕度
		case "storm":                                //讀到檔案天氣為storm
			this.moisture=moisture_endday+storm;break;    //隔天的濕度前一天的結算濕度＋環境濕度
		}
	}
	
	public void setweather() {this.weather="none";}
	public String getweather() throws IOException {return weather;}
	
	public void setmoisture_endday() {this.moisture_endday=0;}  //初始化結算濕度
	public int getmoisture_endday() {return moisture_endday;}
	
	public void setmoisture_sleep() {this.moisture_endday=moisture;}  //當玩家書輸入sleep代表這天結束，結算濕度為一整天運算過後的moisture
	
	public void setenvironment_moisture() throws IOException {
		switch(weather) {
		case "normal":                               //讀到檔案天氣為normal
			this.moisture=moisture+normal;break;          //換土或填土後會受到環境濕度的影響
		case "rainy":                                //讀到檔案天氣為rainy
			this.moisture=moisture+rainy;break;           //換土或填土後會受到環境濕度的影響
		case "sunny":                                //讀到檔案天氣為sunny
			this.moisture=moisture+sunny;break;           //換土或填土後會受到環境濕度的影響
		case "storm":                                //讀到檔案天氣為storm
			this.moisture=moisture+storm;break;           //換土或填土後會受到環境濕度的影響
		}
	}
		
}
