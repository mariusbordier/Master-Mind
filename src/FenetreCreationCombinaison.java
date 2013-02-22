import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private int lignes,collones;
	private JLabel[] plateauJeu = new JLabel[4];
	public FenetreCreationCombinaison(){
		super("Master Mind") ;
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setContentPane(container);
		container.setLayout(null);
		
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
		container.add(boutonBleu);
		container.add(boutonRouge);
		container.add(boutonNoir);
		container.add(boutonJaune);
		container.add(boutonOrange);
		container.add(boutonVert);
		container.add(boutonTurquoise);
		container.add(boutonViolet);
		
		//initialisation du plateauJeu par des cases vides
    		for( collones=0;collones<4;collones++){
    			plateauJeu[collones]= new JLabel(iconPion);
    			plateauJeu[collones].setBounds(collones*40+100,150+10, 40, 40);
    			container.add(plateauJeu[collones]);
    		}
     	
		this.setVisible(true);

	}
}
