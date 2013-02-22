
public class Combinaison {
	private int[] combinaison;
	private int[] proposition;
	private int nbrbienplace,nbrmalplace;
	
	public Combinaison(){
		combinaison= new int[4];
		proposition = new int[4];
		for(int i=0;i<4;i++){
			combinaison[i]=-1;
			proposition[i]=-1;
		}
		nbrbienplace=0;
		nbrmalplace=0;
	}
	
	public Combinaison(int a, int b, int c, int d){
		combinaison = new int[4];
		proposition = new int[4];
		combinaison[0] = a;
		combinaison[1] = b;
		combinaison[2] = c;
		combinaison[3] = d;
		nbrbienplace=0;
		nbrmalplace=0;
	}
	
	
	public void verifcombinaison(int[] laproposition){
		int j,i;
		proposition[0]=laproposition[0];
		proposition[1]=laproposition[1];
		proposition[2]=laproposition[2];
		proposition[3]=laproposition[3];

		boolean res[]=new boolean[4];
		for(i=0;i<4;i++){
			res[i]=false;
			if(proposition[i]==combinaison[i]){
				nbrbienplace +=1;
				proposition[i]=-1;
				combinaison[i]=-2;
				res[i]=true;
			}
		}
		 for(i=0;i<4;i++){
		   for(j=0;j<4;j++){
		     if((i!=j)&&(combinaison[i] == proposition[j])){
		    	 nbrmalplace++;
		    	 combinaison[i] = -2;
		         proposition[j] = -1;
		      }
		    }
		  }	
	}
	
		
			
	public int getBienPlace(){
		return nbrbienplace;
	}
	
	public int getMalPlace(){
		return nbrmalplace;
	}
	
	public int[] getcombinaison(){
		return combinaison;
	}
}
