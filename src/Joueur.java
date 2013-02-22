import java.util.Random;


public abstract class Joueur {
	
	protected Combinaison laCombinaison;
	
	public Combinaison getCombinaison(){
		return laCombinaison;
	}
	
	public int[] creerCombinaisonAleatoirement(int nbrCouleurs){
		int lacombinaison[] = new int[4];
		int i;
		Random randomGenerator = new Random();
		for(i=0;i<4;i++){
			lacombinaison[i]=randomGenerator.nextInt(nbrCouleurs);
		}
		return lacombinaison;
	}
	
	public int[] creerCombinaison(Combinaison laCombinaison){
		return laCombinaison.getcombinaison();
	}
	 
	
}
