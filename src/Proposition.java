
public class Proposition {

	String [] laproposition;
	
	public Proposition(){
		laproposition = new String[4];
	}
	
	public Proposition(String lapropo0,String lapropo1,String lapropo2,String lapropo3){
		laproposition[0] = lapropo0;
		laproposition[1] = lapropo1;
		laproposition[2] = lapropo2;
		laproposition[3] = lapropo3;
	}
	
	public String[] getLaProposition(){
		return laproposition;
	}
	
	public void setLaProposition(String lapropo0,String lapropo1,String lapropo2,String lapropo3){
		laproposition[0] = lapropo0;
		laproposition[1] = lapropo1;
		laproposition[2] = lapropo2;
		laproposition[3] = lapropo3;
	}
	
}
