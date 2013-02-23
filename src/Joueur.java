import java.util.Random;


public abstract class Joueur {
	
	protected Combinaison laCombinaison;
	
	public Joueur(int a, int b, int c, int d){
		laCombinaison = new Combinaison(a,b,c,d);
	}
	public Joueur(){
		laCombinaison=new Combinaison();
	}
	
	public static int[] creerCombinaisonAleatoirement(int nbrCouleurs){
		int lacombinaison[] = new int[4];
		int i;
		Random randomGenerator = new Random();
		for(i=0;i<4;i++){
			lacombinaison[i]=randomGenerator.nextInt(nbrCouleurs);
		}
		return lacombinaison;
	}
	
	public static int[] creerCombinaison(Combinaison laCombinaison){
		return laCombinaison.getCombinaison();
	}
	
	public void chercherCombinaison(Combinaison laProposition){
			laCombinaison.verifcombinaison(laProposition.getCombinaison());
		
	}
	
	public Combinaison getCombinaison(){
		return laCombinaison;
	}
	
}
