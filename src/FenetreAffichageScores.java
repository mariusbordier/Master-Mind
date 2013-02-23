import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class FenetreAffichageScores extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer i=0;
	private JLabel titre = new JLabel("Tableau des meilleures scores: ");
	private JLabel positionJoueur,labelPositionJoueur;
	private JLabel nomJoueur,labelNomJoueur;
	private JLabel scoreJoueur,labelScoreJoueur;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuprincipal = new JMenu("Fichier");
	private JMenuItem quitter = new JMenuItem("Quitter");
	
	public FenetreAffichageScores(){
		super("Master Mind") ;
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.menuprincipal.add(quitter);
		this.menuBar.add(menuprincipal);
		this.setJMenuBar(menuBar);
		this.menuBar.add(menuprincipal);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		MeilleuresScores.lire();
		
		titre.setBounds(50,20,220,50);
		titre.setForeground(Color.WHITE);
		this.add(titre);
		
		labelPositionJoueur = new JLabel("Position");
		labelNomJoueur = new JLabel("Prénom");
		labelScoreJoueur= new JLabel("Nombre de tours");
		labelPositionJoueur.setForeground(Color.white);
		labelNomJoueur.setForeground(Color.white);
		labelScoreJoueur.setForeground(Color.white);
		labelPositionJoueur.setBounds(50, 50, 100, 50);
		labelNomJoueur.setBounds(150, 50, 100, 50);
		labelScoreJoueur.setBounds(250, 50, 150, 50);
		this.add(labelPositionJoueur);
		this.add(labelNomJoueur);
		this.add(labelScoreJoueur);
		
		for(i=0;i<MeilleuresScores.getscore().size();i++){
			String[] s = (String[]) MeilleuresScores.getscore().get(i);
			Integer pos=i+1;
			positionJoueur =  new JLabel(pos.toString());
			nomJoueur = new JLabel(s[0]);
			scoreJoueur = new JLabel(s[1]);
			positionJoueur.setBounds(50,70+i*20, 100, 50);
			nomJoueur.setBounds(150,70+i*20, 100, 50);
			scoreJoueur.setBounds(250,70+i*20, 100, 50);
			this.add(positionJoueur);
			this.add(nomJoueur);
			this.add(scoreJoueur);
		}
		quitter.addActionListener(new MenuQuitter());

	}
class MenuQuitter  implements ActionListener{

	  public void actionPerformed(ActionEvent arg) {
		hide();
		Frame fenJoueur = new FenetreChoixJoueur();
		ImagePanel panel = new ImagePanel(new ImageIcon(fenJoueur.getClass().getResource("/Images/fd.png")).getImage());
		((JFrame) fenJoueur).getContentPane().add(panel);
	  }
	    
}
	
}
