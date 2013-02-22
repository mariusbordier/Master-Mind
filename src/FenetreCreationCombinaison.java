import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FenetreCreationCombinaison extends JFrame {
	
	private JPanel container= new JPanel();
	
	private ImageIcon iconBleu = new ImageIcon(this.getClass().getResource("/Images/bleu.gif"));
	private ImageIcon iconRouge = new ImageIcon(this.getClass().getResource("/Images/rouge.gif"));
	private ImageIcon iconNoir = new ImageIcon(this.getClass().getResource("/Images/noir.gif"));
	private ImageIcon iconJaune = new ImageIcon(this.getClass().getResource("/Images/jaune.gif"));
	private ImageIcon iconOrange = new ImageIcon(this.getClass().getResource("/Images/orange.gif"));
	private ImageIcon iconVert = new ImageIcon(this.getClass().getResource("/Images/vert.gif"));
	private ImageIcon iconTurquoise = new ImageIcon(this.getClass().getResource("/Images/turquoise.gif"));
	private ImageIcon iconViolet = new ImageIcon(this.getClass().getResource("/Images/violet.gif"));
	private ImageIcon iconPion = new ImageIcon(this.getClass().getResource("/Images/pion.png"));
	
	private JButton boutonBleu = new JButton(iconBleu);
	private JButton boutonRouge = new JButton(iconRouge);
	private JButton boutonNoir = new JButton(iconNoir);
	private JButton boutonJaune = new JButton(iconJaune);
	private JButton boutonOrange = new JButton(iconOrange);
	private JButton boutonVert = new JButton(iconVert);
	private JButton boutonTurquoise = new JButton(iconTurquoise);
	private JButton boutonViolet = new JButton(iconViolet);
	private JButton validerLigne = new JButton("Valider la ligne");
	private JButton effacerDernierPion = new JButton("Effacer dernier pion");
	private JButton effacerLigne = new JButton("Effacer Ligne");
	
	private int posPion,collones;
	private int[] proposition ={-1,-1,-1,-1};
	
	private Couleurs c = new Couleurs();
	
	private JLabel[] plateauJeu = new JLabel[4];
	private JLabel pion = new JLabel("Créer votre combinaison : ");
	
	public FenetreCreationCombinaison(){
		super("Master Mind") ;
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(container);
		container.setLayout(null);
		
		pion.setForeground(Color.WHITE);
		pion.setBounds(100, 10, 320, 40);
		
		boutonBleu.setBounds(50,50,40,40);
		boutonBleu.setBorderPainted(false);
		boutonRouge.setBounds(90,50,40,40);
		boutonRouge.setBorderPainted(false);
		boutonNoir.setBounds(130,50,40,40);
		boutonNoir.setBorderPainted(false);
		boutonJaune.setBounds(170,50,40,40);
		boutonJaune.setBorderPainted(false);
		boutonOrange.setBounds(210,50,40,40);
		boutonOrange.setBorderPainted(false);
		boutonVert.setBounds(250,50,40,40);
		boutonVert.setBorderPainted(false);
		boutonTurquoise.setBounds(290,50,40,40);
		boutonTurquoise.setBorderPainted(false);
		boutonViolet.setBounds(330,50,40,40);
		boutonViolet.setBorderPainted(false);
		container.add(boutonBleu);
		container.add(boutonRouge);
		container.add(boutonNoir);
		container.add(boutonJaune);
		container.add(boutonOrange);
		container.add(boutonVert);
		container.add(boutonTurquoise);
		container.add(boutonViolet);
		container.add(pion);
		
		//initialisation du plateauJeu par des cases vides
    		for( collones=0;collones<4;collones++){
    			plateauJeu[collones]= new JLabel(iconPion);
    			plateauJeu[collones].setBounds(collones*40+120,100, 40, 40);
    			container.add(plateauJeu[collones]);
    		}
    		
    	effacerDernierPion.setBounds(245, 150, 150, 40);
    	container.add(effacerDernierPion);
    	effacerLigne.setBounds(125, 150, 120, 40);
    	container.add(effacerLigne);
    	validerLigne.setBounds(05, 150, 120, 40);
    	container.add(validerLigne);
    	
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
    	
		this.setVisible(true);

	}

class PionBleu  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconBleu);
        	proposition[posPion]=c.idCouleur("bleu");
        	posPion++;
    	}else{
        		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
        	}
    }
    
}

class PionRouge  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconRouge);
        	proposition[posPion]=c.idCouleur("rouge");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}

class PionNoir  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconNoir);
        	proposition[posPion]=c.idCouleur("noir");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionJaune  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconJaune);
        	proposition[posPion]=c.idCouleur("jaune");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionOrange  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconOrange);
        	proposition[posPion]=c.idCouleur("orange");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionVert  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconVert);
        	proposition[posPion]=c.idCouleur("vert");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionTurquoise  implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconTurquoise);
        	proposition[posPion]=c.idCouleur("turquoise");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
    	}
    }
    
}
class PionViolet implements ActionListener{

    public void actionPerformed(ActionEvent arg) {
    	container.revalidate();
    	container.repaint();
    	if(posPion<4){
        	plateauJeu[posPion].setIcon(iconViolet);
        	proposition[posPion]=c.idCouleur("violet");
        	posPion++;
    	}else{
    		JOptionPane.showMessageDialog(container, "Ligne complète, Valider la ligne", "Message d'avertissement", JOptionPane.ERROR_MESSAGE) ;
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
    	plateauJeu[posPion].setIcon(iconPion);
    	}
    }	
}

class EffacerLigne  implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
    	container.revalidate();
    	container.repaint();
    	for(int i=posPion-1;i>=0;i--){
    		plateauJeu[i].setIcon(iconPion);
    		if(proposition[i]!=-1){
    			proposition[i]=-1;
    		}
    	}
    	posPion=0;
    }
}

class ValiderLigne  implements ActionListener{
    public void actionPerformed(ActionEvent arg0) {
    	container.revalidate();
    	container.repaint();
    	JFrame fen;
    	if(posPion==4){
    		Combinaison lacombi;
			ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
			lacombi = new Combinaison(proposition[0], proposition[1], proposition[2], proposition[3]);
			fen = new FenetrePrincipal("Difficile",lacombi);
			((JFrame) fen).getContentPane().add(panel);
    	}
    }
}
}

