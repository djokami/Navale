package fr.uga.miashs.inff3.kamissod;

public class Coordonnee {
	private int ligne;
	private int colonne;
	public Coordonnee(String s) {
		colonne = s.toUpperCase().charAt(0)-'A';
		ligne = Integer.parseInt(s)-1;
	}
	public int getLine() {
		return ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public String toString(String affiche) {
		affiche = (char)(colonne)+String.valueOf(ligne+1);
		return affiche;
	}
	public boolean equals(Coordonnee o) {
		return (this.ligne==o.ligne)&&(this.colonne==o.colonne);
	}
	public boolean estVoisin(Coordonnee o) {
		return Math.abs(colonne-o.colonne)+Math.abs(ligne-o.ligne)==1;
	}
	public int compareTo(Coordonnee o) {
		int rest = ligne - o.ligne;
		if(rest ==0) {
			rest = colonne - o.colonne;
		}
		return rest;
	}
	
}
