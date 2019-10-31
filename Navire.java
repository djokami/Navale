package fr.uga.miashs.inff3.kamissod;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee [] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.nbTouchees=0;
		//partiesTouchees [null, null, null];
	}

	public Coordonnee getDebut() {
		return debut;
	}

	public void setDebut(Coordonnee debut) {
		this.debut = debut;
	}

	public Coordonnee getFin() {
		return fin;
	}

	public void setFin(Coordonnee fin) {
		this.fin = fin;
	}
	
}
