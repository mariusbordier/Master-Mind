import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MeilleuresScores {
	
	private static final int NBMAX = 10;
	private static final String separateur = "\t";
	private static final String separateur2 = "_";
	private static final String fichier = "scores";
	private static ArrayList scores;

	public static void lire() {
		scores = new ArrayList();
		try {
	   BufferedReader in = new BufferedReader(new FileReader(fichier));
	   String s;
	   int i=0;
	   while ((s = in.readLine()) != null && i++ < NBMAX)
		   scores.add(s.split(separateur));
	   in.close();
   } catch (IOException e) {}
	}

	private static void write() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fichier));
			String[] s;
			out.flush();
			for(int j=0;j<NBMAX && j<scores.size();j++) {
				s=(String [])scores.get(j);
				out.println(s[0]+separateur+s[1]);
			}
			out.close();
		} catch (IOException e) {}
	}
	
	public static boolean checkItOut(int score, String nom) {
		if (score <= 0)
			return false;
		lire();
		String[] s;
		int size = scores.size();
		int i = 0;
		while(i < NBMAX && i < size && score > Integer.parseInt((s=(String [])scores.get(i))[1]))
			i++; 
		if(i<NBMAX || size==0) { 
			s = new String[2];
			s[0] = nom;
			s[1] = ""+score;
			scores.add(i,s);
			write();
			return true;
		}
		return false;
	}
	
	public static ArrayList getscore(){
		return scores;
	}

}