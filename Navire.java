package net.kamissoko.selin.Miashs1920.TP5;

import java.util.Arrays;
import java.util.Scanner;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee [] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut,int longueur, boolean estVertical) {
		if(estVertical==false) {
			int ligneFin= debut.getLigne();
			int colonneFin = longueur-debut.getColonne();
			//fin = new Coordonnee(ligneFin, colonneFin);
			nbTouchees=0;
		}else{
			int colonneFin=debut.getColonne();
			int ligneFin= longueur-debut.getLigne();
			//fin=new Coordonnee(ligneFin,colonneFin);
			nbTouchees=0;
		}
	}
	public String toString() {
		String resultat;
		String d= debut.toString();
		String f = fin.toString();
		String t="";
		for (Coordonnee partie: partiesTouchees) {
			t+=partie.toString();
		}
		resultat="Navire [debut=" + d + ", fin=" + f + ", partiesTouchees=" + t + ", nbTouchees=" + nbTouchees + "]";

		return resultat;
	}
	public boolean contient(Coordonnee c) {
		boolean test1;
		boolean test2;
		test1=c.getLigne() >= this.debut.getLigne() && c.getLigne() >= this.fin.getLigne();
		test2=c.getColonne() >= this.debut.getColonne() && c.getColonne() <= this.fin.getColonne();
		return test1||test2;
	}
	private static boolean intersectionNonVide(int d1, int f1, int d2, int f2) {
		boolean test;
		test=d1 <= f2 && d2 <= f1;
		return test;
	}
	public boolean chevauche(Navire n) {
		boolean test1;
		boolean test2;
		test1=intersectionNonVide(debut.getLigne(),fin.getLigne(),n.debut.getLigne(),n.fin.getLigne());
		test2= intersectionNonVide(debut.getColonne(),fin.getColonne(),n.debut.getColonne(),n.fin.getColonne());

		return test1 || test2;
	}
	public boolean touche(Navire n) {
		boolean test1;
		boolean test2;
		test1=intersectionNonVide(debut.getLigne(),fin.getLigne(),n.debut.getLigne(),n.fin.getLigne())&&(debut.getColonne()==n.debut.getColonne()+1 ||
				debut.getColonne()==n.debut.getColonne()-1);
		test2= intersectionNonVide(debut.getColonne(),fin.getColonne(),n.debut.getColonne(),n.fin.getColonne()) && ( debut.getLigne() == n.debut.getLigne()+1 ||debut.getLigne()==
				n.debut.getLigne()-1) ;

		return test1 || test2;
	}
	public boolean estTouche(Coordonnee c) {
		for(Coordonnee partie:partiesTouchees) {
			if(c==partie)
				return true;
		}
		return	false;
	}
	public boolean recoitTir(Coordonnee c) {
	if(contient(c)) {
		nbTouchees ++;
		partiesTouchees[nbTouchees-1]=c;
		return true;
	}
	return false;
	}
	public boolean estCoule() {
		int taille= debut.getLigne()-fin.getLigne()+debut.getColonne()-fin.getColonne()+1;
		return taille==nbTouchees;
	}
}
