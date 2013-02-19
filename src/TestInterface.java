import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame fenJoueur = new FenetreChoixJoueur();
		ImagePanel panel = new ImagePanel(new ImageIcon(fenJoueur.getClass().getResource("/Images/fd.png")).getImage());
		((JFrame) fenJoueur).getContentPane().add(panel);
		fenJoueur.setVisible(true);
		
	}
}
