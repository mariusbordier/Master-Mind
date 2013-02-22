import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreChoixJoueur extends JFrame implements ActionListener{
	
	private  JButton homme = new JButton("Homme vs Homme");
	private  JButton ordi = new JButton("Homme vs Ordinateur");
	private JLabel titre = new JLabel("Veuillez choisir une de ces deux options :");
	
	public FenetreChoixJoueur(){
		
	super("Master Mind") ;
	this.setSize(400, 600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setVisible(true);
	titre.setForeground(Color.WHITE);
	this.add(titre);
	this.add(homme);	
	this.add(ordi);
	titre.setBounds(80, 150, 300, 40);
	homme.setBounds(100, 200, 200, 40);
	ordi.setBounds(100, 250, 200, 40);
	homme.addActionListener(this);
	ordi.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homme) {
			this.hide();
			JFrame fen = new FenetreCreationCombinaison();
			ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
			((JFrame) fen).getContentPane().add(panel);
		}else {
			this.hide();
			JFrame fen = new FenetrePrincipal();
			ImagePanel panel = new ImagePanel(new ImageIcon(this.getClass().getResource("/Images/fd.png")).getImage());
			String[] difficulte = {"Facile", "Moyen", "Difficile"};
			Object res = JOptionPane.showInputDialog (fen, "Choisissez un niveau de difficulté","Master Mind",JOptionPane.QUESTION_MESSAGE,null,difficulte,difficulte[0]);
			if(res.toString()=="Facile"){
				fen = new FenetrePrincipal(res.toString());
				((JFrame) fen).getContentPane().add(panel);
			}
			else if(res.toString()=="Moyen"){
				fen = new FenetrePrincipal(res.toString());
				((JFrame) fen).getContentPane().add(panel);
			}else{
				fen = new FenetrePrincipal(res.toString());
				((JFrame) fen).getContentPane().add(panel);
			}
			fen.setVisible(true);
		}
	}


}
