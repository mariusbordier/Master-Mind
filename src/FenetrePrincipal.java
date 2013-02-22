import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class FenetrePrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel container= new JPanel();
	
	//Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuprincipal = new JMenu("Fichier");
	private JMenu nouveauJeu	= new JMenu("Nouveau Jeu");
	private JMenuItem facile = new JMenuItem("Facile");
	private JMenuItem moyen	= new JMenuItem("Moyen");
	private JMenuItem difficile	= new JMenuItem("Difficile");
	private JMenuItem voirLaSolution = new JMenuItem("Voir la solution");
	private JMenuItem meilleureScore = new JMenuItem("Meilleurs scores");
	private JMenuItem quitter = new JMenuItem("Quitter");
	
	private String niveauDifficulte;
	private int[] lacombinaisonATrouve = new int[4];
	private int[] proposition ={-1,-1,-1,-1};
	private int nbrTour,posPion,lignes,collones,nbrPionBienPlace,nbrPionMalPlace,nbJoueur=0;
	
	
	//Images Pions
	private ImageIcon iconBleu = new ImageIcon(this.getClass().getResource("/Images/bleu.gif"));
	private ImageIcon iconRouge = new ImageIcon(this.getClass().getResource("/Images/rouge.gif"));
	private ImageIcon iconNoir = new ImageIcon(this.getClass().getResource("/Images/noir.gif"));
	private ImageIcon iconJaune = new ImageIcon(this.getClass().getResource("/Images/jaune.gif"));
	private ImageIcon iconOrange = new ImageIcon(this.getClass().getResource("/Images/orange.gif"));
	private ImageIcon iconVert = new ImageIcon(this.getClass().getResource("/Images/vert.gif"));
	private ImageIcon iconTurquoise = new ImageIcon(this.getClass().getResource("/Images/turquoise.gif"));
	private ImageIcon iconViolet = new ImageIcon(this.getClass().getResource("/Images/violet.gif"));
	private ImageIcon iconPion = new ImageIcon(this.getClass().getResource("/Images/pion.png"));
	private ImageIcon iconPionResultat = new ImageIcon(this.getClass().getResource("/Images/pionResultat.png"));
	private ImageIcon iconPionResultatNoir = new ImageIcon(this.getClass().getResource("/Images/pionResultatNoir.png"));
	private ImageIcon iconPionResultatBlanc = new ImageIcon(this.getClass().getResource("/Images/pionResultatBlanc.png"));


	private JLabel pion = new JLabel("Choisissez un pion :");
	private JLabel solution = new JLabel("La solution est :");
	
	//Buttons de chaque pions pour avoir une action sur chaque boutton
	private JButton boutonBleu = new JButton(iconBleu);
	private JButton boutonRouge = new JButton(iconRouge);
	private JButton boutonNoir = new JButton(iconNoir);
	private JButton boutonJaune = new JButton(iconJaune);
	private JButton boutonOrange = new JButton(iconOrange);
	private JButton boutonVert = new JButton(iconVert);
	private JButton boutonTurquoise = new JButton(iconTurquoise);
	private JButton boutonViolet = new JButton(iconViolet);
	private JButton[] tableauDeSolution = new JButton[4];
	
	
	//plateauJeu
	private JLabel[][] plateauJeu=new JLabel[10][4];
	private JLabel[][] plateauPionResultat=new JLabel[10][4];
	private JLabel[] plateauSolution = new JLabel[4];
	
	private JButton validerLigne = new JButton("Valider la ligne");
	private JButton effacerDernierPion = new JButton("Effacer dernier pion");
	private JButton effacerLigne = new JButton("Effacer Ligne");
	
	private Ordinateur ordi = new Ordinateur();
	private Humain lejoueur = new Humain();
	private Couleurs c = new Couleurs();
	
	public FenetrePrincipal(String leNiveauDeDifficulte,Combinaison laCombinaison){
		super("Master Mind");
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(container);
		container.setLayout(null);
		this.menuBar.add(menuprincipal);
		this.setJMenuBar(menuBar);
		
		nbrTour = 0;
		posPion = 0;
		
		niveauDifficulte = leNiveauDeDifficulte;
		
		nouveauJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			}
		});
		this.menuprincipal.add(nouveauJeu);
		facile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrame fen;
				ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
				fen = new FenetrePrincipal("Facile",new Combinaison());
				((JFrame) fen).getContentPane().add(panel);
			}
		});
		this.nouveauJeu.add(facile);
		
		moyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrame fen;
				ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
				fen = new FenetrePrincipal("Moyen",new Combinaison());
				((JFrame) fen).getContentPane().add(panel);
			}
		});
		this.nouveauJeu.add(moyen);
		
		difficile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrame fen;
				ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
				fen = new FenetrePrincipal("Difficile",new Combinaison());
				((JFrame) fen).getContentPane().add(panel);
			}
		});
		this.nouveauJeu.add(difficile);
		
		voirLaSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(collones=0;collones<4;collones++){
					tableauDeSolution[collones].setEnabled(true);
				}
				boutonBleu.setEnabled(false);
				boutonRouge.setEnabled(false);
				boutonNoir.setEnabled(false);
				boutonJaune.setEnabled(false);
				boutonOrange.setEnabled(false);
				boutonVert.setEnabled(false);
				boutonTurquoise.setEnabled(false);
				boutonViolet.setEnabled(false);
				validerLigne.setEnabled(false);
				effacerDernierPion.setEnabled(false);
				effacerLigne.setEnabled(false);
			}
		});
		this.menuprincipal.add(voirLaSolution);
		
		meilleureScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			}
		});
		this.menuprincipal.add(meilleureScore);
		
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				System.exit(0);
			}
		});
		this.menuprincipal.add(quitter);
		this.menuBar.add(menuprincipal);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		pion.setForeground(Color.WHITE);
		pion.setBounds(230, 20, 320, 40);
		
		solution.setForeground(Color.WHITE);
		solution.setBounds(20,470, 320, 40);
		
		boutonBleu.setBounds(230,50,40,40);
		boutonBleu.setBorderPainted(false);
		boutonRouge.setBounds(270,50,40,40);
		boutonRouge.setBorderPainted(false);
		boutonNoir.setBounds(310,50,40,40);
		boutonNoir.setBorderPainted(false);
		boutonJaune.setBounds(350,50,40,40);
		boutonJaune.setBorderPainted(false);
		boutonOrange.setBounds(230,100,40,40);
		boutonOrange.setBorderPainted(false);
		boutonVert.setBounds(270,100,40,40);
		boutonVert.setBorderPainted(false);
		boutonTurquoise.setBounds(310,100,40,40);
		boutonTurquoise.setBorderPainted(false);
		boutonViolet.setBounds(350,100,40,40);
		boutonViolet.setBorderPainted(false);
		container.add(pion);
		container.add(solution);
		container.add(boutonBleu);
		container.add(boutonRouge);
		container.add(boutonNoir);
		container.add(boutonJaune);
		container.add(boutonOrange);
		container.add(boutonVert);
		container.add(boutonTurquoise);
		container.add(boutonViolet);
		
		
		effacerDernierPion.setBounds(230, 200, 150, 40);
		container.add(effacerDernierPion);
		
		effacerLigne.setBounds(230, 250, 150, 40);
		container.add(effacerLigne);
		
		validerLigne.setBounds(230, 150, 150, 40);
		container.add(validerLigne);
		
		if(niveauDifficulte == "Facile"){
			lacombinaisonATrouve = ordi.creerCombinaisonAleatoirement(4);
			boutonOrange.setEnabled(false);
			boutonVert.setEnabled(false);
			boutonTurquoise.setEnabled(false);
			boutonViolet.setEnabled(false);
		}else if(niveauDifficulte == "Moyen"){
			lacombinaisonATrouve = ordi.creerCombinaisonAleatoirement(6);
			boutonTurquoise.setEnabled(false);
			boutonViolet.setEnabled(false);

		}else{
			if(laCombinaison.getcombinaison()[0]==-1){
				lacombinaisonATrouve = ordi.creerCombinaisonAleatoirement(8);
			}else{
				lacombinaisonATrouve = ordi.creerCombinaison(laCombinaison);
				nbJoueur=2;
			}
			
		}
		
		//initialisation du plateauJeu par des cases vides
     	for( lignes=0;lignes<10;lignes++){
    		for( collones=0;collones<4;collones++){
    			plateauJeu[lignes][collones]= new JLabel(iconPion);
    		}
    	}
     	//initialisation de la position de chaque cases sur le plateauJeu
    	for( lignes=0;lignes<10;lignes++){
    		for( collones=0;collones<4;collones++){
    			plateauJeu[lignes][collones].setBounds(collones*40+10, lignes*40+10, 40, 40);
    		}
    	}
    	
    	//initialisation du plateauRes par des cases vides
     	for( lignes=0;lignes<10;lignes++){
    		for( collones=0;collones<4;collones++){
    			plateauPionResultat[lignes][collones]= new JLabel(iconPionResultat);
    		}
    	}
     	//initialisation de la position de chaque cases sur le plateauRes
     	for( lignes=0;lignes<10;lignes++){
    		for( collones=0;collones<4;collones++){
    			if(collones%2==0)
    				plateauPionResultat[lignes][collones].setBounds(collones*8+170, lignes*40+18, 20, 12);
    			else if(collones%2==1)
    				plateauPionResultat[lignes][collones].setBounds(collones*8+170-7, lignes*40+32, 20, 12);
    		}
    	}
    	
    	//ajout du plateauRes a la fenetre
     	for( lignes=0;lignes<10;lignes++){
    		for( collones=0;collones<4;collones++){
    	    	container.add(plateauPionResultat[lignes][collones]);
    		}
    	}
    	
    	for( lignes=0;lignes<10;lignes++){
    		for( collones=0;collones<4;collones++){
    	    	container.add(plateauJeu[lignes][collones]);
    		}
    	}
    	
    	for( collones=0;collones<4;collones++){
    		plateauSolution[collones]= new JLabel(iconPion);
    	}
    	
    	for( collones=0;collones<4;collones++){
    		plateauSolution[collones].setBounds(collones*40+10, 500, 40, 40);
    	}
    	
    	for( collones=0;collones<4;collones++){
    		String lacouleur = c.getCouleur(lacombinaisonATrouve[collones]);
    		ImageIcon icon = new ImageIcon(this.getClass().getResource("/Images/"+lacouleur+".gif"));
    		tableauDeSolution[collones]= new JButton(icon);
    	    tableauDeSolution[collones].setBounds(collones*40+10, 500, 40, 40);
    	    tableauDeSolution[collones].setBorderPainted(false);
    	    container.add(tableauDeSolution[collones]);
    	    tableauDeSolution[collones].setEnabled(false);
    	}
    	
    	boutonBleu.addActionListener(new PionBleu());
    	boutonRouge.addActionListener(new PionRouge());
    	boutonNoir.addActionListener(new PionNoir());
    	boutonJaune.addActionListener(new PionJaune());
    	boutonOrange.addActionListener(new PionOrange());
    	boutonVert.addActionListener(new PionVert());
    	boutonTurquoise.addActionListener(new PionTurquoise());
    	boutonViolet.addActionListener(new PionViolet());
    	effacerDernierPion.addActionListener(new EffacerDernierPion());
    	effacerLigne.addActionListener(new EffacerLigne());
    	validerLigne.addActionListener(new ValiderLigne());
	
	}



class PionBleu  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconBleu);
        	proposition[posPion]=c.idCouleur("bleu");
        	posPion++;
    	}else{
        		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
        	}
    }
    
}

class PionRouge  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconRouge);
        	proposition[posPion]=c.idCouleur("rouge");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}

class PionNoir  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconNoir);
        	proposition[posPion]=c.idCouleur("noir");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionJaune  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconJaune);
        	proposition[posPion]=c.idCouleur("jaune");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionOrange  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconOrange);
        	proposition[posPion]=c.idCouleur("orange");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionVert  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconVert);
        	proposition[posPion]=c.idCouleur("vert");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionTurquoise  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconTurquoise);
        	proposition[posPion]=c.idCouleur("turquoise");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionViolet implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[nbrTour][posPion].setIcon(iconViolet);
        	proposition[posPion]=c.idCouleur("violet");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complte, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}

class EffacerDernierPion  implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
    	container.revalidate();
    	container.repaint();
    	if(posPion>0){
    	posPion--;
    	proposition[posPion]=-1;
    	plateauJeu[nbrTour][posPion].setIcon(iconPion);
    	}
    }	
}

class EffacerLigne  implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
    	container.revalidate();
    	container.repaint();
    	for(int i=posPion-1;i>=0;i--){
    		plateauJeu[nbrTour][i].setIcon(iconPion);
    		if(proposition[i]!=-1){
    			proposition[i]=-1;
    		}
    	}
    	posPion=0;
    }
}

class ValiderLigne  implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
    	boolean res=false;
    	nbrPionBienPlace=0;
    	nbrPionMalPlace=0;
    	container.revalidate();
    	container.repaint();
    	if(posPion==4){
    	posPion=0;
    	Combinaison lacombi;
		lacombi = new Combinaison(proposition[0], proposition[1], proposition[2], proposition[3]);
		lacombi.verifcombinaison(lacombinaisonATrouve);
		
		nbrPionBienPlace=lacombi.getBienPlace();
		nbrPionMalPlace=lacombi.getMalPlace();
		if(nbrPionBienPlace>0){
			for(int nbr=0;nbr<nbrPionBienPlace;nbr++){
				plateauPionResultat[nbrTour][nbr].setIcon(iconPionResultatNoir);
			}
			if(nbrPionBienPlace==4){
				JOptionPane.showMessageDialog(null, "Bravo vous avez gagnez !");
				boutonBleu.setEnabled(false);
				boutonRouge.setEnabled(false);
				boutonNoir.setEnabled(false);
				boutonJaune.setEnabled(false);
				boutonOrange.setEnabled(false);
				boutonVert.setEnabled(false);
				boutonTurquoise.setEnabled(false);
				boutonViolet.setEnabled(false);
				validerLigne.setEnabled(false);
				effacerDernierPion.setEnabled(false);
				effacerLigne.setEnabled(false);
				for(collones=0;collones<4;collones++){
					tableauDeSolution[collones].setEnabled(true);
				}
				res=true;

			}
		}
		if(nbrPionMalPlace>0){
			for(int nbr=nbrPionBienPlace;nbr<nbrPionBienPlace+nbrPionMalPlace;nbr++){
				plateauPionResultat[nbrTour][nbr].setIcon(iconPionResultatBlanc);
			}
		}
		if(nbrTour==9 && res==false){
			JOptionPane.showMessageDialog(null, "Vous avez perdu!");
			boutonBleu.setEnabled(false);
			boutonRouge.setEnabled(false);
			boutonNoir.setEnabled(false);
			boutonJaune.setEnabled(false);
			boutonOrange.setEnabled(false);
			boutonVert.setEnabled(false);
			boutonTurquoise.setEnabled(false);
			boutonViolet.setEnabled(false);
			validerLigne.setEnabled(false);
			effacerDernierPion.setEnabled(false);
			effacerLigne.setEnabled(false);
			for(collones=0;collones<4;collones++){
				tableauDeSolution[collones].setEnabled(true);
			}
		}
		
		if((nbrTour==9 && res==false)||nbrPionBienPlace==4){
			JFrame fen;
			String[] choix = {"A deux", "Tout seul","Quitter le jeu"};
			ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
			Object resChoix = JOptionPane.showInputDialog (new JFrame(), "Comment voulez vous rejouer ?","Master Mind",JOptionPane.QUESTION_MESSAGE,null,choix,choix[0]);
			if(resChoix.toString()=="A deux"){
				fen = new FenetreCreationCombinaison();
				((JFrame) fen).getContentPane().add(panel);
			}else if(resChoix.toString()=="Tout seul"){
			
				String[] difficulte = {"Facile", "Moyen", "Difficile"};
				Object choixDifficulte = JOptionPane.showInputDialog (new JFrame(), "Choisissez un niveau de difficultŽ","Master Mind",JOptionPane.QUESTION_MESSAGE,null,difficulte,difficulte[0]);
				if(choixDifficulte.toString()=="Facile"){
					fen = new FenetrePrincipal(choixDifficulte.toString(),new Combinaison());
					((JFrame) fen).getContentPane().add(panel);
				}
				else if(choixDifficulte.toString()=="Moyen"){
					fen = new FenetrePrincipal(choixDifficulte.toString(),new Combinaison());
					((JFrame) fen).getContentPane().add(panel);
				}else{
					fen = new FenetrePrincipal(choixDifficulte.toString(),new Combinaison());
					((JFrame) fen).getContentPane().add(panel);
				}
			}else{
				System.exit(0);
			}
		}
    	nbrTour++;
    	
    	
    	}
    }
}

}

	 
