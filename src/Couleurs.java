
public class Couleurs {
	private String couleurs[] ;
	
	public Couleurs(){
		couleurs= new String[]{"bleu","rouge","noir","jaune","orange","vert","turquoise","violet"};
	}
	
	public String[] getCouleurs(){
		return couleurs;
	}
	
	public String getCouleur(int id){
		return couleurs[id];
	}
	
	public int idCouleur(String nomCouleur){
		int i,res=0;
		for(i=0;i<8;i++){
			if(couleurs[i]==nomCouleur){
				res=i;
			}
		}
		return res;
		
	}
	
}
