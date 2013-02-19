import java.util.*;

import javax.swing.JOptionPane;

public class Combinaison {
	private int[] combinaison;
	private int[] proposition;
	private int nbrbienplace,nbrmalplace,nbraucunpion;
	
	public Combinaison(){
		combinaison= new int[4];
		proposition = new int[4];
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
		//JOptionPane.showMessageDialog(null, proposition[0]+" "+proposition[1]+proposition[2]+proposition[3]);
		//JOptionPane.showMessageDialog(null, combinaison[0]+" "+combinaison[1]+combinaison[2]+combinaison[3]);
		int i ;
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
				res[i]=true;
			}
		}
		for(i=0;i<4;i++){
			if((combinaison[i]==proposition[0]||combinaison[i]==proposition[1]||combinaison[i]==proposition[2]||combinaison[i]==proposition[3])&&res[i]==false){
				nbrmalplace++;
			}else{
				nbraucunpion++;
			}
		}
		//nbrmalplace=nbrmalplace-nbrbienplace;
		
	}
		
		
	
		
			
	public int getBienPlace(){
		return nbrbienplace;
	}
	
	public int getMalPlace(){
		return nbrmalplace;
	}
	public int getAucunPion(){
		return nbraucunpion;
	}
	
	public int[] getcombinaison(){
		return combinaison;
	}
}
